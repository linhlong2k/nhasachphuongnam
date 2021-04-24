package com.nhasachphuongnam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nhasachphuongnam.bean.*;

@Controller
@RequestMapping("/product/index") 
public class ProductController {
	@RequestMapping()
	public String list(ModelMap model) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product("MH001", "sổ tay xinh đẹp", 10000, 10, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH002", "sổ tay xinh sắn", 50000, 20, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH003", "sổ tay xinh xẻo", 60000, 30, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH004", "sổ tay xinh quá", 70000, 40, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		list.add(new Product("MH005", "sổ tay xinh đẹp", 88000, 50, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH006", "sổ tay xinh sắn", 13000, 60, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH007", "sổ tay xinh xẻo", 40000, 70, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH008", "sổ tay xinh quá", 60000, 80, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		list.add(new Product("MH009", "sổ tay xinh đẹp", 40000, 10, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH010", "sổ tay xinh sắn", 10000, 20, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH011", "sổ tay xinh xẻo", 20000, 30, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH012", "sổ tay xinh quá", 70000, 40, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		list.add(new Product("MH013", "sổ tay xinh đẹp", 40000, 50, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH014", "sổ tay xinh sắn", 70000, 60, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH015", "sổ tay xinh xẻo", 70000, 70, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH016", "sổ tay xinh quá", 50000, 80, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		model.addAttribute("prods", list);
		return "product/list";
	}
	@RequestMapping(params = "btnCreate")
	public String create(ModelMap model,
			@ModelAttribute("product") Product product) {
		
		model.addAttribute("label", "TẠO MẶT HÀNG MỚI!");
		return "product/list";
	}
	
	@RequestMapping(params = "lnkEdit")
	public String edit(ModelMap model) {
		model.addAttribute("label", "CHỈNH SỬA MẶT HÀNG!");
		model.addAttribute("product", new Product());
		return "product/update";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String editPost(ModelMap model,
			@ModelAttribute("product") Product product) {
		if("chỉnh sửa thất bại".equals("abc")) {
			model.addAttribute("message", "Chỉnh sửa thất bại");
			return "product/list";
		}
		model.addAttribute("message", "Chỉnh sửa thành công");
		return "product/list";
	}

	@RequestMapping(params = "lnkDelete")
	public String Delete(ModelMap model) {
		model.addAttribute("message", "Bạn gọi Delete!");
		return "product/list";
	}

}