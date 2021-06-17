package com.nhasachphuongnam.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.PIService;

@Controller
@RequestMapping("thong-tin-ca-nhan")
public class ThongTinController {
	
	@Autowired
	PIService piService;
	
	@Autowired
	ExportOrderService eoService;
	
	@ModelAttribute("danhSachDonHang")
	public List<ExportOrder> danhSachDonHang(){
		return eoService.getAll();
	}
	
	@GetMapping(value="")
	public String index() {
		return "user/info";
	}

}
