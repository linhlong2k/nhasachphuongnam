package com.nhasachphuongnam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/index")
public class DashboardController {
	@RequestMapping()
	public String index() {
		return "dashboard/init";
	}
}
