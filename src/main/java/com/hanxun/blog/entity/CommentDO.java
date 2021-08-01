package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.hanxun.blog.entity.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *  实体类
 * @author han xun
 * @date 2021-08-01
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
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
    * 修改时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    /**
    * 是否删除
    */
    private Boolean delete;

    /**
    * 评论者邮箱
    */
    private String email;

    /**
    * 评论内容
    */
    private String content;

}
