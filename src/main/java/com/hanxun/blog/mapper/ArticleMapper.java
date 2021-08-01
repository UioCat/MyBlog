package com.hanxun.blog.mapper;

import com.hanxun.blog.entity.ArticleDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *  Mapper接口
 * @author han xun
 * @date 2021-08-01
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleDO> {

}
