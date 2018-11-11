package com.zlennon.admin.service;
import com.zlennon.Service;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/05.
 */
public interface SysRolePermissionService<SysRolePermission> extends Service<SysRolePermission> {

    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission sysRolePermission);

    SysRolePermission selectByPrimaryKey(String id);

    List<SysRolePermission> selectAll();

    int updateByPrimaryKey(SysRolePermission sysRolePermission);

    List<SysRolePermission> selectByPermissionId(String roleId);
}
