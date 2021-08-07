package com.hanxun.blog.service;

import com.hanxun.blog.dto.ToEmail;
import com.hanxun.blog.utils.BackMessage;


/**
 * @author Alfred
 * @Description: 邮件发送类
 * @time 2021/7/15 18:39
 */

public interface EmailService {


    /**
     * 发送普通邮件
     * @param toEmail
     * @return
     */
    void commonEmail(ToEmail toEmail);

    /**
     * 发送验证码
     * @param email
     * @param type 1:登录 2:注册
     * @return
     */
    Boolean sendCode(String email, Integer type);


}
