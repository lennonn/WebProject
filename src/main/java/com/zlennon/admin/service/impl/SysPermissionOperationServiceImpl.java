package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysPermissionOperationMapper;
import com.zlennon.admin.model.SysPermissionOperation;
import com.zlennon.admin.service.SysPermissionOperationService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/05.
 */
@Service
public class SysPermissionOperationServiceImpl extends AbstractService<SysPermissionOperation> implements SysPermissionOperationService<SysPermissionOperation> {

    @Autowired
    private SysPermissionOperationMapper sysPermissionOperationMapper;

    public SysPermissionOperationMapper getSysPermissionOperationMapper() {
        return sysPermissionOperationMapper;
    }

    public void setSysPermissionOperationMapper(SysPermissionOperationMapper sysPermissionOperationMapper) {
        this.sysPermissionOperationMapper = sysPermissionOperationMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysPermissionOperationMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysPermissionOperation sysPermissionOperation){
        sysPermissionOperation.setPoId(getTablePK("SysPermissionOperation"));
       return sysPermissionOperationMapper.insert(sysPermissionOperation);
    }

    public SysPermissionOperation selectByPrimaryKey(String id){
       return  sysPermissionOperationMapper.selectByPrimaryKey(id);
    }

    public List<SysPermissionOperation> selectAll(){
       return sysPermissionOperationMapper.selectAll();
    }

    public int updateByPrimaryKey(SysPermissionOperation sysPermissionOperation){
       return sysPermissionOperationMapper.updateByPrimaryKey(sysPermissionOperation);
    }

    @Override
    public List<SysPermissionOperation> getByPermissionId(String permissionId) {
        return sysPermissionOperationMapper.getByPermissionId(permissionId);
    }

    @Override
    public void deleteByPermissionId(String id) {
         sysPermissionOperationMapper.deleteByPermissionId(id);

    }
}
