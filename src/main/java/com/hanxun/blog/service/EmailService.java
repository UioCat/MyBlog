package com.hanxun.blog.service;

import com.hanxun.blog.entity.ToEmail;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Alfred
 * @Description: 邮件发送类
 * @time 2021/7/15 18:39
 */

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

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

}
