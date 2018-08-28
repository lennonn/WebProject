package com.zlennon.admin.service;
import com.zlennon.Service;
import com.zlennon.admin.model.SysRole;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/27.
 */
public interface SysRoleService<SysRole> extends Service<SysRole> {

    int deleteByPrimaryKey(String id);

    int insert(SysRole sysRole);

    SysRole selectByPrimaryKey(String id);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole sysRole);

    List<SysRole> selectByQueryParams(String searchText);
}
