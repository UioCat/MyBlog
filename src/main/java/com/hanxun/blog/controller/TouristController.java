//package com.hanxun.blog.controller;
//
//import com.hanxun.blog.controller.req.TouristLoginReq;
//import com.hanxun.blog.controller.req.TouristRegisterReq;
//import com.hanxun.blog.enums.BackEnum;
//import com.hanxun.blog.exception.CustomException;
//import com.hanxun.blog.service.EmailService;
//import com.hanxun.blog.service.LoginService;
//import com.hanxun.blog.utils.BackMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author han xun
// * Date 2021/7/18 22:54
// * Description: 游客控制页
// */
//@RestController
//@RequestMapping("tourist")
//public class TouristController {
//
//    @Autowired
//    private EmailService emailService;
//    @Autowired
//    private LoginService loginService;
//
//    /**
//     * 游客登陆
//     * @return
//     */
//    @PostMapping("/login")
//    public BackMessage login(HttpServletRequest request, HttpServletResponse response, @RequestBody TouristLoginReq touristLoginReq) {
//        //登录信息
//        String ip = request.getRemoteAddr();
//        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
//
//        String token = loginService.login(touristLoginReq, ip, userAgent);
//        return BackMessage.success(token);
//
//    }
//
//    /**
//     * 游客注册
//     * @return
//     */
//    @GetMapping("/register")
//    public BackMessage register(@RequestBody TouristRegisterReq touristRegisterReq) {
//        if (loginService.register(touristRegisterReq)) {
//            return BackMessage.success();
//        }
//        return BackMessage.error();
//    }
//
//    /**
//     * 发送注册验证码
//     * @return
//     */
//    @GetMapping("/sendCode")
//    public BackMessage sendCode(String email) {
//        if (!emailService.sendCode(email)) {
//            throw new CustomException(BackEnum.SEND_CODE_FAIL);
//        }
//        return BackMessage.success();
//    }
//
//    /**
//     * 评论
//     * @return
//     */
//    @PostMapping("/comment")
//    public BackMessage comment() {
//        return null;
//    }
//
//    /**
//     * 游客点赞接口
//     * @return
//     */
//    @PostMapping("/star")
//    public BackMessage star() {
//        return null;
//    }
//
//
//    @GetMapping("/loginSuccess")
//    public BackMessage loginSuccess(){
//        return BackMessage.success("你已经登陆");
//    }
//}
