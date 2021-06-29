package com.nhasachphuongnam.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PolicyUserController {
	@RequestMapping("chinh-sach")
	public String index() {
		return "user/policy";
	}
}
