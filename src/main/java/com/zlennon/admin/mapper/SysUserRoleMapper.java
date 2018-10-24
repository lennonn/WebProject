package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysUserRole;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@MapperScan
@Repository
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    SysUserRole selectByPrimaryKey(String id);

    List<SysUserRole> selectAll();

    int updateByPrimaryKey(SysUserRole record);

    int insertBatchSelective(List<SysUserRole> records);

    int updateBatchByPrimaryKeySelective(List<SysUserRole> records);

    List<SysUserRole> getUserRoleByUserId(String userId);
}