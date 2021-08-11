package com.nhasachphuongnam.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.service.LoginService;
import com.nhasachphuongnam.tools.EncryptSHA1;

@Controller
@RequestMapping("thay-doi-mat-khau")
public class UserPasswordUserController {
	
	EncryptSHA1 encrypt = new EncryptSHA1();
	
	@Autowired
	LoginService loginService;
	
	@GetMapping(value="")
	public String index() {
		return "user/infoPassword";
	}
	
	@PostMapping(value="")
	public String changePassword(ModelMap model,
			@ModelAttribute("user") PersonalInfo user,
			@RequestParam(value="passwordOld", required=false) String passwordOld,
			@RequestParam(value="password", required = false) String password,
			@RequestParam(value="passwordConfirm", required = false) String passwordConfirm) {
		if(password.isEmpty()) {
			model.addAttribute("message", "Mật khẩu không được để trống!");
			return "user/infoPassword";
		}
		if(!passwordConfirm.equals(password)) {
			model.addAttribute("message", "Mật khẩu xác nhận không trùng khớp");
			return "user/infoPassword";
		}
		Login login = loginService.getByID(user.getUsername());
		if(login == null) {
			model.addAttribute("message", "Người dùng không xác thực");
			return "user/infoPassword";
		}
		if(!login.getPassword().equals(encrypt.encrypt(passwordOld))) {
			model.addAttribute("message", "Mật khẫu cũ không chính xác!");
			return "user/infoPassword";
		}
		login.setPassword(passwordConfirm);
		if(loginService.update(login)) {
			model.addAttribute("notification", "Cập nhật mật khẩu mới thành công!");
		} else {
			model.addAttribute("message", "Cập nhật mật khẩu không thành công!");
		}
		return "user/infoPassword";
	}
}
