package com.zlennon.service;

import com.zlennon.admin.BootTree;

import java.util.List;

public interface Tree<T> {
    List<T> menuList(List<T> menus);
    List<T> getChild(BootTree parent, List<T> rootMenu);
}
