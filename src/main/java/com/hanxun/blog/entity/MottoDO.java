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
public class MottoDO extends BaseDO {


    private static final long serialVersionUID = -740862685749543857L;
    /**
    * 内容
    */
    private String content;

}
