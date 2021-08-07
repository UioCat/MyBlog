package com.hanxun.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanxun.blog.config.BlogConstant;
import com.hanxun.blog.dto.IndexDTO;
import com.hanxun.blog.entity.MottoDO;
import com.hanxun.blog.mapper.MottoMapper;
import com.hanxun.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author han xun
 * Date 2021/8/7 12:26
 * Description:
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private MottoMapper mottoMapper;

    @Value("${admin.title}")
    private String title;

    @Override
    public IndexDTO getIndexMessage() {
        // 先从缓存获取，缓存不存在则从数据库取，在刷入缓存
        String indexMessage = redisTemplate.opsForValue().get(BlogConstant.INDEX_KEY);
        IndexDTO indexDTO = null;
        if (null == indexMessage) {
            log.warn("no index data in cache");
            List<MottoDO> mottoDOList = mottoMapper.selectList(new QueryWrapper<MottoDO>().eq("is_delete", BlogConstant.EXIST));
            int value = new Random().nextInt(mottoDOList.size()); // 随机数
            String motto = mottoDOList.get(value).getContent();
            indexDTO = new IndexDTO();
            indexDTO.setMotto(motto);
            indexDTO.setTitle(title);
            redisTemplate.opsForValue().set(BlogConstant.INDEX_KEY, JSON.toJSONString(indexDTO), BlogConstant.INDEX_CACHE_TIME);
        } else {
            indexDTO = JSON.parseObject(indexMessage, IndexDTO.class);
        }
        log.info("return indexDTO:{}", JSON.toJSONString(indexDTO));
        return indexDTO;
    }
}
