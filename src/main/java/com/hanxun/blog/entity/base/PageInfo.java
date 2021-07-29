package com.hanxun.blog.entity.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息
 *
 * @author Ling
 */
@Data
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总的记录条数
     */
    private Long totalNum;

    /**
     * 记录列表
     */
    private List<T> records;
    /**
     * 页码
     */
    private Long pageNum = Long.valueOf(1);

    /**
     * 每页显示长度
     */
    private Long pageSize = Long.valueOf(10);
}
