package com.zlennon.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class MenuController {

    @RequestMapping("/menu")
    public String index(Model model, HttpServletRequest request) {
        //return "/pages/examples/pace";
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