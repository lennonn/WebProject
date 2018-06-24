package com.zl.production.business.service;
import com.zl.production.business.model.Emp;
import com.zl.production.business.Service;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/06/23.
 */
public interface EmpService<Emp> extends Service<Emp> {

    int deleteByPrimaryKey(Short id);

    int insert(Emp emp);

    Emp selectByPrimaryKey(Short id);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp emp);
}
