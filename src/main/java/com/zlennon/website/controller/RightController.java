package com.zlennon.website.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.business.model.ArticleType;
import com.zlennon.business.service.ArticleTypeService;
import com.zlennon.website.model.Book;
import com.zlennon.website.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/right")
public class RightController {
    @Autowired
    ArticleTypeService articleTypeService;


 /*   @RequestMapping("/index")
    public String index() {
        return "/website/index";
    }*/

    @RequestMapping("/load")
    @ResponseBody
    public Map<String,Object> load(Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        List<ArticleType> atList=articleTypeService.selectAll();
        resultMap.put("atList",atList);
        return resultMap;
    }

}
