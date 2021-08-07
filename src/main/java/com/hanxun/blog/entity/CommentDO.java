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
@TableName("comment")
public class CommentDO extends BaseDO {


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
