package com.hanxun.blog.service;

import com.hanxun.blog.controller.req.TouristLoginReq;
import com.hanxun.blog.controller.req.TouristRegisterReq;
import com.hanxun.blog.dto.LoginInfoVO;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    /**
     * 游客注册
     * @param touristRegisterReq
     * @return
     */
    Boolean register(TouristRegisterReq touristRegisterReq);

    /**
     * 游客登录
     * @param loginReq
     * @return
     */
    LoginInfoVO login(TouristLoginReq loginReq, String ip, String userAgent);

    /**
     * 游客邮箱登录
     * @param loginReq
     * @param ip
     * @param userAgent
     * @return
     */
    LoginInfoVO loginByEmail(TouristLoginReq loginReq, String ip, String userAgent);
}
