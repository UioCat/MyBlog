package com.hanxun.blog.controller;

import com.hanxun.blog.entity.Tourist;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.service.EmailService;
import com.hanxun.blog.service.LoginService;
import com.hanxun.blog.utils.BackMessage;
import com.hanxun.blog.utils.JWTUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author han xun
 * Date 2021/7/18 22:54
 * Description: 游客控制页
 */
@RestController
@RequestMapping("tourist")
public class TouristController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private LoginService loginService;

    /**
     * 游客登陆
     * @return
     */
    @PostMapping("/login")
    public BackMessage login(@RequestBody Tourist tourist) {
        String token = loginService.login(tourist);
        return new BackMessage(token);
    }


    /**
     * 游客注册
     * @return
     */
    @GetMapping("/register")
    public BackMessage register(@RequestParam("email") String email,@RequestParam("password") String password,
                                @RequestParam("code") String code) {
        if (loginService.register(email,password,code)) {
            return BackMessage.success();
        }
        return BackMessage.error();
    }

    /**
     * 发送注册验证码
     * @return
     */
    public BackMessage sendCode(String email) {
        if (!emailService.sendCode(email)) {
            throw new CustomException(BackEnum.SEND_CODE_FAIL);
        }
        return BackMessage.success();
    }

    /**
     * 评论
     * @return
     */
    public BackMessage comment() {
        return null;
    }

    /**
     * 游客点赞接口
     * @return
     */
    public BackMessage star() {
        return null;
    }

    @GetMapping("/loginSuccess")
    public BackMessage loginSuccess(){
        return new BackMessage("你已经登陆");
    }
}
