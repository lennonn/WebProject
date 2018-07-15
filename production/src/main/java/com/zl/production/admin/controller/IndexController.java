package com.zl.production.admin.controller;



import javax.servlet.http.HttpServletRequest;

import com.zl.production.admin.model.SysMenu;
import com.zl.production.admin.service.SysMenuService;
import com.zl.production.utils.MenuTreeUtil;
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

    @RequestMapping("/views/index")
    public String index(Model model, HttpServletRequest request) {
        List<SysMenu> menuList = sysMenuService.selectAll();

        MenuTreeUtil treeUtil = new MenuTreeUtil();
        List<SysMenu> treeMenus = treeUtil.menuList(menuList);
        model.addAttribute("menu",treeMenus.get(0));
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