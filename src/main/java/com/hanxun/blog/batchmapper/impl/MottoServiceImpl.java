package com.hanxun.blog.batchmapper.impl;
import org.springframework.stereotype.Component;
import com.hanxun.blog.entity.MottoDO;
import com.hanxun.blog.mapper.MottoMapper;
import com.hanxun.blog.batchmapper.MottoBatchMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *  批量查询实现类
 * @author han xun
 * @date 2021-08-01
 */
@Component
public class MottoServiceImpl extends ServiceImpl<MottoMapper, MottoDO> implements MottoBatchMapper {

}
