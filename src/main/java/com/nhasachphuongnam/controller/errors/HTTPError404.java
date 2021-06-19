package com.nhasachphuongnam.controller.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("404")
public class HTTPError404 {
	
	@GetMapping(value="")
	public String index() {
		return "ERROR/404";
	}
}
