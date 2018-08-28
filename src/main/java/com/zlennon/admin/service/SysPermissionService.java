package com.zlennon.admin.service;
import com.zlennon.Service;
import com.zlennon.admin.model.SysPermission;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/27.
 */
public interface SysPermissionService<SysPermission> extends Service<SysPermission> {

    int deleteByPrimaryKey(String id);

    int insert(SysPermission sysPermission);

    SysPermission selectByPrimaryKey(String id);

    List<SysPermission> selectAll();

    int updateByPrimaryKey(SysPermission sysPermission);

    List<SysPermission> selectByQueryParams(String searchText);
}
