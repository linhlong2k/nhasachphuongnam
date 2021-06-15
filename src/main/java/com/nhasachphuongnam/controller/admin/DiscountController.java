package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ProductService;

@Controller
@RequestMapping("admin/giam-gia")
public class DiscountController {
	
	@Autowired
	ProductService productService;
	
	@ModelAttribute("danhSachMatHang")
	public List<Product> danhSachMatHang(){
		List<Product> res = productService.getAll();
		return res;
	}
	
	@GetMapping(value="")
	public String index() {
		return "admin/product/discount";
	}

}
