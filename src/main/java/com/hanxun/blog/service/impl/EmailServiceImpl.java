package com.hanxun.blog.service.impl;

import com.hanxun.blog.config.BlogConstant;
import com.hanxun.blog.dto.ToEmail;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.service.EmailService;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.utils.SendUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;


    /**
     * 发送普通邮件
     * @param toEmail
     * @return
     */
    @Override
    public void commonEmail(ToEmail toEmail) {
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(from);
        //发给谁
        message.setTo(toEmail.getTos());
        //邮件标题
        message.setSubject(toEmail.getSubject());
        //邮件内容
        message.setText(toEmail.getContent());
        try {
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            throw new CustomException(BackEnum.SEND_ORDINARY_MAIL_FAIL);
        }
    }

    /**
     * 发送验证码
     * @param email
     * @param type 1:登录 2:注册
     * @return
     */
    @Override
    public Boolean sendCode(String email, Integer type) {
        //进入发送逻辑的时候生成随机验证码，六位数字
        String sale = SendUtil.getRandomCode(6);

        Pattern p = Pattern.compile(BlogConstant.REGEX);
        Matcher m = p.matcher(email);
        boolean isMatch = m.matches();
        if (!isMatch) {
            throw new CustomException("邮箱格式不正确,请核对后重新输入!");
        } else {

            String emailKey = email;
            //判断验证码类型,注册key为mail,登录key为L+email
            if (type.equals(BlogConstant.LOGIN_TYPE)) {
                emailKey = "L" + emailKey;
            }

            //判断key是否存在
            if (redisTemplate.hasKey(emailKey)) {
                //判断发送间隔是否小于一分钟
                String oldTime = redisTemplate.opsForValue().get(emailKey).substring(6);
                if ((System.currentTimeMillis() / 1000 - Long.parseLong(oldTime)) < BlogConstant.MAIL_INTERVAL_TIME) {
                    throw new CustomException("间隔时间小于一分钟");
                }
                //刷新key
                redisTemplate.opsForValue().set(emailKey, sale + (System.currentTimeMillis() / 1000 ) ,  BlogConstant.MAIL_VALID_TIME, TimeUnit.SECONDS);
            } else {
                //新建key
                redisTemplate.opsForValue().set(emailKey, sale + (System.currentTimeMillis() / 1000 ) , BlogConstant.MAIL_VALID_TIME, TimeUnit.SECONDS);
            }

            //发送验证码
            ToEmail toEmail = new ToEmail();
            toEmail.setSubject(BlogConstant.MAIL_SUBJECT);

            // todo mail content use velocity template
            toEmail.setContent("您的验证码是: " + sale);
            String[] tos = {email};
            toEmail.setTos(tos);
            commonEmail(toEmail);
        }

        return true;
    }

}
