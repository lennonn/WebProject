package com.zlennon.website.controller;
import com.zlennon.website.model.DbTag;
import com.zlennon.website.service.DbTagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by zlennon on 2018/08/06.
 */
@Controller
@RequestMapping("/dbTag/")
public class DbTagController {

    @Autowired
    DbTagService dbTagService;

    @RequestMapping("list")
    @ResponseBody
    public String list(Model model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<DbTag> list = dbTagService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo",pageInfo);
        return list.toString();
    }
}
