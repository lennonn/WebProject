package com.zlennon.website.controller;
import com.zlennon.website.model.DbTagList;
import com.zlennon.website.service.DbTagListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/08/06.
 */
@Controller
@RequestMapping("/website/dbTagList/")
public class DbTagListController {

    @Autowired
    DbTagListService dbTagListService;

    @RequestMapping("list")
    public String list(Model model,@RequestParam Float star, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageHelper.startPage(page, size);
        List<DbTagList> list = dbTagListService.selectByStar(star);
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pageUrl","/website/dbTagList/list?star="+star);
        return "/website/douban/doubanlist";
    }

    @RequestMapping("statistics")
    public String statistics(Model model) {
        List<Map<String,Long>> list = dbTagListService.group();
        model.addAttribute("groupList",list);
        return "/website/douban/dbstatistics";
    }

}
