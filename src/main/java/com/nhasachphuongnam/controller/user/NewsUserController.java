package com.nhasachphuongnam.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsUserController {
	@RequestMapping("tin-tuc")
	public String index() {
		return "user/news";
	}
}
