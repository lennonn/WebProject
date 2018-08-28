package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysUser;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    int insertBatchSelective(List<SysUser> records);

    int updateBatchByPrimaryKeySelective(List<SysUser> records);

    SysUser getUserByUsername(String username);

    List<SysUser> selectByQueryParams(@Param(value="search")String search);
}