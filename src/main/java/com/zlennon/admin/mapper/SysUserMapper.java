package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysUser;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;;

@MapperScan
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    int insertBatchSelective(List<SysUser> records);

    int updateBatchByPrimaryKeySelective(List<SysUser> records);

    SysUser getUserByUsername(String username);
}