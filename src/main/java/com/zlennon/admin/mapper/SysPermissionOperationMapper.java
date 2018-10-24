package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysPermissionOperation;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
@MapperScan
public interface SysPermissionOperationMapper {
    int deleteByPrimaryKey(String poId);

    int insert(SysPermissionOperation record);

    SysPermissionOperation selectByPrimaryKey(String poId);

    List<SysPermissionOperation> selectAll();

    int updateByPrimaryKey(SysPermissionOperation record);

    int insertBatchSelective(List<SysPermissionOperation> records);

    int updateBatchByPrimaryKeySelective(List<SysPermissionOperation> records);

    List<SysPermissionOperation> getByPermissionId(String permissionId);

    void deleteByPermissionId(String id);
}