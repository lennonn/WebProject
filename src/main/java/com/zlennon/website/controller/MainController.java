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

import java.util.List;

@Controller
@RequestMapping("/website")
public class MainController {
    @Autowired
    BookService bookService;


    @RequestMapping("/index")
    public String index() {
        return "/website/index";
    }


}
