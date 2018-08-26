package com.zlennon.admin.service;
import com.zlennon.Service;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/26.
 */
public interface SysUserService<SysUser> extends Service<SysUser> {

    int deleteByPrimaryKey(String id);

    int insert(SysUser sysUser);

    SysUser selectByPrimaryKey(String id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser sysUser);
}
