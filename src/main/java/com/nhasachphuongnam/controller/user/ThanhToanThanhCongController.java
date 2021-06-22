package com.nhasachphuongnam.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.service.ExportOrderService;

@Controller
@RequestMapping("thanh-toan/thanh-toan-thanh-cong")
public class ThanhToanThanhCongController {
	private String maDonHang;
	
	@Autowired
	ExportOrderService eoService;
	
	@ModelAttribute("donHang")
	public ExportOrder donHang() {
		if(this.maDonHang != null) {
			return eoService.getByID(maDonHang);
		}
		return null;
	}
	@GetMapping(value="{id}")
	public String index(
			@PathVariable("id") String id) {
		this.maDonHang = id;
		return "user/paymentSuccess";
	}
	
	@GetMapping(value="{id}", params="printInvoice")
	public String printInvoice() {
		return "user/invoice";
	}
}
