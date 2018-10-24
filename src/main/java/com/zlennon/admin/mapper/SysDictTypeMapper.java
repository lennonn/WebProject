package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysDictType;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface SysDictTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysDictType record);

    SysDictType selectByPrimaryKey(String id);

    List<SysDictType> selectAll();

    int updateByPrimaryKey(SysDictType record);

    int insertBatchSelective(List<SysDictType> records);

    int updateBatchByPrimaryKeySelective(List<SysDictType> records);

    List<SysDictType> selectByQueryParams(String searchText);
}