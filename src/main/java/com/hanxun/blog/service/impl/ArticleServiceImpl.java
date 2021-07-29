package com.hanxun.blog.service.impl;

import com.hanxun.blog.entity.ArticleEntity;
import com.hanxun.blog.batchmapper.ArticleBatchMapper;
import com.hanxun.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import com.hanxun.blog.utils.PageUtils;
import com.hanxun.blog.entity.base.PageInfo;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author code-generator
 * @since 2021-07-29
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleBatchMapper articleBatchMapper;
    /**
    * 分页列表
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public PageInfo<ArticleEntity> page(ArticleEntity param) {

        QueryWrapper<ArticleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
         // 主键
           .eq(param.getId() != null, ArticleEntity::getId, param.getId())
                 // 标题
           .eq(!StringUtils.isEmpty(param.getArticleTitle()), ArticleEntity::getArticleTitle, param.getArticleTitle())
                 // 内容
           .eq(!StringUtils.isEmpty(param.getContent()), ArticleEntity::getContent, param.getContent())
                 // 作者id
           .eq(param.getAuthorId() != null, ArticleEntity::getAuthorId, param.getAuthorId())
                 // 创建时间
           .eq(param.getGmtCreate() != null, ArticleEntity::getGmtCreate, param.getGmtCreate())
                 // 修改时间
           .eq(param.getGmtModified() != null, ArticleEntity::getGmtModified, param.getGmtModified())
                 // 点赞数
           .eq(param.getStarCount() != null, ArticleEntity::getStarCount, param.getStarCount())
                 // 浏览数
           .eq(param.getBrowseTimes() != null, ArticleEntity::getBrowseTimes, param.getBrowseTimes())
        ;

        Page<ArticleEntity> page = new Page<>(param.getPageNum(),param.getPageSize());
        IPage<ArticleEntity> ipage = articleBatchMapper.page(page, queryWrapper);

        PageInfo pageInfo = PageUtils.getPage(ipage);
        return pageInfo;
    }

    /**
    * 新增
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ArticleEntity param) {
        param.setGmtCreate(LocalDateTime.now());
        if (!articleBatchMapper.save(param)) {
            throw new CustomException(BackEnum.INSERT_FAILED);
        }
    }

    /**
    * 修改
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(ArticleEntity param) {
        if (!articleBatchMapper.updateById(param)) {
            throw new CustomException(BackEnum.UPDATE_FAILED);
        }
    }

    /**
    * 删除(单个条目)
    * @param id
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeById(Long id) {
        if(!articleBatchMapper.removeById(id)){
            throw new CustomException(BackEnum.DELETE_FAILED);
        }
    }
}
