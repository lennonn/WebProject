package com.zlennon.website.mapper;

import com.zlennon.website.model.DbTagList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface DbTagListMapper {
    int deleteByPrimaryKey(String id);

    int insert(DbTagList record);

    DbTagList selectByPrimaryKey(String id);

    List<DbTagList> selectAll();

    int updateByPrimaryKey(DbTagList record);

    int insertBatchSelective(List<DbTagList> records);

    int updateBatchByPrimaryKeySelective(List<DbTagList> records);

    List<Map<Float,Long>> groupByStar();
}