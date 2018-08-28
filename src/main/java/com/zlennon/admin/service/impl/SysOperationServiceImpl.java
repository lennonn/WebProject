package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysOperationMapper;
import com.zlennon.admin.model.SysOperation;
import com.zlennon.admin.service.SysOperationService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/27.
 */
@Service
public class SysOperationServiceImpl extends AbstractService<SysOperation> implements SysOperationService<SysOperation> {

    @Autowired
    private SysOperationMapper sysOperationMapper;

    public SysOperationMapper getSysOperationMapper() {
        return sysOperationMapper;
    }

    public void setSysOperationMapper(SysOperationMapper sysOperationMapper) {
        this.sysOperationMapper = sysOperationMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysOperationMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysOperation sysOperation){
       return sysOperationMapper.insert(sysOperation);
    }

    public SysOperation selectByPrimaryKey(String id){
       return  sysOperationMapper.selectByPrimaryKey(id);
    }

    public List<SysOperation> selectAll(){
       return sysOperationMapper.selectAll();
    }

    public int updateByPrimaryKey(SysOperation sysOperation){
       return sysOperationMapper.updateByPrimaryKey(sysOperation);
    }

    @Override
    public List<SysOperation> selectByQueryParams(String searchText) {
        return sysOperationMapper.selectByQueryParams(searchText);
    }
}
