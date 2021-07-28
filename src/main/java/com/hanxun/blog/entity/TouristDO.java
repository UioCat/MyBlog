package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 游客/访客实体类
 */
@Data
@TableName("tourist")
public class TouristDO implements Serializable {

    private static final long serialVersionUID = 3174418066100826932L;

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
