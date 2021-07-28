package com.hanxun.blog.dao;

import com.hanxun.blog.entity.TouristDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TouristDao {
    int deleteByPrimaryKey(Long id);

    int insert(TouristDO record);

    int insertSelective(TouristDO record);

    TouristDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TouristDO record);

    int updateByPrimaryKey(TouristDO record);

    TouristDO selectByAccount(String account);
}