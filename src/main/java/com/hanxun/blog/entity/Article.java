package com.hanxun.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * 博客文章实体类
 */
@Data
public class Article {

    /**
     * id 主键
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
     * 文章名
     */
    private String articleName;

    /**
     * label数组 使用,分割，最多两个
     */
    private String labelArrays;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 作者
     */
    private String author;

    /**
     * 浏览次数
     */
    private Long browseTimes;

    /**
     * 点赞数
     */
    private Long starCount;
}
