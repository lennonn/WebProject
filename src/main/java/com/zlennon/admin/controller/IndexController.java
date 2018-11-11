package com.zlennon.admin.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zlennon.admin.model.*;
import com.zlennon.admin.service.*;
import com.zlennon.utils.MenuTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    SysUserRoleService sysUserRoleService;

    @Autowired
    SysRolePermissionService sysRolePermissionService;


    @RequestMapping("/views/index")
    public String index(Model model, HttpServletRequest request) {
        //查询当前用户的菜单
        HttpSession currSession = request.getSession();
        SysUser user= (SysUser) currSession.getAttribute("currUser");
        SysUserRole sr= (SysUserRole) sysUserRoleService.selectByUserId(user.getId());
        List<SysMenu> menuList;
        if(user.getUsername().equals("admin")){
            menuList = sysMenuService.selectAll();
        }else{
           menuList=sysMenuService.selectPermissionMenuByRole(sr.getRoleId());

        }
        MenuTreeUtil treeUtil = new MenuTreeUtil();
        List<SysMenu> treeMenus = treeUtil.menuList(menuList,"permission");
        model.addAttribute("menu",treeMenus);
        return "/index";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        return "/login/login";
    }

    @RequestMapping(value = "/signin" ,method = RequestMethod.POST)
    public String signIn(Model model, HttpServletRequest request) {
        return "redirect:/views/index";
    }
}