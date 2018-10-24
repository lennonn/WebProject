package com.zlennon.admin.controller;
import com.zlennon.admin.BootTree;
import com.zlennon.admin.model.SysPermission;
import com.zlennon.admin.model.SysPermissionOperation;
import com.zlennon.admin.service.SysMenuService;
import com.zlennon.admin.service.SysOperationService;
import com.zlennon.admin.service.SysPermissionOperationService;
import com.zlennon.admin.service.SysPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.service.Tree;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/08/28.
 */
@Controller
@RequestMapping("/sysPermission/")
public class SysPermissionController {
    protected static final Logger logger = LoggerFactory.getLogger(SysPermissionController.class);

    @Autowired
    SysPermissionService sysPermissionService;
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysOperationService sysOperationService;

    @Autowired
    SysPermissionOperationService permissionOperationService;

    @Autowired
    Tree bootTree;

   @RequestMapping("list")
    public String list(Model model,HttpServletRequest request){
       List<BootTree> menuList = sysMenuService.getBootMenu();
       List<BootTree> treeNodes=bootTree.menuList(menuList);

        model.addAttribute("menus",JSONArray.fromObject(treeNodes));
        model.addAttribute("operations",sysOperationService.selectAll());
       return "/admin/syspermission/sysPermissionList";

   }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(HttpServletResponse response,  String searchText, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        PageHelper.startPage(pageNumber, pageSize);
        List<SysPermission> list = sysPermissionService.selectByQueryParams(searchText);
        PageInfo pageInfo = new PageInfo(list);
        String s= "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONArray.fromObject(pageInfo.getList()) + "}";
        return s;
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object>  delete(@RequestParam String id){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            sysPermissionService.deleteByPrimaryKey(id);
            resultMap.put("msg", "操作成功");
        }catch (Exception e){
            logger.info(e.getMessage());
            resultMap.put("msg", "操作失败");
        }
        return  resultMap;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid SysPermission sysPermission,HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            String operIds = request.getParameter("operIds");
            String ids[]=null;
            if(!StringUtils.isEmpty(operIds)){
                ids=operIds.split(",");
            }
            if(sysPermission.getId()==null||sysPermission.getId().equals("")) {
                sysPermissionService.insert(sysPermission);
                for(String id:ids){
                    SysPermissionOperation spo=new SysPermissionOperation();
                    spo.setPermissionId(sysPermission.getId());
                    spo.setOperationId(id);
                   permissionOperationService.insert(spo);
                }
            }else {
                sysPermissionService.updateByPrimaryKey(sysPermission);

                //功能先删除在添加
                permissionOperationService.deleteByPermissionId(sysPermission.getId());

                for (String id : ids) {
                    SysPermissionOperation spo = new SysPermissionOperation();
                    spo.setPermissionId(sysPermission.getId());
                    spo.setOperationId(id);
                    permissionOperationService.insert(spo);
                }
            }
            resultMap.put("msg", "操作成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
        e.printStackTrace();
             resultMap.put("msg", "操作失败");
        }
             return resultMap;
    }

    @RequestMapping("/getPO")
    @ResponseBody
    public Map<String,Object> getPermissionOperations(@RequestParam String permissionId,String menuId) {
        Map<String,Object> result = new HashMap<>();
        result.put("pos",permissionOperationService.getByPermissionId(permissionId));
        result.put("menu",sysMenuService.selectByPrimaryKey(menuId));
        return result;
    }
}
