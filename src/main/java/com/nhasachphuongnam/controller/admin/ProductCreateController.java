package com.nhasachphuongnam.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductType;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.ProductTypeService;

@Controller
@RequestMapping("admin/them-mat-hang")
public class ProductCreateController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductTypeService productTypeService;
	
	@ModelAttribute("matHang")
	public Product matHangMoi() {
		return new Product();
	}
	
	@ModelAttribute("danhSachLoaiMatHang")
	public List<ProductType> danhSachLoaiMatHang(){
		return productTypeService.getAll();
	}
	
	@GetMapping(value="")
	public String index() {
		return "admin/product/create";
	}
	
	@PostMapping(value="", params="btnCreate")
	public String createProductNew(ModelMap model,
			@RequestParam(value="photo", required = false) MultipartFile file,
			@Validated @ModelAttribute(value="matHang") Product matHang,
			BindingResult errors) {
		if(file.isEmpty()) {
			model.addAttribute("message", "không nhận được ảnh! Vui lòng chọn ảnh!");
			return "admin/product/create";
		}
		byte[] image = null;
		try {
			image = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		matHang.setHinhAnh(image);
		if (errors.hasErrors()) {
			model.addAttribute("message","Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
		} else {
			if(productService.add(matHang)) {
				model.addAttribute("message","Tạo mặt hàng mới thành công");
			} else {
				model.addAttribute("message", "Tạo mặt hàng mới không thành công!");
			}
		}
		
		model.addAttribute("danhSachMatHang", productService.getAll());
		return "admin/product/create";
	}
}
