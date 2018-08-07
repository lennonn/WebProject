package com.zlennon.website.mapper;

import com.zlennon.website.model.DbTag;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface DbTagMapper {
    int deleteByPrimaryKey(String id);

    int insert(DbTag record);

    DbTag selectByPrimaryKey(String id);

    List<DbTag> selectAll();

    int updateByPrimaryKey(DbTag record);

    int insertBatchSelective(List<DbTag> records);

    int updateBatchByPrimaryKeySelective(List<DbTag> records);
}