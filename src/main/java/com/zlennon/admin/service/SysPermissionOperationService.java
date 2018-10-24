package com.zlennon.admin.service;
import com.zlennon.Service;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/05.
 */
public interface SysPermissionOperationService<SysPermissionOperation> extends Service<SysPermissionOperation> {

    int deleteByPrimaryKey(String id);

    int insert(SysPermissionOperation sysPermissionOperation);

    SysPermissionOperation selectByPrimaryKey(String id);

    List<SysPermissionOperation> selectAll();

    int updateByPrimaryKey(SysPermissionOperation sysPermissionOperation);

    List<SysPermissionOperation> getByPermissionId(String permissionId);

    void deleteByPermissionId(String id);
}
