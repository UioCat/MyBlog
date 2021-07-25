package com.hanxun.blog.service.impl;

import com.hanxun.blog.dao.TouristDao;
import com.hanxun.blog.entity.Tourist;
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
     * @param email
     * @param password
     * @param code
     * @return
     */
    @Override
    public Boolean register(String email, String password, String code) {
        //数据校验
        if (StringUtils.isAnyBlank(email, password, code)) {
            throw new CustomException(BackEnum.PARAM_ERROR);
        }

        //判断验证码是否正确
//        String redisCode = redisTemplate.opsForValue().get(email);
//        if (StringUtils.isBlank(redisCode)) {
//            throw new CustomException(BackEnum.THE_VERIFICATION_CODE_DOES_NOT_EXIST_OR_HAS_EXPIRED);
//        }
//        if (!StringUtils.equals(code, redisCode.substring(6))) {
//            throw new CustomException(BackEnum.VERIFICATION_CODE_ERROR);
//        }

        //密码加密
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        //插入数据库
        Tourist tourist = new Tourist();
        tourist.setAccount(email);
        tourist.setPassword(hashpw);
        tourist.setUsername(email);
        int row = touristDao.insertSelective(tourist);
        return row > 0;
    }

    /**
     * 游客登录
     * @param tourist
     * @return
     */
    @Override
    public String login(Tourist tourist) {
        Tourist touristInfo = touristDao.selectByAccount(tourist.getAccount());
        if (ObjectUtils.isEmpty(touristInfo)) {
            throw new CustomException(BackEnum.NO_USER);
        }
        if (BCrypt.checkpw(BCrypt.hashpw(tourist.getPassword(),BCrypt.gensalt()), touristInfo.getPassword())) {
            throw new CustomException(BackEnum.PWD_ERROR);
        }
        Tourist u = new Tourist();
        u.setPassword(tourist.getPassword());
        u.setUsername(tourist.getUsername());
        return JWTUtil.getToken(u);
    }

}
