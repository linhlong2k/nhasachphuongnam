package com.nhasachphuongnam.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GioiThieuController {
	@RequestMapping("gioi-thieu")
	public String index() {
		return "user/introduce";
	}
}
