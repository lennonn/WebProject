package com.zl.production.business.emp.controller;
import com.zl.production.business.emp.model.Emp;
import com.zl.production.business.emp.service.EmpService;
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
 * Created by zlennon on 2018/06/21.
 */
@Controller
@RequestMapping("/emp/")
public class EmpController {

    @Autowired
    EmpService empService;

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Emp> list = empService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
