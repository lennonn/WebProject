package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysDictValueMapper;
import com.zlennon.admin.model.SysDictValue;
import com.zlennon.admin.service.SysDictValueService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/10/08.
 */
@Service
public class SysDictValueServiceImpl extends AbstractService<SysDictValue> implements SysDictValueService<SysDictValue> {

    @Autowired
    private SysDictValueMapper sysDictValueMapper;

    public SysDictValueMapper getSysDictValueMapper() {
        return sysDictValueMapper;
    }

    public void setSysDictValueMapper(SysDictValueMapper sysDictValueMapper) {
        this.sysDictValueMapper = sysDictValueMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysDictValueMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysDictValue sysDictValue){
        sysDictValue.setId(getTablePK("SysDictValue"));
       return sysDictValueMapper.insert(sysDictValue);
    }

    public SysDictValue selectByPrimaryKey(String id){
       return  sysDictValueMapper.selectByPrimaryKey(id);
    }

    public List<SysDictValue> selectAll(){
       return sysDictValueMapper.selectAll();
    }

    public int updateByPrimaryKey(SysDictValue sysDictValue){
       return sysDictValueMapper.updateByPrimaryKey(sysDictValue);
    }

    @Override
    public List<SysDictValue> selectByQueryParams(String searchText, String typeId) {
       return sysDictValueMapper.selectByQueryParams(searchText,typeId);
    }

    @Override
    public List<SysDictValue> selectByTypeId(String typeId) {
        return sysDictValueMapper.selectByTypeId(typeId);

    }
}
