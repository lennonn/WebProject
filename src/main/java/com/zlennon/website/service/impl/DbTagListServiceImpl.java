package com.zlennon.website.service.impl;

import com.zlennon.AbstractService;
import com.zlennon.website.mapper.DbTagListMapper;
import com.zlennon.website.model.DbTagList;
import com.zlennon.website.service.DbTagListService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/08/06.
 */
@Service
public class DbTagListServiceImpl extends AbstractService<DbTagList> implements DbTagListService<DbTagList> {

    @Autowired
    private DbTagListMapper dbTagListMapper;

    public DbTagListMapper getDbTagListMapper() {
        return dbTagListMapper;
    }

    public void setDbTagListMapper(DbTagListMapper dbTagListMapper) {
        this.dbTagListMapper = dbTagListMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  dbTagListMapper.deleteByPrimaryKey(id);
    }

    public int insert(DbTagList dbTagList){
       return dbTagListMapper.insert(dbTagList);
    }

    public DbTagList selectByPrimaryKey(String id){
       return  dbTagListMapper.selectByPrimaryKey(id);
    }

    public List<DbTagList> selectAll(){
       return dbTagListMapper.selectAll();
    }

    public int updateByPrimaryKey(DbTagList dbTagList){
       return dbTagListMapper.updateByPrimaryKey(dbTagList);
    }

    @Override
    public List<Map<Float, Long>> group() {
        return dbTagListMapper.groupByStar();
    }
}
