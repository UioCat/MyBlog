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
    public BackMessage commonEmail(ToEmail toEmail);

    /**
     * 发送验证码
     * @param email
     * @return
     */
    public String sendCode(String email);


}
