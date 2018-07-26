package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysMenu;

import java.util.List;

/**
 * Created by Nicky on 2017/6/17.
 */
public interface MenuTreeMapper {
    List<SysMenu> findAll();
}
