package com.nhasachphuongnam.bean;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.service.PIService;

@ControllerAdvice
public class CookieUser {
	@Autowired(required = true)
	PIService piService;
	
	@ModelAttribute("user")
	public PersonalInfo getTenUser(HttpServletRequest request) {
		PersonalInfo user = new PersonalInfo();
		String ma = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					ma = String.valueOf(cookie.getValue());
				}
			}
		}
		if(ma == null)
			return user;
		user = piService.getByID(ma);
		return user;
	}
}
