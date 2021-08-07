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
public class StarRecordDO extends BaseDO {


    private static final long serialVersionUID = 8385326576664307064L;
    /**
    * 文章id
    */
    private Long articleId;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 是否点赞
    */
    private Boolean star;

}
