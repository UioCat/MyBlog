package com.hanxun.blog.batchmapper.impl;
import org.springframework.stereotype.Component;
import com.hanxun.blog.entity.TouristDO;
import com.hanxun.blog.mapper.TouristMapper;
import com.hanxun.blog.batchmapper.TouristBatchMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *  批量查询实现类
 * @author han xun
 * @date 2021-08-01
 */
@Component
public class TouristServiceImpl extends ServiceImpl<TouristMapper, TouristDO> implements TouristBatchMapper {

}
