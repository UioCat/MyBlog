package com.hanxun.blog.dto;

import com.hanxun.blog.page.PageRequestParam;
import lombok.Data;

@Data
public class MottoQuery extends PageRequestParam {

    /**
     * 内容
     */
    private String content;
}
