package com.hanxun.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hanxun.blog.dto.ArticleQueryDTO;
import com.hanxun.blog.entity.Article;

public interface BlogService {

    /**
     * 新增文章
     * @param article
     * @return
     */
    public int addArticle(Article article);

    /**
     * 分页查询文章
     * @param articleQueryDTO
     * @return
     */
    public IPage<Article> selectPage(ArticleQueryDTO articleQueryDTO);
}
