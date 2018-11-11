package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysRolePermission;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
@Repository
@MapperScan
public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(String rpId);

    int insert(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String rpId);

    List<SysRolePermission> selectAll();

    int updateByPrimaryKey(SysRolePermission record);

    int insertBatchSelective(List<SysRolePermission> records);

    int updateBatchByPrimaryKeySelective(List<SysRolePermission> records);

    List<SysRolePermission> selectByPermissionId(@Param(value = "roleId") String roleId);
}