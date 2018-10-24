package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysDictValue;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface SysDictValueMapper {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(SysDictValue record);

    SysDictValue selectByPrimaryKey(@Param("id") String id);

    List<SysDictValue> selectAll();

    int updateByPrimaryKey(SysDictValue record);

    int insertBatchSelective(List<SysDictValue> records);

    int updateBatchByPrimaryKeySelective(List<SysDictValue> records);

    List<SysDictValue> selectByQueryParams(@Param("search") String searchText,@Param("typeId") String typeId);

    List<SysDictValue> selectByTypeId(String typeId);
}