package com.nhasachphuongnam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier/")
public class SupplierController {
	@RequestMapping("index")
	public String index() {
		return "supplier/index";
	}
}
