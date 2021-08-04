package com.hanxun.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hanxun.blog.config.BlogConstant;
import com.hanxun.blog.controller.req.TouristLoginReq;
import com.hanxun.blog.controller.req.TouristRegisterReq;
import com.hanxun.blog.entity.InviteCodeDO;
import com.hanxun.blog.entity.TouristDO;
import com.hanxun.blog.entity.base.UserToken;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.mapper.InviteCodeMapper;
import com.hanxun.blog.mapper.TouristMapper;
import com.hanxun.blog.service.EmailService;
import com.hanxun.blog.service.LoginService;
import com.hanxun.blog.utils.JWTUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private TouristMapper touristMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<String,String> stringRedisTemplate;

    @Autowired
    private InviteCodeMapper inviteCodeMapper;

    @Value("${jwt.key}")
    private String jwtKey;

    /**
     * 游客注册
     * @param touristRegisterReq
     * @return
     */
    @Override
    @Transactional
    public Boolean register(TouristRegisterReq touristRegisterReq) {
        //数据校验
        if (StringUtils.isAnyBlank(touristRegisterReq.getEmail(), touristRegisterReq.getInviteCode(),
                touristRegisterReq.getPassword(), touristRegisterReq.getVerifyCode())) {
            throw new CustomException(BackEnum.PARAM_ERROR);
        }
        //判断账号是否存在
        QueryWrapper<TouristDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", touristRegisterReq.getEmail());
        TouristDO touristDO = touristMapper.selectOne(queryWrapper);
        if (null != touristDO) {
            throw new CustomException(BackEnum.ACCOUNT_USED);
        }

        //判断验证码是否正确
        String redisCode = stringRedisTemplate.opsForValue().get(touristRegisterReq.getEmail());
        if (StringUtils.isBlank(redisCode)) {
            throw new CustomException(BackEnum.THE_VERIFICATION_CODE_DOES_NOT_EXIST_OR_HAS_EXPIRED);
        }
        if (!StringUtils.equals(touristRegisterReq.getVerifyCode(), redisCode.substring(0,6))) {
            throw new CustomException(BackEnum.VERIFICATION_CODE_ERROR);
        }

        UpdateWrapper<InviteCodeDO> codeDOQueryWrapper = new UpdateWrapper<>();
        codeDOQueryWrapper.eq("code", touristRegisterReq.getInviteCode())
                .set("is_delete", BlogConstant.DELETE).set("gmt_modified", new Date());

        int update = inviteCodeMapper.update(null, codeDOQueryWrapper);
        if (update < 1) {
            throw new CustomException(BackEnum.NO_INVITE_CODE);
        }

        //密码加密
        String hashpw = BCrypt.hashpw(touristRegisterReq.getPassword(), BCrypt.gensalt());
        //插入数据库
        TouristDO tourist = new TouristDO();
        tourist.setAccount(touristRegisterReq.getEmail());
        tourist.setPassword(hashpw);
        tourist.setUsername(touristRegisterReq.getUsername());
        tourist.setGmtCreate(new Date());
        int row = touristMapper.insert(tourist);
        return row > 0;
    }

    /**
     * 游客登录
     * @param loginReq
     * @param loginReq
     * @return
     */
    @Override
    public String login(TouristLoginReq loginReq, String ip, String userAgent) {

        QueryWrapper<TouristDO> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("account", loginReq.getEmail());
        TouristDO touristInfo = touristMapper.selectOne(objectQueryWrapper);

        if (ObjectUtils.isEmpty(touristInfo)) {
            throw new CustomException(BackEnum.NO_USER);
        }
        if (BCrypt.checkpw(BCrypt.hashpw(loginReq.getPassword(), BCrypt.gensalt()), touristInfo.getPassword())) {
            throw new CustomException(BackEnum.PWD_ERROR);
        }

        //登录时间
        LocalDateTime issuedAt = LocalDateTime.now();

        //过期时间,半小时
        LocalDateTime expiresAt = issuedAt.plusSeconds(TimeUnit.MINUTES.toSeconds(30));

        // 距离过期时间剩余的秒数
        int expiresSeconds = (int) Duration.between(issuedAt, expiresAt).getSeconds();

        // 存储Session
        UserToken userToken = new UserToken();
        // 随机生成uuid，作为token的id
        userToken.setId(UUID.randomUUID().toString().replace("-", ""));
        userToken.setUserId(touristInfo.getId());
        userToken.setIssuedAt(issuedAt);
        userToken.setExpiresAt(expiresAt);
        userToken.setUserAgent(userAgent);
        userToken.setIp(ip);

        //序列化Token对象到Redis
        this.redisTemplate.opsForValue().set("token:"+ touristInfo.getId(), userToken, expiresSeconds, TimeUnit.SECONDS);

        //生成token信息
        return JWTUtil.getToken(touristInfo, userToken, jwtKey, issuedAt);
    }

}
