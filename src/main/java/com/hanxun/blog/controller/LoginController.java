package com.hanxun.blog.controller;

import com.hanxun.blog.config.BlogConstant;
import com.hanxun.blog.controller.req.TouristLoginReq;
import com.hanxun.blog.controller.req.TouristRegisterReq;
import com.hanxun.blog.dto.LoginInfoVO;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.service.EmailService;
import com.hanxun.blog.service.LoginService;
import com.hanxun.blog.utils.BackMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author han xun
 * Date 2021/7/18 22:54
 * Description: 游客控制页
 */
@RestController
@RequestMapping("permission")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private LoginService loginService;

    /**
     * 游客登陆
     * @return
     */
    @PostMapping("/login")
    public BackMessage login(HttpServletRequest request, @RequestBody TouristLoginReq touristLoginReq) {
        //登录信息
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        log.info("user login ip:{}, UA:{}, email:{}", ip, userAgent, touristLoginReq.getEmail());
        LoginInfoVO token = loginService.login(touristLoginReq, ip, userAgent);
        return new BackMessage(BackEnum.REQUEST_SUCCESS,token);
    }

    /**
     * 邮箱验证码登录
     * @return
     */
    @PostMapping("/loginByEmail")
    public BackMessage loginByEmail(HttpServletRequest request, @RequestBody TouristLoginReq touristLoginReq) {
        //登录信息
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        log.info("user login ip:{}, UA:{}, email:{}", ip, userAgent, touristLoginReq.getEmail());
        LoginInfoVO token = loginService.loginByEmail(touristLoginReq, ip, userAgent);
        return new BackMessage(BackEnum.REQUEST_SUCCESS,token);

    }

    /**
     * 游客注册
     * @return
     */
    @PostMapping("/register")
    public BackMessage register(@RequestBody TouristRegisterReq touristRegisterReq) {
        if (loginService.register(touristRegisterReq)) {
            return BackMessage.success();
        }
        return BackMessage.error();
    }

    /**
     * 发送注册验证码
     * @param email
     * @param type 1:登录 2:注册
     * @return
     */
    @GetMapping("/sendCode")
    public BackMessage sendCode(@RequestParam("email") String email, @RequestParam("type") Integer type) {
        if (!emailService.sendCode(email, type)) {
            throw new CustomException(BackEnum.SEND_CODE_FAIL);
        }
        String info = "有效时间" + BlogConstant.MAIL_VALID_TIME / 60 + "分钟";
        return BackMessage.success(info);
    }

    @GetMapping("/loginSuccess")
    public BackMessage loginSuccess() {
        return BackMessage.success("你已经登陆");
    }
}
