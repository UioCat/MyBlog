package com.hanxun.blog.service.impl;

import com.hanxun.blog.controller.req.AddArticleReq;
import com.hanxun.blog.entity.ArticleDO;
import com.hanxun.blog.entity.InviteCodeDO;
import com.hanxun.blog.entity.MottoDO;
import com.hanxun.blog.mapper.ArticleMapper;
import com.hanxun.blog.mapper.InviteCodeMapper;
import com.hanxun.blog.mapper.MottoMapper;
import com.hanxun.blog.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author han xun
 * Date 2021/8/3 22:16
 * Description:
 */
@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private MottoMapper mottoMapper;
    @Autowired
    private InviteCodeMapper inviteCodeMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public String generateInviteCode() {
        String code = UUID.randomUUID().toString();
        InviteCodeDO inviteCodeDO = new InviteCodeDO();
        inviteCodeDO.setCode(code);
        inviteCodeDO.setGmtCreate(new Date());
        log.info("generate invite code:{}", code);
        inviteCodeMapper.insert(inviteCodeDO);
        return code;
    }

    @Override
    public Boolean addMotto(String content) {
        MottoDO mottoDO = new MottoDO();
        mottoDO.setContent(content);
        return mottoMapper.insert(mottoDO) > 0;
    }

    @Override
    public Boolean addArticle(AddArticleReq addArticleReq) {
        ArticleDO articleDO = this.buildArticleDO(addArticleReq);
        //todo 标题重复比对
        int count = articleMapper.insert(articleDO);
        return count == 1;
    }

    private ArticleDO buildArticleDO(AddArticleReq addArticleReq) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setArticleTitle(addArticleReq.getTitle());
        articleDO.setContent(addArticleReq.getContent());
        articleDO.setIndexImage(addArticleReq.getIndexImage());
        articleDO.setIntro(addArticleReq.getIntro());
        articleDO.setLabel(addArticleReq.getLabel());
        return articleDO;
    }
}
