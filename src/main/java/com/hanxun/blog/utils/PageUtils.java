package com.hanxun.blog.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hanxun.blog.entity.base.PageInfo;

/**
 * 分页工具类
 *
 * @author Ling
 */
public class PageUtils {

    public static <T> PageInfo<T> getPage(IPage<T> page){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(page.getCurrent());
        pageInfo.setPageSize(page.getSize());
        pageInfo.setTotalNum(page.getTotal());
        pageInfo.setRecords(page.getRecords());

        return pageInfo;
    }
}
