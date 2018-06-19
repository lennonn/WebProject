package com.zl.production.auth.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class IndexController {
	
		@RequestMapping("/views/index")
		public String index(Model model, HttpServletRequest request) {
			return "/index";
		}
		
		@RequestMapping("/login")
		public String login(Model model, HttpServletRequest request) {
			return "/login/login";
		}

	@RequestMapping(value = "/signin" ,method = RequestMethod.POST)
	public String signIn(Model model, HttpServletRequest request) {
		return "redirect:/views/index";
	}
}
