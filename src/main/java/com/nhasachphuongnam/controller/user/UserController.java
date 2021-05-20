package com.nhasachphuongnam.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nguoi-dung")
public class UserController {
	@RequestMapping("index")
	public String index() {
		return "user/index";
	}
}
