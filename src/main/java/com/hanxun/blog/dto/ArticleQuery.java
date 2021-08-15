package com.hanxun.blog.dto;

import com.hanxun.blog.page.PageRequestParam;
import lombok.Data;

@Data
public class ArticleQuery extends PageRequestParam {

    /**
     * 标题
     */
    private String articleTitle;
}
