package com.zl.production.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	
		@RequestMapping("")
		public String index(Model model, HttpServletRequest request) {
			return "/index";
		}
}
