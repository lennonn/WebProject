package com.zlennon.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/testPage")
    public String testPage(Model model, HttpServletRequest request){
        return "/test/test";
    }
}
