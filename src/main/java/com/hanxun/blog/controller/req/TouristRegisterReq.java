package com.hanxun.blog.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun
 * Date 2021/7/28 21:23
 * Description:
 */
@Getter
@Setter
@ToString
public class TouristRegisterReq {

    /**
     * 注册邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String verifyCode;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 用户名
     */
    private String username;
}
