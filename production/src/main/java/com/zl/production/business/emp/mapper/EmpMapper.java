package com.zl.production.business.emp.mapper;

import com.zl.production.business.emp.model.Emp;
import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Short empno);

    int insert(Emp record);

    Emp selectByPrimaryKey(Short empno);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp record);
}