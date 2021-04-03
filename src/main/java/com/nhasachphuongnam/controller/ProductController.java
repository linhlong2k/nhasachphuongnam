package com.nhasachphuongnam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.bean.*;

@Controller
 @RequestMapping("/product/list") 
public class ProductController {
	@RequestMapping()
	public String list(ModelMap model) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product("MH001", "sổ tay xinh đẹp", 10, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH002", "sổ tay xinh sắn", 10, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH003", "sổ tay xinh xẻo", 10, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH004", "sổ tay xinh quá", 10, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		model.addAttribute("prods", list);
		return "product/form";
	}

	@RequestMapping(params = "lnkEdit")
	public String edit(ModelMap model) {
		model.addAttribute("message", "Bạn chọn Edit!");
		return "product/form";
	}

	@RequestMapping(params = "lnkDelete")
	public String Delete(ModelMap model) {
		model.addAttribute("message", "Bạn gọi Delete!");
		return "product/form";
	}

}