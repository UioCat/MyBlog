package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hanxun.blog.entity.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  实体类
 * @author han xun
 * @date 2021-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("article")
public class ArticleDO extends BaseDO {


    /**
    * 标题
    */
    private String articleTitle;

    /**
    * 标签
    */
    private String label;

    /**
    * 简介
    */
    private String intro;

    /**
    * 内容
    */
    private String content;

    /**
    * 点赞数
    */
    private Long starCount;

    /**
    * 浏览数
    */
    private Long browseTimes;

    /**
    * 首图
    */
    private String indexImage;

}
