package com.zlennon.admin.service;
import com.zlennon.admin.model.SysRole;
import com.zlennon.Service;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/26.
 */
public interface SysRoleService<SysRole> extends Service<SysRole> {

    int deleteByPrimaryKey(String id);

    int insert(SysRole sysRole);

    SysRole selectByPrimaryKey(String id);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole sysRole);
}
