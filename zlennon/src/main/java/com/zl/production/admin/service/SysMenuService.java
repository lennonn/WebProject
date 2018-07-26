package com.zl.production.admin.service;

import com.zl.production.admin.ZTree;
import com.zl.production.business.Service;

import javax.servlet.http.HttpServletRequest;
import com.zl.production.admin.model.SysMenu;
import java.util.List;

/**
 *
 * Created by zlennon on 2018/06/29.
 */
public interface SysMenuService<SysMenu> extends Service<SysMenu> {

    int deleteByPrimaryKey(String id);

    int insert(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(String id);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu sysMenu);

    List<SysMenu> findAllParentMenu();

    List<SysMenu> findSubMenuById(String id);

    List<ZTree>  getMenuTreeJson(HttpServletRequest request);

    String getMaxCode(String menuId);
}
