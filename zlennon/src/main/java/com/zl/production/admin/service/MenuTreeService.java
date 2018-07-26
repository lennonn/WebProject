package com.zl.production.admin.service;

import com.zl.production.admin.mapper.MenuTreeMapper;
import com.zl.production.admin.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nicky on 2017/6/17.
 */
@Service
public class MenuTreeService {

    @Autowired
    MenuTreeMapper menuTreeMapper;

    /**
     * 查询所有的菜单
     * @return
     */
    @Transactional
    //@RedisCache
    public List<SysMenu> findAll(){
        return menuTreeMapper.findAll();
    }

}
