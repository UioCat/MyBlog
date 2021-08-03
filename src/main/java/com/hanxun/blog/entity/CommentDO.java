package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("comment")
public class CommentDO extends BaseDO {


    private static final long serialVersionUID = 9082348323788767835L;
    /**
    * 博客id
    */
    private Long blogId;

    /**
    * 评论者邮箱
    */
    private String email;

    /**
    * 评论内容
    */
    private String content;

}
