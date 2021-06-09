package com.nhasachphuongnam.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LienHeController {
	@RequestMapping("lien-he")
	public String index() {
		return "user/contact";
	}
}
