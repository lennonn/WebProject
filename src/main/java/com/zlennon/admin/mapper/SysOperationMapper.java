package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysOperation;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface SysOperationMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysOperation record);

    SysOperation selectByPrimaryKey(String id);

    List<SysOperation> selectAll();

    int updateByPrimaryKey(SysOperation record);

    int insertBatchSelective(List<SysOperation> records);

    int updateBatchByPrimaryKeySelective(List<SysOperation> records);

    List<SysOperation> selectByQueryParams(@Param(value="search")String searchText);
}