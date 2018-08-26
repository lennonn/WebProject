package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysRole;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);

    int insertBatchSelective(List<SysRole> records);

    int updateBatchByPrimaryKeySelective(List<SysRole> records);
}