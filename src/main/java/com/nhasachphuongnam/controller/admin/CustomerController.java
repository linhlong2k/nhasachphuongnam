package com.nhasachphuongnam.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@RequestMapping("index")
	public String index() {
		return "customer/index";
	}

}
