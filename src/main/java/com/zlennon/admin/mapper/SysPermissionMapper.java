package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysPermission;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@MapperScan
@Repository
public interface SysPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysPermission record);

    SysPermission selectByPrimaryKey(String id);

    List<SysPermission> selectAll();

    int updateByPrimaryKey(SysPermission record);

    int insertBatchSelective(List<SysPermission> records);

    int updateBatchByPrimaryKeySelective(List<SysPermission> records);
}