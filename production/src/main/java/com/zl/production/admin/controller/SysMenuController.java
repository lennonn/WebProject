package com.zl.production.admin.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.production.admin.ZTree;
import com.zl.production.admin.model.SysMenu;
import com.zl.production.admin.service.SysMenuService;
import com.zl.production.utils.MenuTreeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/06/29.
 */
@Controller
@RequestMapping("/sysMenu/")
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysMenu> list = sysMenuService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }



/*    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        List<SysMenu> menus = sysMenuService.findAllParentMenu();
        JSONArray jsonObject = JSONArray.fromObject(menus);
        mv.addObject("menus",jsonObject.toString());
        mv.setViewName("admin/menu/menu_list");
        return mv;
    }*/


    /**
     *
     * @param menuId
     * @return 获取菜单信息和操作结果
     * @throws Exception
     */
    @RequestMapping("getMenuNodeById")
    @ResponseBody
    public Map<String,Object> getMenuNodeById(@RequestParam String menuId, Model model)throws Exception {
        Map<String,Object> result = new HashMap<>();

        SysMenu curr = (SysMenu) sysMenuService.selectByPrimaryKey(menuId);
        SysMenu parent = (SysMenu) sysMenuService.selectByPrimaryKey(curr.getParentId());
        //获取当前节点菜单码的最大值
        String maxCode=sysMenuService.getMaxCode(menuId);
        String menuCode="";
        if(maxCode==null) {
            maxCode = "100";//每层菜单从100开始
            menuCode= curr.getMenuOrder()+String.valueOf(maxCode);
        }else{
            menuCode =String.valueOf(Integer.parseInt(maxCode)+1);
        }
        result.put("menuCode",menuCode);
        result.put("curr",curr);
        result.put("parent",parent);
        return result;
    }
        /**
         * 获取当前菜单的所有子菜单
         * @param menuId
         * @param response
         */
    @RequestMapping(value="/sub")
    public void getSub(@RequestParam String menuId, HttpServletResponse response)throws Exception{
        try {
            List<SysMenu> subMenu = sysMenuService.findSubMenuById(menuId);
            JSONArray arr = JSONArray.fromObject(subMenu);
            PrintWriter out;

            response.setCharacterEncoding("utf-8");
            out = response.getWriter();
            String json = arr.toString();
            out.write(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            //log.error(e.toString(), e);
        }
    }

    /**
     * 跳转到编辑菜单页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/goEditM",method = RequestMethod.GET)
    public String goEditM(HttpServletRequest request, Model model){
        String menuIdStr = request.getParameter("menuId");
        SysMenu menu = (SysMenu) sysMenuService.selectByPrimaryKey(menuIdStr);
        model.addAttribute("menu",menu);
        return "admin/menu/menu_edit";
    }

    /**
     * 编辑菜单信息
     * @param response
     * @param request
     */
    @RequestMapping(value = "/editM", method = RequestMethod.POST)
    public void editM(HttpServletResponse response,HttpServletRequest request) {
    }

    /**
     * 跳转到新增菜单页面
     * @return
     */
    @RequestMapping(value="/goAddM",method=RequestMethod.GET)
    public String goAddM(Model model){
        List<SysMenu> sjMenus = sysMenuService.findAllParentMenu();
        model.addAttribute("sjMenus",sjMenus);
        return "admin/menu/menu_add";
    }

    /**
     * 保存菜单信息
     * @param request
     * @param sysMenu
     */
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> addMenu(HttpServletRequest request, @Valid SysMenu sysMenu){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
            String menuId = sysMenu.getMenuId();
            String parentId =sysMenu.getParentId();
            if(parentId==null||parentId.equals("")) {
                sysMenu.setParentId("0");
                sysMenu.setMenuOrder("100");
            }
            if(menuId==null||menuId.equals("")) {
                sysMenuService.insert(sysMenu);
            }else{
                sysMenuService.updateByPrimaryKey(sysMenu);
            }
            resultMap.put("menuId",sysMenu.getMenuId());
            resultMap.put("success","操作成功");
        }catch (Exception e){
            resultMap.put("success",e.getMessage());
        }
        return JSONObject.fromObject(resultMap);
    }

    /**
     * 根据菜单ids删除
     * @param request
     * @param menuId
     */
    @RequestMapping(value = "/deleteMenuById", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deleteMenuById(HttpServletRequest request, @RequestParam String menuId){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
           //获取父节点id
            SysMenu menu= (SysMenu) sysMenuService.selectByPrimaryKey(menuId);
/*            MenuTreeUtil treeUtil = new MenuTreeUtil();
            List<SysMenu> list =new ArrayList();
            list.add(menu);
            List<SysMenu> treeMenus = treeUtil.menuList(list);*/


            sysMenuService.deleteByPrimaryKey(menuId);
            resultMap.put("parentId",menu.getParentId());
            resultMap.put("success","操作成功");
        }catch (Exception e){
            resultMap.put("success",e.getMessage());
        }
        return JSONObject.fromObject(resultMap);
    }

    /**
     * 获取菜单数信息
     * @param request
     */
    @RequestMapping(value = "/getMenuTree", method = RequestMethod.POST)
    @ResponseBody
    public List<ZTree> getMenuTreeJson(HttpServletRequest request){
        List<ZTree> zTrees = null;
        try {
            zTrees= sysMenuService.getMenuTreeJson(request);
           // menus.put("success","操作成功");
        }catch (Exception e){
          //  menus.put("success",e.getMessage());
        }
        return zTrees;
    }


}
