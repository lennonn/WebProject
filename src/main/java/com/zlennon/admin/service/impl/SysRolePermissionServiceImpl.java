package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysRolePermissionMapper;
import com.zlennon.admin.model.SysRolePermission;
import com.zlennon.admin.service.SysRolePermissionService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/05.
 */
@Service
public class SysRolePermissionServiceImpl extends AbstractService<SysRolePermission> implements SysRolePermissionService<SysRolePermission> {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;


    public int deleteByPrimaryKey(String id){
      return  sysRolePermissionMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysRolePermission sysRolePermission){
        sysRolePermission.setRpId(getTablePK("SysRolePermission"));
       return sysRolePermissionMapper.insert(sysRolePermission);
    }

    public SysRolePermission selectByPrimaryKey(String id){
       return  sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    public List<SysRolePermission> selectAll(){
       return sysRolePermissionMapper.selectAll();
    }

    public int updateByPrimaryKey(SysRolePermission sysRolePermission){
       return sysRolePermissionMapper.updateByPrimaryKey(sysRolePermission);
    }

    @Override
    public List<SysRolePermission> selectByPermissionId(String roleId) {
        return sysRolePermissionMapper.selectByPermissionId(roleId);

    }

}
