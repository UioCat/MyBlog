package com.hanxun.blog.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 通用基础entity类
 */
@Data
public class BaseDO {

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableLogic
    private Boolean delete = false;

    /**
     * 总的记录条数
     */
    @TableField(exist = false)
    private Long totalNum;

    /**
     * 页码
     */
    @TableField(exist = false)
    private Long pageNum = 1L;

    /**
     * 每页显示长度
     */
    @TableField(exist = false)
    private Long pageSize = 10L;
}
