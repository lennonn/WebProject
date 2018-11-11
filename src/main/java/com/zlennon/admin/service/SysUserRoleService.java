package com.zlennon.admin.service;
import com.zlennon.Service;
import com.zlennon.admin.model.SysUserRole;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/11.
 */
public interface SysUserRoleService<SysUserRole> extends Service<SysUserRole> {

    int deleteByPrimaryKey(String id);

    int insert(SysUserRole sysUserRole);

    SysUserRole selectByPrimaryKey(String id);

    List<SysUserRole> selectAll();

    int updateByPrimaryKey(SysUserRole sysUserRole);

    List<SysUserRole> getUserRoleByUserId(String userId);

    SysUserRole selectByUserId(String id);
}
