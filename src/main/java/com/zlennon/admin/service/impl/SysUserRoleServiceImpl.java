package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysUserRoleMapper;
import com.zlennon.admin.model.SysUserRole;
import com.zlennon.admin.service.SysUserRoleService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/11.
 */
@Service
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService<SysUserRole> {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    public SysUserRoleMapper getSysUserRoleMapper() {
        return sysUserRoleMapper;
    }

    public void setSysUserRoleMapper(SysUserRoleMapper sysUserRoleMapper) {
        this.sysUserRoleMapper = sysUserRoleMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysUserRoleMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysUserRole sysUserRole){
        sysUserRole.setId(getTablePK("SysUserRole"));
       return sysUserRoleMapper.insert(sysUserRole);
    }

    public SysUserRole selectByPrimaryKey(String id){
       return  sysUserRoleMapper.selectByPrimaryKey(id);
    }

    public List<SysUserRole> selectAll(){
       return sysUserRoleMapper.selectAll();
    }

    public int updateByPrimaryKey(SysUserRole sysUserRole){
       return sysUserRoleMapper.updateByPrimaryKey(sysUserRole);
    }

    @Override
    public List<SysUserRole> getUserRoleByUserId(String userId) {
        return sysUserRoleMapper.getUserRoleByUserId(userId);
    }
}
