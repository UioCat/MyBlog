package com.hanxun.blog.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun
 * Date 2021/7/28 21:58
 * Description:
 */
@Getter
@Setter
@ToString
public class AddArticleReq {

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private String label;

    /**
     * 内容
     */
    private String content;

    /**
     * 简介
     */
    private String intro;

    /**
     * 首图
     */
    private String indexImage;
}
