package com.nhasachphuongnam.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.service.PIService;

@ControllerAdvice
public class CookieUser {
	@Autowired
	PIService piService;
	
	@ModelAttribute("user")
	public PersonalInfo getTenUser(HttpServletRequest request,
			@CookieValue(value="user", required = false) String maUser) {
		PersonalInfo user = new PersonalInfo();
		/*
		 * String ma = null; Cookie[] cookies = request.getCookies(); if (cookies !=
		 * null) { for (Cookie cookie : cookies) { if (cookie.getName().equals("user"))
		 * { ma = String.valueOf(cookie.getValue()); } } } if(ma == null) { return user;
		 * } user = piService.getByID(ma);
		 */
		if(maUser == null) {
			return user;
		}
		user = piService.getByID(maUser);
		return user;
	}
}
