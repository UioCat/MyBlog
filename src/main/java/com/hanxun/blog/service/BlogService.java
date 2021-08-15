package com.hanxun.blog.service;

import com.hanxun.blog.dto.IndexDTO;
import com.hanxun.blog.page.PageResult;

/**
 * @author han xun
 * Date 2021/8/7 12:25
 * Description: 博客基础
 */
public interface BlogService {

    /**
     * 获取首页信息
     * @return
     */
    IndexDTO getIndexMessage();

    /**
     * 获取文章列表
     * @return
     * @param pageNum
     * @param pageSize
     */
    PageResult getArticleList(int pageNum, int pageSize);

    /**
     * 点赞/取消点赞 切换
     * @param userId 用户id
     * @param articleId 文章id
     * @return
     */
    void starSwitch(Long userId, Long articleId);
}
