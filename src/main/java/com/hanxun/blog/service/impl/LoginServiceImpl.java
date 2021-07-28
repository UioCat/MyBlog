package com.hanxun.blog.service.impl;

import com.hanxun.blog.controller.req.TouristLoginReq;
import com.hanxun.blog.controller.req.TouristRegisterReq;
import com.hanxun.blog.dao.TouristDao;
import com.hanxun.blog.entity.TouristDO;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.service.EmailService;
import com.hanxun.blog.service.LoginService;
import com.hanxun.blog.utils.JWTUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TouristDao touristDao;

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

        //判断验证码是否正确
        String redisCode = redisTemplate.opsForValue().get(touristRegisterReq.getEmail());
        if (StringUtils.isBlank(redisCode)) {
            throw new CustomException(BackEnum.THE_VERIFICATION_CODE_DOES_NOT_EXIST_OR_HAS_EXPIRED);
        }
        if (!StringUtils.equals(touristRegisterReq.getVerifyCode(), redisCode.substring(6))) {
            throw new CustomException(BackEnum.VERIFICATION_CODE_ERROR);
        }
        // todo 查询邀请码是否存在，并将该邀请码置为失效

        //密码加密
        String hashpw = BCrypt.hashpw(touristRegisterReq.getPassword(), BCrypt.gensalt());
        //插入数据库
        TouristDO tourist = new TouristDO();
        tourist.setAccount(touristRegisterReq.getEmail());
        tourist.setPassword(hashpw);
        tourist.setUsername(touristRegisterReq.getUsername());
        int row = touristDao.insertSelective(tourist);
        return row > 0;
    }

    /**
     * 游客登录
     * @param loginReq
     * @return
     */
    @Override
    public String login(TouristLoginReq loginReq) {
        TouristDO touristInfo = touristDao.selectByAccount(loginReq.getEmail());
        if (ObjectUtils.isEmpty(touristInfo)) {
            throw new CustomException(BackEnum.NO_USER);
        }
        if (BCrypt.checkpw(BCrypt.hashpw(loginReq.getPassword(),BCrypt.gensalt()), touristInfo.getPassword())) {
            throw new CustomException(BackEnum.PWD_ERROR);
        }
        TouristDO u = new TouristDO();
        u.setPassword(u.getPassword());
        u.setUsername(u.getUsername());
        return JWTUtil.getToken(u);
    }

}
