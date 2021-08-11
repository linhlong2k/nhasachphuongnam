package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.service.PIService;

@Controller
@RequestMapping("admin/khach-hang/")
public class CustomerController {

	@Autowired
	PIService piService;
	
	//===============================================Model-Attribute===================================
	
	
	@ModelAttribute("danhSachKhachHang")
	public List<PersonalInfo> danhSachKhachHang() {
		List<PersonalInfo> pis = piService.getAllCustomer();
		return pis;
	}
	
	//===============================================Controller========================================
	@RequestMapping("index")
	public String index(ModelMap model) {
		return "admin/customer/index";
	}
	
		//xóa luôn tài khoản của khách hàng
	@RequestMapping("xoa-khach-hang/{id}")
	public String delete(ModelMap model,
			@PathVariable("id") String ma) {
		if(piService.getByID(ma) == null)
			model.addAttribute("message", "Không tìm thấy khách hàng mã: " + ma + " để xóa!");
		else if(piService.delete(ma)) {
			model.addAttribute("message", "Xóa khách hàng mã " + ma + " thành công!");
			model.addAttribute("danhSachKhachHang", piService.getAllCustomer());
		} else {
			model.addAttribute("message", "Xóa khách hàng mã " + ma + " không thành công!");
		}
		return "admin/customer/index";
	}

}
