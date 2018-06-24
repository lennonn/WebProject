package com.zl.production.business.service.impl;

import com.zl.production.business.mapper.EmpMapper;
import com.zl.production.business.model.Emp;
import com.zl.production.business.service.EmpService;
import com.zl.production.business.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/06/23.
 */
@Service
public class EmpServiceImpl extends AbstractService<Emp> implements EmpService<Emp> {


    private EmpMapper empMapper;

    public EmpMapper getEmpMapper() {
        return empMapper;
    }
    @Autowired
    public void setEmpMapper(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    public int deleteByPrimaryKey(Short id){
      return  empMapper.deleteByPrimaryKey(id);
    }

    public int insert(Emp emp){
       return empMapper.insert(emp);
    }

    public Emp selectByPrimaryKey(Short id){
       return  empMapper.selectByPrimaryKey(id);
    }

    public List<Emp> selectAll(){
       return empMapper.selectAll();
    }

    public int updateByPrimaryKey(Emp emp){
       return empMapper.updateByPrimaryKey(emp);
    }
}
