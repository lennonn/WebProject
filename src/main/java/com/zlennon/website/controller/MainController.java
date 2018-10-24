package com.zlennon.website.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.business.model.Article;
import com.zlennon.business.model.DailyContent;
import com.zlennon.business.service.ArticleService;
import com.zlennon.business.service.DailyContentService;
import com.zlennon.website.model.Book;
import com.zlennon.website.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    BookService bookService;

    @Autowired
    ArticleService articleService;



 /*   @RequestMapping("/index")
    public String index() {
        return "/website/index";
    }*/

    @RequestMapping("/")
    public String main(Model model,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<Article> list = articleService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        //model.addAttribute("newsList",list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pageUrl","/");
        return "/website/index";
    }

}
