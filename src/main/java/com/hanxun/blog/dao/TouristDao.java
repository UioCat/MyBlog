package com.hanxun.blog.dao;

import com.hanxun.blog.entity.Tourist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TouristDao {
    int deleteByPrimaryKey(Long id);

    int insert(Tourist record);

    int insertSelective(Tourist record);

    Tourist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tourist record);

    int updateByPrimaryKey(Tourist record);

    Tourist selectByAccount(String account);
}