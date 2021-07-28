package com.hanxun.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanxun.blog.entity.ArticleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseMapper<ArticleDO> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(ArticleDO record);

    ArticleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleDO record);

    int updateByPrimaryKey(ArticleDO record);
}