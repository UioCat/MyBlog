package com.hanxun.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanxun.blog.dao.ArticleDao;
import com.hanxun.blog.dto.ArticleQueryDTO;
import com.hanxun.blog.entity.ArticleDO;
import com.hanxun.blog.service.BlogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 新增文章
     * @param article
     * @return
     */
    @Override
    public int addArticle(ArticleDO article) {
        return articleDao.insert(article);
    }

    /**
     * 分页查询文章
     * @param articleQueryDTO
     * @return
     */
    @Override
    public IPage<ArticleDO> selectPage(ArticleQueryDTO articleQueryDTO) {
        LambdaQueryWrapper<ArticleDO> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(articleQueryDTO.getArticleTitle()),
                ArticleDO::getArticleTitle,articleQueryDTO.getArticleTitle());

        Page<ArticleDO> page = new Page<>(articleQueryDTO.getCurrent(),articleQueryDTO.getSize());
        IPage<ArticleDO> iPage = articleDao.selectPage(page, lambdaQueryWrapper);
        return iPage;
    }


}
