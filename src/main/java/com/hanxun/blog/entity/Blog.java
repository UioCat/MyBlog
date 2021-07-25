package com.hanxun.blog.entity;

import lombok.Data;

/**
 * @author han xun
 * Date 2021/7/18 22:57
 * Description: 博客全局数据存储，配置
 */
@Data
public class Blog {

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 博主email
     */
    private String email;

    /**
     * 游客注册邀请码
     */
    private String invitationCode;

    /**
     * 博主密码
     */
    private String password;
}
