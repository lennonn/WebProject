package com.zlennon.business.controller;
import com.zlennon.business.model.ArticleType;
import com.zlennon.business.service.ArticleTypeService;
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
 * Created by zlennon on 2018/08/09.
 */
@Controller
@RequestMapping("/articleType/")
public class ArticleTypeController {

    @Autowired
    ArticleTypeService articleTypeService;

    @RequestMapping("list")
    public String list(Model model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageHelper.startPage(page, size);
        List<ArticleType> list = articleTypeService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/business/articletype/articleTypeList";
    }
}
