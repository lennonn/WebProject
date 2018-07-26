package com.zlennon.admin.mapper;

import com.zlennon.admin.model.SysMenu;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

;

@MapperScan
@Repository
public interface SysMenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(String menuId);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);

    int insertBatchSelective(List<SysMenu> records);

    int updateBatchByPrimaryKeySelective(List<SysMenu> records);

    /**
     * 获取所有的上级菜单，并按菜单序号排序
     * @return
     */
   // "select m from SysMenu m where m.parentId=0 order by m.menuOrder asc")
    public List<SysMenu> findAllParentMenu();

    /**
     * 根据上级菜单Id获取二级菜单，并按菜单序号排序
     * @param id
     * @return
     */
   // "select m from SysMenu m where m.parentId=:id order by m.menuOrder asc")
    public List<SysMenu> findSubMenuByParentId(String id);

    String getMaxCode(String menuId);
}