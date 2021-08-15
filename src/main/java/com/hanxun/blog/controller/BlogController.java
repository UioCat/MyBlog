package com.hanxun.blog.controller;

import com.hanxun.blog.controller.req.StarReq;
import com.hanxun.blog.dto.IndexDTO;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.page.PageRequestParam;
import com.hanxun.blog.page.PageResult;
import com.hanxun.blog.service.BlogService;
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
public class BlogController extends BaseController {

    @Autowired
    private BlogService blogService;

    /**
     * 获取首页接口
     * @return
     */
    @GetMapping("/getIndex")
    public BackMessage getIndex() {
        IndexDTO indexMessage = blogService.getIndexMessage();
        return new BackMessage<IndexDTO>(BackEnum.REQUEST_SUCCESS, indexMessage);
    }

    /**
     * 获取文章列表
     * @return
     */
    @GetMapping("/getArticleList")
    public BackMessage<PageResult> getArticleList(@RequestBody PageRequestParam pageRequestParam) {

        int pageNum = 0;
        int pageSize = 0;
        if (null != pageRequestParam.getPageNum()) {
            pageNum = pageRequestParam.getPageNum();
        }
        if (null != pageRequestParam.getPageSize()) {
            pageSize = pageRequestParam.getPageSize();
        }

        PageResult articleList = blogService.getArticleList(pageNum, pageSize);
        return null;
    }

    /**
     * 获取友联
     * @return
     */
    @GetMapping("/getLinks")
    public BackMessage getLinks() {
        return null;
    }

    /**
     * 点赞/取消点赞切换
     * @param starReq
     * @return
     */
    @PostMapping("/starSwitch")
    public BackMessage starSwitch(@RequestBody StarReq starReq) {
        Long userId = super.getUserId();
        blogService.starSwitch(userId, starReq.getArticleId());
        return BackMessage.success();
    }

    /**
     * 评论
     * @return
     */
    @PostMapping("/comment")
    public BackMessage comment() {
        return null;
    }
}
