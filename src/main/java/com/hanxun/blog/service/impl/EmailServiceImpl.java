package com.hanxun.blog.service.impl;

import com.hanxun.blog.entity.ToEmail;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.service.EmailService;
import com.hanxun.blog.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public BackMessage commonEmail(ToEmail toEmail) {
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(from);
        //谁要接收
        message.setTo(toEmail.getTos());
        //邮件标题
        message.setSubject(toEmail.getSubject());
        //邮件内容
        message.setText(toEmail.getContent());
        try {
            mailSender.send(message);
            return new BackMessage(BackEnum.SEND_ORDINARY_MAIL_SUCCESSFULLY);
        } catch (MailException e) {
            e.printStackTrace();
            return new BackMessage(BackEnum.SEND_ORDINARY_MAIL_FAIL);
        }
    }

    @Override
    public String test() {
        return "测试成功";
    }
}
