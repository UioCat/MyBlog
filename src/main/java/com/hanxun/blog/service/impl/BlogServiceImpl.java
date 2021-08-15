package com.hanxun.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanxun.blog.config.BlogConstant;
import com.hanxun.blog.dto.ArticleQuery;
import com.hanxun.blog.dto.IndexDTO;
import com.hanxun.blog.entity.ArticleDO;
import com.hanxun.blog.entity.MottoDO;
import com.hanxun.blog.entity.StarRecordDO;
import com.hanxun.blog.mapper.ArticleMapper;
import com.hanxun.blog.mapper.MottoMapper;
import com.hanxun.blog.mapper.StarRecordMapper;
import com.hanxun.blog.page.PageResult;
import com.hanxun.blog.page.PageUtils;
import com.hanxun.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
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
    @Autowired
    private StarRecordMapper starRecordMapper;
    @Autowired
    private ArticleMapper articleMapper;

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
            log.info("get index data by cache");
            indexDTO = JSON.parseObject(indexMessage, IndexDTO.class);
        }
        log.info("return indexDTO:{}", JSON.toJSONString(indexDTO));
        return indexDTO;
    }

    @Override
    public PageResult getArticleList(ArticleQuery articleQuery) {
        //开始分页查询
        PageHelper.startPage(articleQuery.getPageNum(), articleQuery.getPageSize());
        List<ArticleDO> articleDOS = articleMapper.selectAllArticle(articleQuery);
        //封装分页信息
        PageResult pageResult = PageUtils.getPageResult(articleQuery, new PageInfo<>(articleDOS));
        return pageResult;
    }

    /**
     * 点赞/取消点赞 切换
     * @param userId 用户id
     * @param articleId 文章id
     */
    @Override
    public void starSwitch(Long userId, Long articleId) {
        //查询是否存在点赞记录
        QueryWrapper<StarRecordDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("article_id", articleId);
        StarRecordDO starRecordDO = starRecordMapper.selectOne(queryWrapper);

        //不存在点赞记录,新增点赞
        if (null == starRecordDO) {
            StarRecordDO starRecordDO1 = new StarRecordDO();
            starRecordDO1.setStar(true);
            starRecordDO1.setUserId(userId);
            starRecordDO1.setArticleId(articleId);
            starRecordMapper.insert(starRecordDO1);
        }
        //存在点赞记录,修改状态
        else {
            starRecordDO.setStar(!starRecordDO.getStar());
            starRecordMapper.updateById(starRecordDO);
        }

    }
}
