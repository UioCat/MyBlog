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
@TableName("invite_code")
public class InviteCodeDO extends BaseDO {


    /**
    * 邀请码
    */
    private String code;

}
