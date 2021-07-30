package com.hanxun.blog.service;

import com.hanxun.blog.controller.req.TouristLoginReq;
import com.hanxun.blog.controller.req.TouristRegisterReq;
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
    String login(TouristLoginReq loginReq, String ip, String userAgent);
}
