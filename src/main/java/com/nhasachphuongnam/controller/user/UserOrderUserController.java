package com.nhasachphuongnam.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.service.ExportOrderService;

@Controller
@RequestMapping("thong-tin-don-hang")
public class UserOrderUserController {
	
	@Autowired
	ExportOrderService eoService;
	
	@ModelAttribute("danhSachDonHang")
	public List<ExportOrder> danhSachDonHang(@ModelAttribute("user") PersonalInfo user){
		return eoService.getAllByCustomerID(user.getMa());
	}
	
	@GetMapping(value="")
	public String index() {
		return "user/infoOrder";
	}
}
