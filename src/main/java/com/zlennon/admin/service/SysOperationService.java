package com.zlennon.admin.service;
import com.zlennon.Service;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/27.
 */
public interface SysOperationService<SysOperation> extends Service<SysOperation> {

    int deleteByPrimaryKey(String id);

    int insert(SysOperation sysOperation);

    SysOperation selectByPrimaryKey(String id);

    List<SysOperation> selectAll();

    int updateByPrimaryKey(SysOperation sysOperation);
}
