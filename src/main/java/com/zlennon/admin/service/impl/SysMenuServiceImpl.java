package com.zlennon.admin.service.impl;

import com.zlennon.admin.ZTree;
import com.zlennon.admin.mapper.SysMenuMapper;
import com.zlennon.admin.model.SysMenu;
import com.zlennon.admin.service.SysMenuService;
import com.zlennon.AbstractService;
import com.zlennon.utils.MenuTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/06/29.
 */
@Service
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService<SysMenu> {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    public int deleteByPrimaryKey(String id){
      return  sysMenuMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysMenu sysMenu){
        sysMenu.setMenuId(getTablePK("SysMenu"));
       return sysMenuMapper.insert(sysMenu);
    }

    public SysMenu selectByPrimaryKey(String id){
       return  sysMenuMapper.selectByPrimaryKey(id);
    }

    public List<SysMenu> selectAll(){
       return sysMenuMapper.selectAll();
    }

    public int updateByPrimaryKey(SysMenu sysMenu){
       return sysMenuMapper.updateByPrimaryKey(sysMenu);
    }

    /**
     * 获取所有的上级菜单
     * @return
     */
    //@RedisCache
    public List<SysMenu> findAllParentMenu(){
        return sysMenuMapper.findAllParentMenu();
    }

    /**
     * 通过上级Id获取二级菜单
     * @param id
     * @return
     */
    //@RedisCache
    public List<SysMenu> findSubMenuById(String id){
        return sysMenuMapper.findSubMenuByParentId(id);
    }

    @Override
    public List<ZTree> getMenuTreeJson(HttpServletRequest request) {
        /**获取用户可以查看的菜单**/
        Map<String,Object> menuMap = new HashMap<>();
        List<SysMenu> menuList = selectAll();

        MenuTreeUtil treeUtil = new MenuTreeUtil();
        List<SysMenu> treeMenus = treeUtil.menuList(menuList);
         List<ZTree> zTrees = new ArrayList<ZTree>();
        initMenu(treeMenus,zTrees);
        menuMap.put("allMenu",zTrees);
        return  zTrees;
    }

    @Override
    public String getMaxCode(String menuId) {
        return sysMenuMapper.getMaxCode(menuId);
    }

    private void initMenu(List<SysMenu> treeMenus, List<ZTree> zTrees) {

        for (int i = 0; i < treeMenus.size(); i++) {
            SysMenu sm = treeMenus.get(i);

            if(sm.getParentId().equals("0")){//把根节点添加上
                ZTree zTree = new ZTree();
                zTree.setOpen("true");
                zTree.setId(String.valueOf(sm.getMenuId()));
                zTree.setName(sm.getMenuName());
                zTree.setpId(sm.getParentId());
                zTrees.add(zTree);
            }
            if (sm.getSubMenu() == null) {
                continue;
            } else {
                List<SysMenu> subList = sm.getSubMenu();
                for(SysMenu sub :subList){

                        ZTree subZTree = new ZTree();
                        subZTree.setId(sub.getMenuId());
                        subZTree.setName(sub.getMenuName());
                        subZTree.setpId(sub.getParentId());
                        zTrees.add(subZTree);

                }
                initMenu(sm.getSubMenu(),zTrees);
            }
        }
    }
}
