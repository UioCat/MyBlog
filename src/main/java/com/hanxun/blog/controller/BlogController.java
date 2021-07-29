package com.hanxun.blog.controller;

import com.hanxun.blog.entity.ArticleEntity;
import com.hanxun.blog.service.ArticleService;
import com.hanxun.blog.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han xun
 * Date 2021/7/25 23:27
 * Description: 展示博客控制器
 */
@RestController
public class BlogController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取首页接口
     * @return
     */
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

    @PostMapping("/addArticle")
    public BackMessage addArticle(@RequestBody ArticleEntity article){
        articleService.add(article);
        return BackMessage.success();
    }
}
