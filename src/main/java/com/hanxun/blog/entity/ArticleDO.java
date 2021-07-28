package com.hanxun.blog.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
@TableName(value = "article")
public class ArticleDO implements Serializable {

    private static final long serialVersionUID = 7993296555636685540L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtModified;

    /**
     * 删除标记
     */
    private Byte isDelete;

    /**
     * 点赞数
     */
    private Long starCount;

    /**
     * 浏览数
     */
    private Long browseTimes;

}