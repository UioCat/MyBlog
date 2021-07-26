package com.hanxun.blog.dto;

import lombok.Data;

@Data
public class ArticleQueryDTO extends BasePageInfo{

    /**
     * 标题
     */
    private String articleTitle;
}
