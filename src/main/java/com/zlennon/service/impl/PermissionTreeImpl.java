package com.zlennon.service.impl;

import com.zlennon.admin.BootTree;
import com.zlennon.admin.model.SysMenu;
import com.zlennon.admin.service.SysMenuService;
import com.zlennon.service.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("permissionTree")
public class PermissionTreeImpl implements Tree<BootTree> {

    @Autowired
    SysMenuService sysMenuService;
    public List<BootTree> rootMenu;
    public List<BootTree> list;
    @Override
    public List menuList(List<BootTree> permissions) {
        list = new ArrayList<BootTree>();
        this.rootMenu=permissions;
        // 先找到所有的一级权限（最末级菜单）
        List<SysMenu> lastStage=sysMenuService.findLastStage();
        for (int i = 0; i < lastStage.size(); i++) {
            BootTree bt = new BootTree();
            bt.setId(lastStage.get(i).getMenuId());
            bt.setText(lastStage.get(i).getMenuName());
            bt.setOpen("false");
            list.add(bt);
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (BootTree parent : list) {
            parent.setNodes(getChild(parent, rootMenu));
        }
        return list;
    }

    @Override
    public List getChild(BootTree parent, List<BootTree> permissions) {
        // 二级权限
        List<BootTree> childList= new ArrayList<>();

        for(BootTree perm:permissions){
            if(parent.getId().equals(perm.getParentId()))
                childList.add(perm);
        }
        return childList;
    }
}
