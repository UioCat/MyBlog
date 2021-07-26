package com.hanxun.blog.dto;

import lombok.Data;

@Data
public class BasePageInfo {

    /**
     * 总数
     */
    private Long total;

    /**
     * 每页数
     */
    private Long size = 10L;

    /**
     * 起始值
     */
    private Long current = 1L;

}
