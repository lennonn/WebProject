package com.zlennon.admin.controller;
import com.zlennon.admin.model.SysUser;
import com.zlennon.admin.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by zlennon on 2018/08/26.
 */
@Controller
@RequestMapping("/sysUser/")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
       // model.addAttribute("pageInfo",pageInfo);
        return list.toString();
    }
}
