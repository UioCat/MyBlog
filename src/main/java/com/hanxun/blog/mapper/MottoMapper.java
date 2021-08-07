package com.hanxun.blog.mapper;

import com.hanxun.blog.dto.MottoQuery;
import com.hanxun.blog.entity.MottoDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  Mapper接口
 * @author han xun
 * @date 2021-08-07
 */
@Mapper
public interface MottoMapper extends BaseMapper<MottoDO> {

     List<MottoDO> selectAllMotto(MottoQuery mottoQuery);
}
