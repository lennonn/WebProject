package com.zlennon.website.controller;
import com.zlennon.website.model.Book;
import com.zlennon.website.service.BookService;
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
 * Created by zlennon on 2018/07/28.
 */
@Controller
@RequestMapping("/book/")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Book> list = bookService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
