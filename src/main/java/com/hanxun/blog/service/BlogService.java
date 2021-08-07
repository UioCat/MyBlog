package com.hanxun.blog.service;

import com.hanxun.blog.dto.IndexDTO;

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
}
