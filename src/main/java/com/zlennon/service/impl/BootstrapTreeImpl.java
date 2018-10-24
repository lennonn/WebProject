package com.zlennon.service.impl;

import com.zlennon.admin.BootTree;
import com.zlennon.service.Tree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("bootTree")
public class BootstrapTreeImpl implements Tree<BootTree> {

    public List<BootTree> rootMenu;
    public List<BootTree> list;
    @Override
    public List menuList(List<BootTree> menus) {
        list = new ArrayList<BootTree>();
        this.rootMenu=menus;
        // 先找到所有的一级菜单
        for (int i = 0; i < rootMenu.size(); i++) {
            // 一级菜单没有parentId
            if (rootMenu.get(i).getParentId().equals("0")) {
                list.add(rootMenu.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (BootTree parent : list) {
            parent.setNodes(getChild(parent, rootMenu));
        }
        return list;
    }

    @Override
    public List getChild(BootTree parent, List<BootTree> rootMenu) {
        // 子菜单
        List<BootTree> childList = new ArrayList<>();
        for (BootTree menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (!menu.getParentId().equals("0")){
                if (menu.getParentId().equals(parent.getId())) {
                    childList.add(menu);
                }
            }
        }
        if(childList.size()<=0){
            parent.setChild(true);
        }else{
            parent.setChild(false);
        }
        // 把子菜单的子菜单再循环一遍
        for (BootTree menu : childList) {// 没有url子菜单还有子菜单
            if (!menu.isChild()) {
                // 递归
                menu.setNodes(getChild(menu, rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {

            return null;
        }
        return childList;
    }
}
