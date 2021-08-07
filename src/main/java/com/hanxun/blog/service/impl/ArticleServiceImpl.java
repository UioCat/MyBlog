package com.hanxun.blog.service.impl;

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

    @Override
    public void starSwitch(Long userId, Long articleId) {
        

    }
}
