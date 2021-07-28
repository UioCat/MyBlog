package com.hanxun.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hanxun.blog.dto.ArticleQueryDTO;
import com.hanxun.blog.entity.ArticleDO;

public interface BlogService {

    /**
     * 新增文章
     * @param article
     * @return
     */
    int addArticle(ArticleDO article);

    /**
     * 分页查询文章
     * @param articleQueryDTO
     * @return
     */
    IPage<ArticleDO> selectPage(ArticleQueryDTO articleQueryDTO);
}
