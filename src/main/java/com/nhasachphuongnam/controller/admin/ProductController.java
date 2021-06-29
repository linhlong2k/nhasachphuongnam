package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ProductService;

@Controller
@RequestMapping("admin/mat-hang") 
public class ProductController {
	
	@Autowired
	ProductService productService;

	//===============================================Model-Attribute===================================
	

	@ModelAttribute("danhSachMatHang")
	public List<Product> danhSachMatHang(){
		List<Product> matHangs = productService.getAll();
		return matHangs;
	}
	
	//===============================================Controller========================================
	@GetMapping(value="")
	public String list(ModelMap model) {
		return "admin/product/list";
	}
	
	@PostMapping(value="", params="btnDetailId")
	public String productDetail(ModelMap model,
			@RequestParam(value = "btnDetailId", required = false) String id) {
		return "redirect:chi-tiet-mat-hang.htm?id="+id;		//không hiểu sao phải bỏ chữ admin mới chạy đúng được
	}
	
	@PostMapping(value="", params="btnDiscountId")
	public String productDiscount(ModelMap model,
			@RequestParam(value="btnDiscountId", required = false) String id,
			@RequestParam(value="giamGia", required = false) Float giamGia) {
		if(id.isEmpty()) {
			model.addAttribute("message", "Mã mặt hàng không xác định");
			return "admin/product/list";
		}
		if(giamGia.isNaN()) {
			model.addAttribute("message", "Mã giảm giá không đúng định dạng!");
			return "admin/product/list";
		}
		if(productService.updateDiscount(id, giamGia)){
			model.addAttribute("message", "Mặt hàng " + id + " có giảm giá mới là " + giamGia * 100 + "%");
			model.addAttribute("danhSachMatHang", this.danhSachMatHang());
			return "admin/product/list";
		}
		model.addAttribute("message", "Cập nhập giảm giá cho mặt hàng " + id + " không thành công!");
		return "admin/product/list";
	}
	
	@PostMapping(value="", params="btnDeleteId")
	public String productDelete(ModelMap model,
			@RequestParam(value="btnDeleteId", required=false) String id) {
		if(id.isEmpty()) {
			model.addAttribute("message", "Mã mặt hàng không xác định!");
			return "admin/product/list";
		}
		if(productService.getByID(id) == null) {
			model.addAttribute("message", "Không tìm thấy mặt hàng " + id + "!");
		} else if (productService.delete(id)) {
			model.addAttribute("message", "Xóa mặt hàng " + id + " thành công!");	
		} else {
			model.addAttribute("message", "Xóa mặt hàng " + id + " không thành công!");
		}
		
		model.addAttribute("danhSachMatHang", this.danhSachMatHang());
		return "admin/product/list";
	}
}