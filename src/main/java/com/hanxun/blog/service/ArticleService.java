package com.hanxun.blog.service;

import com.hanxun.blog.entity.ArticleEntity;
import com.hanxun.blog.entity.base.PageInfo;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author code-generator
 * @since 2021-07-29
 */
public interface ArticleService {

    /**
    * 分页列表
    * @param param 根据需要进行传值
    * @return
    */
    PageInfo<ArticleEntity> page(ArticleEntity param);

    /**
    * 新增
    * @param param 根据需要进行传值
    * @return
    */
    void add(ArticleEntity param);

    /**
    * 修改
    * @param param 根据需要进行传值
    * @return
    */
    void updateById(ArticleEntity param);

    /**
    * 删除(单个条目)
    * @param id
    * @return
    */
    void removeById(Long id);
}
