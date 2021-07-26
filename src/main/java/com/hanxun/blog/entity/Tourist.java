package com.hanxun.blog.entity;

import lombok.Data;

/**
 * 游客/访客实体类
 */
@Data
public class Tourist {

    /**
     * id
     */
    private Long id;

    /**
     * 账号，默认为email
     */
    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像图片，Base64字符串
     */
    private String headPortraits;
}
