package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysPermissionMapper;
import com.zlennon.admin.model.SysPermission;
import com.zlennon.admin.service.SysPermissionService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/27.
 */
@Service
public class SysPermissionServiceImpl extends AbstractService<SysPermission> implements SysPermissionService<SysPermission> {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    public SysPermissionMapper getSysPermissionMapper() {
        return sysPermissionMapper;
    }

    public void setSysPermissionMapper(SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysPermissionMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysPermission sysPermission){
       return sysPermissionMapper.insert(sysPermission);
    }

    public SysPermission selectByPrimaryKey(String id){
       return  sysPermissionMapper.selectByPrimaryKey(id);
    }

    public List<SysPermission> selectAll(){
       return sysPermissionMapper.selectAll();
    }

    public int updateByPrimaryKey(SysPermission sysPermission){
       return sysPermissionMapper.updateByPrimaryKey(sysPermission);
    }

    @Override
    public List<SysPermission> selectByQueryParams(String searchText) {
        return sysPermissionMapper.selectByQueryParams(searchText);
    }
}
