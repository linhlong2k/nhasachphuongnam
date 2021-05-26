package com.nhasachphuongnam.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("index")
	public String homePage(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("role")) {
					if(cookie.getValue().equals("2")) {
						return "redirect:nguoi-dung/index.htm";
					} else {
						return "redirect:admin/index.htm";
					}
				}
			}
		}
		return "home";
	}
}
