package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysDictTypeMapper;
import com.zlennon.admin.model.SysDictType;
import com.zlennon.admin.service.SysDictTypeService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/10/08.
 */
@Service
public class SysDictTypeServiceImpl extends AbstractService<SysDictType> implements SysDictTypeService<SysDictType> {

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;

    public SysDictTypeMapper getSysDictTypeMapper() {
        return sysDictTypeMapper;
    }

    public void setSysDictTypeMapper(SysDictTypeMapper sysDictTypeMapper) {
        this.sysDictTypeMapper = sysDictTypeMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysDictTypeMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysDictType sysDictType){
        sysDictType.setId(getTablePK("SysDictType"));
       return sysDictTypeMapper.insert(sysDictType);
    }

    public SysDictType selectByPrimaryKey(String id){
       return  sysDictTypeMapper.selectByPrimaryKey(id);
    }

    public List<SysDictType> selectAll(){
       return sysDictTypeMapper.selectAll();
    }

    public int updateByPrimaryKey(SysDictType sysDictType){
       return sysDictTypeMapper.updateByPrimaryKey(sysDictType);
    }

    @Override
    public List<SysDictType> selectByQueryParams(String searchText) {
       return sysDictTypeMapper.selectByQueryParams(searchText);
    }
}
