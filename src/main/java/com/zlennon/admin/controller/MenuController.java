package com.zlennon.admin.controller;


import com.zlennon.admin.model.SysDictValue;
import com.zlennon.admin.service.SysDictValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class MenuController {

    @Autowired
    SysDictValueService sysDictValueService;

    @RequestMapping("/menu")
    public String index(Model model, HttpServletRequest request) {
        List< SysDictValue> menuTypeList=sysDictValueService.selectByTypeId("1013201811060000001");
        model.addAttribute("menuTypeList",menuTypeList);
        List< SysDictValue> menuLevelList=sysDictValueService.selectByTypeId("1013201811060000002");
        model.addAttribute("menuLevelList",menuLevelList);
        List< SysDictValue> menuStatusList=sysDictValueService.selectByTypeId("1013201811060000003");
        model.addAttribute("menuStatusList",menuStatusList);
       return "/admin/menu/menu";
    }
    @RequestMapping("/left")
    public String left(Model model, HttpServletRequest request) {
        return "/leftSide";
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