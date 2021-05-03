package com.nhasachphuongnam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhasachphuongnam.bean.Product;
import com.nhasachphuongnam.bean.ProductType;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.ProductTypeService;

@Controller
@RequestMapping("/product/") 
public class ProductController {
	
	@Autowired(required=true)
	ProductService productService;
	
	@Autowired(required=true)
	ProductTypeService productTypeService;

	@RequestMapping("index")
	public String list(ModelMap model) {
		List<Product> productList = productService.getAll();
		model.addAttribute("product", productList);
		return "product/list";
	}
	
	@RequestMapping(value="create", method=RequestMethod.GET)
	public String createGet(ModelMap model) {
		List<ProductType> types = productTypeService.getAll();
		model.addAttribute("type", types);
		model.addAttribute("product", new Product()); 
		return "product/createProduct";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String createPost(ModelMap model,
			@ModelAttribute("product") Product product,
			BindingResult errors) {
			//check input value
		//tenMH
		if (product.getTenMH().trim().length() == 0) {
			errors.rejectValue("tenMH", "product", "Vui lòng nhập tên mặt hàng!");
		} else if(product.getTenMH().trim().length() > 25) {
			errors.rejectValue("tenMH", "product", "Tên mặt hàng quá dài");
		}
		//gia
		if (product.getGia() != (int)product.getGia()) {
			errors.rejectValue("Gia", "product", "Vui lòng nhập gía tiền đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("Gia", "product", "Giá tiền nhập vào không hợp lệ!");
		}
		//soLuong
		if (product.getSoLuong() != (int)product.getSoLuong()) {
			errors.rejectValue("soLuong", "product", "Vui lòng nhập số lượng đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("soLuong", "product", "Số lượng không hợp lệ!");
		}
		//Loai Mat Hang
		if (product.getMaLoai() == null) {
			errors.rejectValue("maLoai", "product", "Vui lòng chọn một loại mặt hàng!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
			
		} else {
			if(productService.add(product)) {
				model.addAttribute("message", "Tạo mặt hàng mới thành công");
			} else {
				model.addAttribute("message", "Tạo mặt hàng mới không thành công!");
			}
		}
		List<ProductType> types = productTypeService.getAll();
		model.addAttribute("type", types);
		return "product/createProduct";
	}
	
	/*
	 * @RequestMapping(value="update", method=RequestMethod.GET) public String
	 * updateGet() { return "redirect:create.htm"; }
	 */
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public String updateGet(ModelMap model,
			@PathVariable("id") String maMH) {
		List<ProductType> types = productTypeService.getAll();
		model.addAttribute("type", types);
		Product product = productService.getByID(maMH);
		model.addAttribute("product", product);
		return "product/update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updatePost(ModelMap model,
			@ModelAttribute("product") Product product,
			BindingResult errors) {
			// check input value
		// tenMH
		if (product.getTenMH().trim().length() == 0) {
			errors.rejectValue("tenMH", "product", "Vui lòng nhập tên mặt hàng!");
		} else if (product.getTenMH().trim().length() > 50) {
			errors.rejectValue("tenMH", "product", "Tên mặt hàng quá dài");
		}
		// gia
		if (product.getGia() != (int) product.getGia()) {
			errors.rejectValue("Gia", "product", "Vui lòng nhập gía tiền đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("Gia", "product", "Giá tiền nhập vào không hợp lệ!");
		}
		// soLuong
		if (product.getSoLuong() != (int) product.getSoLuong()) {
			errors.rejectValue("soLuong", "product", "Vui lòng nhập số lượng đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("soLuong", "product", "Số lượng không hợp lệ!");
		}
		// Loai Mat Hang
		if (product.getMaLoai() == null) {
			errors.rejectValue("maLoai", "product", "Vui lòng chọn một loại mặt hàng!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");

		} else {
			if (productService.update(product)) {
				model.addAttribute("message", "Cập nhật mặt hàng mới thành công");
			} else {
				model.addAttribute("message", "Cập nhật mặt hàng mới không thành công!");
			}
		}
		List<ProductType> types = productTypeService.getAll();
		model.addAttribute("type", types);
		return "product/update";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteGet(ModelMap model,
			@PathVariable("id") String maMH) {
		if(productService.delete(maMH))
			model.addAttribute("mesage", "Xóa đơn hàng " + maMH + " thành công!");
		else
			model.addAttribute("mesage", "Xóa đơn hàng " + maMH + " không thành công!");
		List<Product> productList = productService.getAll();
		model.addAttribute("product", productList);
		return "product/list";
	}
}