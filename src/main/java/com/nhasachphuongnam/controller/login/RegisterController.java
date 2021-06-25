package com.nhasachphuongnam.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.RoleDTO;
import com.nhasachphuongnam.service.LoginService;
import com.nhasachphuongnam.service.PIService;
import com.nhasachphuongnam.service.RoleService;

@Controller
@RequestMapping("dang-ky")
public class RegisterController {

	@Autowired
	LoginService loginService;

	@Autowired
	RoleService roleService;

	@Autowired
	PIService piService;

	// ==========================================model-attribute===============================

	@ModelAttribute("khachHangMoi")
	public PersonalInfo khachHangMoi() {
		return new PersonalInfo();
	}

	@GetMapping(value = "")
	public String registerGET(ModelMap model) {
		return "login/register";
	}

	@PostMapping(value = "")
	public String registerPOST(ModelMap model, @Validated @ModelAttribute("khachHangMoi") PersonalInfo khachHang,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordconfirm", required = false) String passwordConfirm, BindingResult errors) {
		if(password.trim().length() == 0) {
			model.addAttribute("notification", "Mật khẩu không được để trống!");
		}
		if (!password.equals(passwordConfirm)) {
			model.addAttribute("notification", "Mật khẩu xác nhận không trùng khớp");
			return "login/register";
		}
		if (loginService.getByID(khachHang.getUsername()) != null) {
			model.addAttribute("notification", "Tên đăng nhập đã tồn tại");
			return "login/register";
		}
		if(errors.hasErrors()) {
			model.addAttribute("notification", "Thông tin nhập vào không hợp lệ, vui lòng nhập lại!");
		} else {
			Login login = new Login();
			login.setUsername(khachHang.getUsername());
			login.setPassword(password);
			RoleDTO role = roleService.getByID("2");
			login.setRole(role);
			khachHang.setMaRole("2");
			if (piService.add(khachHang, login)) {
				model.addAttribute("message", "Tạo tài khoản mới thành công");
			} else {
				model.addAttribute("notification", "Không thể khởi tạo thông tin đăng nhập mới");
			}
		}
		return "login/register";
	}
}
