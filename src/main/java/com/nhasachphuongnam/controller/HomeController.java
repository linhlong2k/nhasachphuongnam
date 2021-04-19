package com.nhasachphuongnam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("index")
	public String homePage(ModelMap model) {
		/* model.addAttribute("message", "xin chào"); */
		return "/product/form";
	}
}
