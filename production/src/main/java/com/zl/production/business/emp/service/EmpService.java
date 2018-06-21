package com.zl.production.business.emp.service;
import com.zl.production.business.emp.model.Emp;
import com.zl.production.business.Service;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/06/21.
 */
public interface EmpService<Emp> extends Service<Emp> {

    int deleteByPrimaryKey(Short id);

    int insert(Emp emp);

    Emp selectByPrimaryKey(Short id);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp emp);
}
