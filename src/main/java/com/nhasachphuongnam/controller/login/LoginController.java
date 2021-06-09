
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

	@Autowired(required = true)
	LoginService loginService;

	@Autowired(required = true)
	RoleDAO roleDAO;

	@Autowired(required = true)
	NhanVienDAO nhanVienDAO;
	
	@Autowired(required = true)
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
	
	/*
	 * @RequestMapping(value="dang-ky", method=RequestMethod.GET) public String
	 * registerGET(ModelMap model) { return "login/register"; }
	 * 
	 * @RequestMapping(value = "dangky", method = RequestMethod.POST) public String
	 * registerPOST(ModelMap model,
	 * 
	 * @ModelAttribute("khachHangMoi") KhachHang khachHang,
	 * 
	 * @RequestParam("username") String username,
	 * 
	 * @RequestParam("password") String password,
	 * 
	 * @RequestParam("passwordconfirm") String passwordConfirm, BindingResult
	 * errors) { if (khachHang.getTen().trim().length() == 0) {
	 * errors.rejectValue("ten", "thongtincanhan", "Vui lòng nhập tên!"); } if
	 * (info.getSdt().trim().length() == 0) { errors.rejectValue("sdt",
	 * "thongtincanhan", "Vui lòng nhập số điện thoại!"); } if
	 * (info.getDiaChi().trim().length() == 0) { errors.rejectValue("diaChi",
	 * "thongtincanhan", "Vui lòng nhập địa chỉ!"); }
	 * 
	 * if (loginDAO.getByID(username) != null) { model.addAttribute("message",
	 * "Tên đăng nhập đã tồn tại"); return "login/register"; }
	 * if(!password.equals(passwordConfirm)) { model.addAttribute("message",
	 * "Mật khẩu xác nhận không trùng khớp"); return "login/register"; } Login login
	 * = new Login(); login.setUsername(username); login.setPassword(password);
	 * login.setRole("0"); if(loginDAO.insert(login)) { info.setLogin(login);
	 * if(thongTinCaNhanDAO.insert(info)) { model.addAttribute("message",
	 * "Tạo tài khoản mới thành công"); } else { model.addAttribute("message",
	 * "Không thể khởi tạo thông tin cá nhân mới"); } } else {
	 * model.addAttribute("message", "Không thể khởi tạo thông tin đăng nhập mới");
	 * } return "login/register"; }
	 */
	
	@RequestMapping("dang-xuat")
	public String dangXuat(HttpServletResponse response) {
		Cookie cookie = new Cookie("user", null); // Not necessary, but saves bandwidth.
		cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
		response.addCookie(cookie);
		cookie = new Cookie("role", null); // Not necessary, but saves bandwidth.
		cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
		response.addCookie(cookie);
		return "user/index";
	}
}
