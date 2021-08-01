package com.hanxun.blog.entity.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Author: Ling
 * @Description:
 * @Date: Create in 2021/5/27
 **/
@Data
public class PageBaseDO {
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
