package com.hanxun.blog.service;

import com.hanxun.blog.controller.req.StarReq;
import com.hanxun.blog.utils.BackMessage;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author han xun
 * Date 2021/8/1 21:21
 * Description:
 */
public interface ArticleService {


    /**
     * 点赞/取消点赞 切换
     * @param userId 用户id
     * @param articleId 文章id
     * @return
     */
    void starSwitch(Long userId, Long articleId);
}
