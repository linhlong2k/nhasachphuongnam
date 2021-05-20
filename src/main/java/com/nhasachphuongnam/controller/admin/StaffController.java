package com.nhasachphuongnam.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff/")
public class StaffController {
	@RequestMapping("index")
	public String index() {
		return "staff/index";
	}
}
