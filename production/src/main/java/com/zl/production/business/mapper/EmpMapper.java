package com.zl.production.business.mapper;

import com.zl.production.business.model.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {
    int deleteByPrimaryKey(Short empno);

    int insert(Emp record);

    Emp selectByPrimaryKey(Short empno);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp record);
}