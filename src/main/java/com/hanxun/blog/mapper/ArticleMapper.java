package com.hanxun.blog.mapper;

import com.hanxun.blog.dto.ArticleQuery;
import com.hanxun.blog.entity.ArticleDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  Mapper接口
 * @author han xun
 * @date 2021-08-07
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleDO> {

    List<ArticleDO> selectAllArticle(ArticleQuery articleQuery);
}
