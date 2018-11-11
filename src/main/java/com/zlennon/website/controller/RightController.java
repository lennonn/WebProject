package com.zlennon.website.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.admin.model.PageView;
import com.zlennon.admin.service.PageViewService;
import com.zlennon.business.model.ArticleType;
import com.zlennon.business.model.DailyContent;
import com.zlennon.business.service.ArticleTypeService;
import com.zlennon.business.service.DailyContentService;
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
@RequestMapping("/right/website/")
public class RightController {
    @Autowired
    ArticleTypeService articleTypeService;

    @Autowired
    PageViewService pageViewService;

    @Autowired
    DailyContentService dailyContentService;

 /*   @RequestMapping("/index")
    public String index() {
        return "/website/index";
    }*/

    @RequestMapping("/load")
    @ResponseBody
    public Map<String,Object> load(Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        List<PageView> pvList=pageViewService.selectAll();
        resultMap.put("pv",pvList.size());
        List<ArticleType> atList=articleTypeService.selectAll();
        resultMap.put("atList",atList);
        List<DailyContent> dc= dailyContentService.selectByType("01");
        resultMap.put("dc",dc.get(0));
        List<DailyContent> dc03= dailyContentService.selectByType("03");
        resultMap.put("dc03",dc03.get(0));
        return resultMap;
    }

}
