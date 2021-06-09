package com.nhasachphuongnam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homePage(HttpServletRequest request, 
			HttpServletResponse response, 
			@CookieValue(value="user", required = false) String user,
			@CookieValue(value="role", required = false) String role) {
		/*
		 * Cookie[] cookies = request.getCookies();
		 * 
		 * if (cookies != null) { for (Cookie cookie : cookies) { if
		 * (cookie.getName().equals("role")) { if (cookie.getValue().equals("2")) {
		 * return "redirect:nguoi-dung/index.htm"; } else { return
		 * "redirect:admin/index.htm"; } } } }
		 */
		if (user == null) {
			/* return "redirect:dang-nhap.htm"; */
			return "redirect:index.htm";
		} else {
			if(role.equals("0") || role.equals("1")) {
				return "redirect:admin/index.htm";
			} else {/* } else if(role.equals("2")) { */
				return "redirect:index.htm";
			}
		}
	}
}
