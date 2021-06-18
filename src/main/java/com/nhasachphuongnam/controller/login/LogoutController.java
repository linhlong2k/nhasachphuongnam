package com.nhasachphuongnam.controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dang-xuat")
public class LogoutController {
	
	@GetMapping(value="")
	public String dangXuat(ModelMap model,HttpServletResponse response) {
		Cookie cookie = new Cookie("user", null); // Not necessary, but saves bandwidth.
		cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
		response.addCookie(cookie);
		cookie = new Cookie("role", null); // Not necessary, but saves bandwidth.
		cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
		response.addCookie(cookie);
		cookie = new Cookie("gioHang", null); // Not necessary, but saves bandwidth.
		cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
		response.addCookie(cookie);
		model.addAttribute("user", null);
		return "user/index";
	}
}
