package com.nhasachphuongnam.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/dashboard/")
public class DashboardController {
	@RequestMapping("index")
	public String index() {
		return "admin/dashboard/index";
	}
}
