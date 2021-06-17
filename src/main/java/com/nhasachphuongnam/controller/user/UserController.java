package com.nhasachphuongnam.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ProductService;

@Controller
public class UserController {
	@Autowired
	ProductService productService;
	
	@ModelAttribute("danhSachSanPham")
	public List<Product> danhSachSanPham(){
		return productService.getAll();
	}
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}
}
