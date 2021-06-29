package com.nhasachphuongnam.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("huong-dan-thanh-toan")
public class GuidePaymentUserController {
	@GetMapping(value="")
	public String index() {
		return "user/guildPayment";
	}
}
