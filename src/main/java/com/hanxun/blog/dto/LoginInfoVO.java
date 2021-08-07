package com.hanxun.blog.dto;

import lombok.Data;

@Data
public class LoginInfoVO {

    /**
     * 用户token
     */
    private String token;

    /**
     * 是否为管理员
     */
    private Boolean isAdmin = false;
}
