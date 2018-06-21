package com.zl.production.business.emp.service.impl;

import com.zl.production.business.emp.mapper.EmpMapper;
import com.zl.production.business.emp.model.Emp;
import com.zl.production.business.emp.service.EmpService;
import com.zl.production.business.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/06/21.
 */
@Service
public class EmpServiceImpl extends AbstractService<Emp> implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    List<Emp> findAll(){
      return   empMapper.findAll();
    }
}
