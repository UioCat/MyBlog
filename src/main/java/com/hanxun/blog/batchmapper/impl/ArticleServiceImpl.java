package com.hanxun.blog.batchmapper.impl;
import org.springframework.stereotype.Component;
import com.hanxun.blog.entity.ArticleDO;
import com.hanxun.blog.mapper.ArticleMapper;
import com.hanxun.blog.batchmapper.ArticleBatchMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *  批量查询实现类
 * @author han xun
 * @date 2021-08-01
 */
@Component
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleDO> implements ArticleBatchMapper {

}
