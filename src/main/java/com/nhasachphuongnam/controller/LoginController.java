package com.nhasachphuongnam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.bean.Login;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("login", new Login());
		return "login/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ModelMap model,
			@ModelAttribute("login") Login login) {
		String username = login.getUsername();
		String password = login.getPassword();
		System.out.println(username + ":" + password);
		if(username != null && password != null && username != "" && password != "") {
			if(username.equals("abc") && password.equals("abc")) {
				return "login/success";
			}
			else {
				model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu bạn nhập không chính xác!");
				return "login/login";
			}
		}
		model.addAttribute("message", "Vui lòng nhập tên đăng nhập và mật khẩu");
		return "login/login";
	}
}
