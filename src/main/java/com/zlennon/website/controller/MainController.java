package com.zlennon.website.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.website.model.Book;
import com.zlennon.website.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/website")
public class MainController {
    @Autowired
    BookService bookService;


    @RequestMapping("/main")
    public String main(Model model,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageHelper.startPage(page, size);
        List<Book> list = bookService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("newsList",list);
        model.addAttribute("pageInfo",pageInfo);
        return "/website/index";
    }


}
