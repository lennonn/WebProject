package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysRoleMapper;
import com.zlennon.admin.model.SysRole;
import com.zlennon.admin.service.SysRoleService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/27.
 */
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService<SysRole> {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public SysRoleMapper getSysRoleMapper() {
        return sysRoleMapper;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysRoleMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysRole sysRole){
        sysRole.setRoleId(getTablePK("SysRole"));
       return sysRoleMapper.insert(sysRole);
    }

    public SysRole selectByPrimaryKey(String id){
       return  sysRoleMapper.selectByPrimaryKey(id);
    }

    public List<SysRole> selectAll(){
       return sysRoleMapper.selectAll();
    }

    public int updateByPrimaryKey(SysRole sysRole){
       return sysRoleMapper.updateByPrimaryKey(sysRole);
    }

    @Override
    public List<SysRole> selectByQueryParams(String searchText) {
        return sysRoleMapper.selectByQueryParams(searchText);
    }
}
