package com.hanxun.blog.service;

import com.hanxun.blog.entity.Tourist;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    /**
     * 游客注册
     * @param email
     * @param password
     * @param code
     * @return
     */
    Boolean register(String email,String password, String code);

    /**
     * 游客登录
     * @param tourist
     * @return
     */
    String login(Tourist tourist);
}
