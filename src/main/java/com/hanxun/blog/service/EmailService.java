package com.hanxun.blog.service;

import com.hanxun.blog.entity.ToEmail;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Alfred
 * @Description: 邮件发送类
 * @time 2021/7/15 18:39
 */

public interface EmailService {


    public BackMessage commonEmail(ToEmail toEmail);

    public String test();

}
