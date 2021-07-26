package com.hanxun.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanxun.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}