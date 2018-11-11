package com.zlennon.utils;


import com.zlennon.admin.model.SysMenu;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MenuTreeUtil {

    public List<SysMenu> rootMenu;
    public List<SysMenu> list = new ArrayList<SysMenu>();

    private static String type=null;


    
    public List<SysMenu> menuList(List<SysMenu> menus,String type) {
        this.rootMenu=menus;
        this.type=type;
        // 先找到所有的一级菜单
        for (int i = 0; i < rootMenu.size(); i++) {
            // 一级菜单没有parentId
            if(rootMenu.get(i).getMenuLevel()!=null) {
                if (rootMenu.get(i).getMenuLevel().equals("1")) {
                    list.add(rootMenu.get(i));
                }
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SysMenu menu : list) {
            menu.setSubMenu(getChild(menu.getMenuId(), rootMenu));
        }
        return list;
    }


    /**
     * 递归查找子菜单
     *
     * @param id
     *            当前菜单id
     * @param rootMenu
     *            要查找的列表
     * @return
     */
    private List<SysMenu> getChild(String id, List<SysMenu> rootMenu) {
        // 子菜单
        List<SysMenu> childList = new ArrayList<>();
        for (SysMenu menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (!menu.getParentId().equals("0")){
                if(type!=null) {
                    if (menu.getParentId().equals(id) && menu.getMenuType().equals("1")) {
                        childList.add(menu);
                    }
                }else{
                    if (menu.getParentId().equals(id)) {
                        childList.add(menu);
                    }
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (SysMenu menu : childList) {// 不是叶子节点的菜单还有子菜单
            if (menu.getMenuStatus().equals("0")) {
                // 递归
                menu.setSubMenu(getChild(menu.getMenuId(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
    
    
    


}