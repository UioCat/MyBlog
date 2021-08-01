package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("article")
public class ArticleDO extends BaseDO {


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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
    * 修改时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    /**
    * 删除标记
    */
    private Boolean delete;

    /**
    * 点赞数
    */
    private Long starCount;

    /**
    * 浏览数
    */
    private Long browseTimes;

}
