package com.hanxun.blog.service;

import com.hanxun.blog.controller.req.AddArticleReq;
import com.hanxun.blog.dto.MottoQuery;
import com.hanxun.blog.page.PageResult;

import java.util.List;

/**
 * @author han xun
 * Date 2021/8/3 22:13
 * Description:
 */
public interface ManagerService {


    /**
     * 生成一个新的邀请码
     * @return 生成的邀请码
     */
    String generateInviteCode();

    /**
     * 新增一个motto
     * @return
     */
    Boolean addMotto(String content);

    /**
     * 新增文章
     * @param addArticleReq
     * @return
     */
    Boolean addArticle(AddArticleReq addArticleReq);

    /**
     * 删除一个motto
     * @return
     */
    Boolean deleteMotto(Long id);

    /**
     * 分页查询motto
     * @param mottoQuery
     * @return
     */
    PageResult selectMotto(MottoQuery mottoQuery);
}
