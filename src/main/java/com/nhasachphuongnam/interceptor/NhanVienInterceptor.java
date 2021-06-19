package com.nhasachphuongnam.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class NhanVienInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("role")) {
					if(cookie.getValue().equals("0") || cookie.getValue().equals("1")) {
						return true;
					} else {
						response.sendRedirect(request.getContextPath() + "/403.htm");
						return false;
					}
				}
			}
		}
		response.sendRedirect(request.getContextPath() + "/403.htm");
		return false;
	}
}