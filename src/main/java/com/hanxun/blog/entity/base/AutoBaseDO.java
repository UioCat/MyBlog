package com.hanxun.blog.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用基础entity类
 */
@Data
public class AutoBaseDO implements Serializable {

    private static final long serialVersionUID = -1768391455906418035L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableLogic
    private Integer deleteFlag = 0;

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
