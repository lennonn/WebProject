package com.zlennon.admin.controller;
import com.zlennon.admin.BootTree;
import com.zlennon.admin.ZTree;
import com.zlennon.admin.model.SysMenu;
import com.zlennon.admin.model.SysPermission;
import com.zlennon.admin.model.SysRole;
import com.zlennon.admin.model.SysRolePermission;
import com.zlennon.admin.service.SysMenuService;
import com.zlennon.admin.service.SysPermissionService;
import com.zlennon.admin.service.SysRolePermissionService;
import com.zlennon.admin.service.SysRoleService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.service.Tree;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/08/28.
 */
@Controller
@RequestMapping("/sysRole/")
public class SysRoleController {
    protected static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    @Qualifier(value = "permissionTree")
    Tree bootTree;

    @Autowired
    SysRolePermissionService sysRolePermissionService;

    @Autowired
    SysPermissionService sysPermissionService;

    @Autowired
    SysMenuService sysMenuService;

   @RequestMapping("list")
    public String list(Model model) {
      List<BootTree> treeNodes= bootTree.menuList(permssionToBootTree());
       model.addAttribute("menus",JSONArray.fromObject(treeNodes));

       return "/admin/sysrole/sysRoleList";
    }

    /**
     * 将所有的权限转化成BootTree对象
     * @return
     */
    public List<BootTree> permssionToBootTree(){
        List<SysPermission> permissionList= sysPermissionService.selectAll();
        List<BootTree> btList = new ArrayList<>();
        for(SysPermission sp:permissionList){
            BootTree bt = new BootTree();
            bt.setId(sp.getId());
            bt.setText(sp.getPname());
            bt.setOpen("false");
            bt.setParentId(sp.getMenuId());
            btList.add(bt);
        }
        return btList;
    }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(String searchText,@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
        PageHelper.startPage(pageNumber, pageSize);
        List<SysRole> list = sysRoleService.selectByQueryParams(searchText);
        PageInfo pageInfo = new PageInfo(list);
        return  "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONObject.toJSON(pageInfo.getList()) + "}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object>  delete(@RequestParam String id){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            sysRoleService.deleteByPrimaryKey(id);
            resultMap.put("msg", "操作成功");
        }catch (Exception e){
            logger.info(e.getMessage());
            resultMap.put("msg", "操作失败");
        }
        return  resultMap;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid SysRole sysRole) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if(sysRole.getRoleId()==null||sysRole.getRoleId().equals("")) {
                sysRoleService.insert(sysRole);
            }else{
                sysRoleService.updateByPrimaryKey(sysRole);
            }
             resultMap.put("msg", "操作成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
        e.printStackTrace();
             resultMap.put("msg", "操作失败");
        }
             return resultMap;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> auth(@RequestParam String permissionIds,String roleId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            String permissions[] = permissionIds.split(",");
            List<SysRolePermission> spList = sysRolePermissionService.selectByPermissionId(roleId);
            //删除原有角色
            for(SysRolePermission rolePermission:spList){
                sysRolePermissionService.deleteByPrimaryKey(rolePermission.getRpId());
            }
            for (String p : permissions) {
                SysRolePermission srp = new SysRolePermission();
                srp.setPermissionId(p);
                srp.setRoleId(roleId);
                sysRolePermissionService.insert(srp);
            }
            resultMap.put("msg","授权成功！");
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("msg","授权失败"+e.getMessage());
        }
        return resultMap;
    }

    @RequestMapping(value = "/findAndAuthorisedMenu")
    @ResponseBody
    public Map<String,Object> findAndAuthorisedMenu(@RequestParam String roleId,HttpServletRequest request) {
        Map<String,Object> result = new HashMap<>();
        List<SysMenu> menuList=sysMenuService.selectPermissionMenuByRole(roleId);
        List<ZTree> zTrees= sysMenuService.getMenuTreeJson(request);
        result.put("menu",menuList);
        result.put("tree",zTrees);
        return result;
    }
}


