package com.nhasachphuongnam.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/")
public class DashboardController {
	@RequestMapping("index")
	public String index() {
		return "dashboard/index";
	}
}
