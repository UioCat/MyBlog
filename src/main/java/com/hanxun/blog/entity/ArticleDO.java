package com.hanxun.blog.entity;

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
public class ArticleDO extends BaseDO {


    private static final long serialVersionUID = 5645043787086620875L;
    /**
    * 标题
    */
    private String articleTitle;

    /**
    * 内容
    */
    private String content;

    /**
    * 作者id
    */
    private Long authorId;

    /**
    * 点赞数
    */
    private Long starCount;

    /**
    * 浏览数
    */
    private Long browseTimes;

}
