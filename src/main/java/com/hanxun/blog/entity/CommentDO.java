package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author han xun
 * Date 2021/7/18 23:16
 * Description: 评论
 */
@Data
@TableName("comment")
public class CommentDO implements Serializable {

    private static final long serialVersionUID = -8308995847521899198L;
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
