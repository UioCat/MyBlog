package com.hanxun.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanxun.blog.entity.StarRecordDO;
import com.hanxun.blog.mapper.StarRecordMapper;
import com.hanxun.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author han xun
 * Date 2021/8/1 21:21
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private StarRecordMapper starRecordMapper;

    /**
     * 点赞/取消点赞 切换
     * @param userId 用户id
     * @param articleId 文章id
     */
    @Override
    public void starSwitch(Long userId, Long articleId) {
        //查询是否存在点赞记录
        QueryWrapper<StarRecordDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("article_id", articleId);
        StarRecordDO starRecordDO = starRecordMapper.selectOne(queryWrapper);

        //不存在点赞记录,新增点赞
        if (null == starRecordDO) {
            StarRecordDO starRecordDO1 = new StarRecordDO();
            starRecordDO1.setStar(true);
            starRecordDO1.setUserId(userId);
            starRecordDO1.setArticleId(articleId);
            starRecordMapper.insert(starRecordDO1);
        }
        //存在点赞记录,修改状态
        else {
            starRecordDO.setStar(!starRecordDO.getStar());
            starRecordMapper.updateById(starRecordDO);
        }

    }
}
