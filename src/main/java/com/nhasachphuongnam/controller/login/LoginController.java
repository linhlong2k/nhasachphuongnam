
package com.nhasachphuongnam.controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhasachphuongnam.dao.KhachHangDAO;
import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.dao.RoleDAO;
import com.nhasachphuongnam.entity.KhachHang;
import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	NhanVienDAO nhanVienDAO;
	
	@Autowired
	KhachHangDAO khachHangDAO;

	// ==========================================model-attribute===============================

	@ModelAttribute("thongTinDangNhap")
	public Login dangNhapMoi() {
		return new Login();
	}
	
	@ModelAttribute("khachHangMoi")
	public KhachHang khachHangMoi() {
		return new KhachHang();
	}

	// ==========================================controller====================================
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login/login";
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public String login(ModelMap model,
			HttpServletResponse response,
			@ModelAttribute("thongTinDangNhap") Login login,
			BindingResult errors) {
		Login newLogin = null;
		if (login.getUsername().trim().length() == 0) {
			errors.rejectValue("username", "thongTinDangNhap", "Vui lòng nhập tên đăng nhập!");
		} else {
			newLogin = loginService.getByID(login.getUsername());
		}
		if (login.getPassword().trim().length() == 0) {
			errors.rejectValue("password", "thongTinDangNhap", "Vui lòng nhập mật khẩu!");
		} else if (loginService.checkLogin(login)) {
			if(newLogin.getRole().getMaRole().equals("0") || newLogin.getRole().getMaRole().equals("1")) {
				Cookie userCookie = new Cookie("user", String.valueOf(nhanVienDAO.getMaByUsername(newLogin.getUsername())));
				userCookie.setMaxAge(24 * 60 * 60);
				response.addCookie(userCookie);
				Cookie roleCookie = new Cookie("role", newLogin.getRole().getMaRole());
				roleCookie.setMaxAge(24 * 60 * 60);
				response.addCookie(roleCookie);
			} else {
				Cookie userCookie = new Cookie("user", String.valueOf(khachHangDAO.getMaByUsername(newLogin.getUsername())));
				userCookie.setMaxAge(24 * 60 * 60);
				response.addCookie(userCookie);
				Cookie roleCookie = new Cookie("role", newLogin.getRole().getMaRole());
				roleCookie.setMaxAge(24 * 60 * 60);
				response.addCookie(roleCookie);
			}
			return "redirect:/.htm";
		} else {
			model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không chính xác!");
		}
		return "login/login";
	}
	 
}
