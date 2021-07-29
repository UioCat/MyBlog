package com.hanxun.blog.batchmapper.impl;
import org.springframework.stereotype.Component;
import com.hanxun.blog.entity.ArticleEntity;
import com.hanxun.blog.mapper.ArticleMapper;
import com.hanxun.blog.batchmapper.ArticleBatchMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
* <p>
    *  存储实现类
    * </p>
*
* @author code-generator
* @since 2021-07-29
*/
@Component
public class ArticleBatchMapperImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleBatchMapper {

}
