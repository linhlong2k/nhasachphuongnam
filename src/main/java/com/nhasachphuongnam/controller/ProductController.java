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
		list.add(new Product("MH002", "sổ tay xinh sắn", 20, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH003", "sổ tay xinh xẻo", 30, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH004", "sổ tay xinh quá", 40, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		list.add(new Product("MH005", "sổ tay xinh đẹp", 50, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH006", "sổ tay xinh sắn", 60, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH007", "sổ tay xinh xẻo", 70, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH008", "sổ tay xinh quá", 80, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		list.add(new Product("MH009", "sổ tay xinh đẹp", 10, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH010", "sổ tay xinh sắn", 20, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH011", "sổ tay xinh xẻo", 30, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH012", "sổ tay xinh quá", 40, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
		list.add(new Product("MH013", "sổ tay xinh đẹp", 50, "đây là cuốn sổ tay", "sổ tay này xinh đẹp", "assets/images/products/chibi1.jpg", "Loai02"));
		list.add(new Product("MH014", "sổ tay xinh sắn", 60, "đây là cuốn sổ tay", "sổ tay này xinh sắn", "assets/images/products/chibi2.jpg", "Loai04"));
		list.add(new Product("MH015", "sổ tay xinh xẻo", 70, "đây là cuốn sổ tay", "sổ tay này xinh xẻo", "assets/images/products/chibi1.jpg", "Loai03"));
		list.add(new Product("MH016", "sổ tay xinh quá", 80, "đây là cuốn sổ tay", "sổ tay này xinh quá", "assets/images/products/chibi2.jpg", "Loai01"));
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