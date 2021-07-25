package com.hanxun.blog.controller;

import com.hanxun.blog.utils.BackMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han xun
 * Date 2021/7/25 23:27
 * Description: 展示博客控制器
 */
@RestController
public class BlogController {

    @GetMapping("/getIndex")
    public BackMessage getIndex() {
        return null;
    }

    @GetMapping("/getArticleList")
    public BackMessage getArticleList() {
        return null;
    }

    @GetMapping("/getLinks")
    public BackMessage getLinks() {
        return null;
    }
}
