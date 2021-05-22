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
@RequestMapping("/khach-hang/")
public class CustomerController {

	@Autowired(required=true)
	PIService piService;
	
	//===============================================Model-Attribute===================================
	
	@ModelAttribute("danhSachKhachHang")
	public List<PersonalInfo> danhSachKhachHang(){
		List<PersonalInfo> pis = piService.getAllKhachHang();
		return pis;
	}
	
	//===============================================Controller========================================
	@RequestMapping("index")
	public String index(ModelMap model) {
		return "admin/customer/index";
	}
	
		//xóa luôn tài khoản của khách hàng
	@RequestMapping("xoa-khach-hang/{id}")
	public String deleteGET(ModelMap model,
			@PathVariable("id") String ma) {
		if(piService.getByID(ma) == null)
			model.addAttribute("message", "Không tìm thấy khách hàng mã: " + ma + " để xóa!");
		else if(piService.delete(ma)) {
			model.addAttribute("message", "Xóa khách hàng mã " + ma + " thành công!");
			model.addAttribute("danhSachNhanVien", piService.getAllKhachHang());
		} else
			model.addAttribute("message", "Xóa khách hàng mã " + ma + " không thành công!");
		return "admin/staff/index";
	}

}
