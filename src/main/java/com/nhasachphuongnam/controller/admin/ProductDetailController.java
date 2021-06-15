package com.nhasachphuongnam.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@RequestMapping("admin/chi-tiet-mat-hang")
public class ProductDetailController {
	
	Product matHang = new Product();
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductTypeService productTypeService;
	
	@ModelAttribute("matHang")
	public Product matHang() {
		return matHang;
	}
	
	@ModelAttribute("danhSachLoaiMatHang")
	public List<ProductType> danhSachLoaiMatHang(){
		return productTypeService.getAll();
	}
	
	@GetMapping(value="", params = "id")
	public String index(ModelMap model,
			@RequestParam(value="id", required=false) String id) {
		if(id.isEmpty()) {
			model.addAttribute("message", "Mã mặt hàng không xác nhận!");
			return "admin/product/detail";
		}
		this.matHang = productService.getByID(id);
		if(matHang == null) {
			this.matHang = new Product();
			model.addAttribute("message", "không tìm thấy mặt hàng có mã mặt hàng " + id + "!");
			model.addAttribute("matHang", this.matHang);
			return "admin/product/detail";
		} else {
			model.addAttribute("matHang", this.matHang);
			return "admin/product/detail";
		}
	}
	
	@PostMapping(value="", params="btnSave")
	public String btnSave(ModelMap model,
			@ModelAttribute("matHang") Product product,
			BindingResult errors) {
			// check input value
		// tenMatHang
		if (product.getTenMatHang().trim().length() == 0) {
			errors.rejectValue("tenMatHang", "matHang", "Vui lòng nhập tên mặt hàng!");
		} else if (product.getTenMatHang().trim().length() > 50) {
			errors.rejectValue("tenMatHang", "matHang", "Tên mặt hàng quá dài");
		}
		// gia
		if (product.getGia() <= 0) {
			errors.rejectValue("Gia", "matHang", "Giá tiền nhập vào không hợp lệ!");
		}
		// soLuong
		if (product.getSoLuong() != (int) product.getSoLuong()) {
			errors.rejectValue("soLuong", "matHang", "Vui lòng nhập số lượng đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("soLuong", "matHang", "Số lượng không hợp lệ!");
		}
		// Loai Mat Hang
		if (product.getMaLoai() == null) {
			errors.rejectValue("maLoai", "matHang", "Vui lòng chọn một loại mặt hàng!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");

		} else {
			if (productService.update(product))
				model.addAttribute("message", "Cập nhật mặt hàng có mã mặt hàng " + product.getMaMatHang() + " thành công");
			else
				model.addAttribute("message", "Cập nhật mặt hàng có mã mặt hàng " + product.getMaMatHang() + " không thành công!");
		}
		return "admin/product/detail";
	}
	
	@GetMapping(value="", params="uploadPhotoId")
	public String uploadPhotoGET(ModelMap model) {
		return "admin/product/uploadPhoto";
	}
	
	@PostMapping(value="", params="uploadPhotoId")
	public String uploadPhotoPOST(ModelMap model,
			@RequestParam("uploadPhotoId") String id,
			@RequestParam(value="photo", required = false) MultipartFile file) {
		if(file.isEmpty()) {
			model.addAttribute("message", "không nhận được ảnh! Vui lòng chọn ảnh!");
			return "admin/product/uploadPhoto";
		}
		byte[] image = null;
		try {
			image = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Product product = productService.getByID(id);
		product.setHinhAnh(image);
		if (productService.update(product)) {
			this.matHang = product;
			model.addAttribute("matHang", this.matHang);
			model.addAttribute("message", "Cập nhật hình ảnh cho mặt hàng " + id + " thành công");
		}
		else {
			model.addAttribute("message", "Cập nhật hình ảnh cho mặt hàng " + id + " không thành công");
		}
		return "admin/product/detail";
	}
}
