package com.hanxun.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author han xun
 * Date 2021/7/18 23:16
 * Description: 评论
 */
@Data
public class Comment {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 是否删除
     */
    private Byte isDelete;

    /**
     * 评论者邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 博客id
     */
    private Long blogId;
}
