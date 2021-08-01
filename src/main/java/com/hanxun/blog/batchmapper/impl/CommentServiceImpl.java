package com.hanxun.blog.batchmapper.impl;
import org.springframework.stereotype.Component;
import com.hanxun.blog.entity.CommentDO;
import com.hanxun.blog.mapper.CommentMapper;
import com.hanxun.blog.batchmapper.CommentBatchMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *  批量查询实现类
 * @author han xun
 * @date 2021-08-01
 */
@Component
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentDO> implements CommentBatchMapper {

}
