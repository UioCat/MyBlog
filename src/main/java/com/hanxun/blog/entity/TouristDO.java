package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hanxun.blog.entity.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *  实体类
 * @author han xun
 * @date 2021-08-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tourist")
public class TouristDO extends BaseDO {


    private static final long serialVersionUID = -2878802666047558854L;
    /**
    * 账号
    */
    private String account;

    /**
    * 密码
    */
    private String password;

    /**
    * 头像图片
    */
    private String headPortraits;

    /**
    * 用户名
    */
    private String username;

}
