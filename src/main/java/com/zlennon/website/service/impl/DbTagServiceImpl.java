package com.zlennon.website.service.impl;

import com.zlennon.AbstractService;
import com.zlennon.website.mapper.DbTagMapper;
import com.zlennon.website.model.DbTag;
import com.zlennon.website.service.DbTagService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/06.
 */
@Service
public class DbTagServiceImpl extends AbstractService<DbTag> implements DbTagService<DbTag> {

    @Autowired
    private DbTagMapper dbTagMapper;

    public DbTagMapper getDbTagMapper() {
        return dbTagMapper;
    }

    public void setDbTagMapper(DbTagMapper dbTagMapper) {
        this.dbTagMapper = dbTagMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  dbTagMapper.deleteByPrimaryKey(id);
    }

    public int insert(DbTag dbTag){
       return dbTagMapper.insert(dbTag);
    }

    public DbTag selectByPrimaryKey(String id){
       return  dbTagMapper.selectByPrimaryKey(id);
    }

    public List<DbTag> selectAll(){
       return dbTagMapper.selectAll();
    }

    public int updateByPrimaryKey(DbTag dbTag){
       return dbTagMapper.updateByPrimaryKey(dbTag);
    }
}
