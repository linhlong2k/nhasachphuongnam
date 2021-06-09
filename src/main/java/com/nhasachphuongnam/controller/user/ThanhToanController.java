package com.nhasachphuongnam.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.bean.GioHang;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ProductService;

@Controller
@RequestMapping("thanh-toan")
public class ThanhToanController {
	
	@Autowired
	ProductService productService;
	
	@ModelAttribute("danhSachSanPham")
	public List<Product> danhSachSanPham(ModelMap model,
			@ModelAttribute("gioHang") List<GioHang> gioHangs) {
		long tongTien = 0;
		List<Product> res = new ArrayList<Product>();
		Product temp;
		if(gioHangs == null) {
			System.out.println("gio hang null");
			return null;
		}
		for(GioHang i: gioHangs) {
			temp  = productService.getByID(i.getMaMatHang());
			temp.setSoLuong(i.getSoLuong());
			tongTien += temp.getGia() * (1- temp.getGiamGia()) * temp.getSoLuong();
			res.add(temp);
		}
		model.addAttribute("tongTien", tongTien);
		return res;
	}

	@GetMapping(value="")
	public String index() {
		return "user/payment";
	}
	
	@PostMapping(value="")
	public String thanhToan(ModelMap model,
			@RequestParam("soDienThoai") String soDienThoai,
			@RequestParam("diaChi") String diaChi,
			@ModelAttribute("user") PersonalInfo khachHang) {
		System.out.println(soDienThoai);
		System.out.println(diaChi);
		System.out.println(khachHang.getMa());
		return "user/paymentSuccess";
	}
}
