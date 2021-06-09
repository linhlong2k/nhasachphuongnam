package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductType;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.ProductTypeService;

@Controller
@RequestMapping("admin/loai-mat-hang/")
public class ProductTypeController {
	
	@Autowired
	ProductTypeService productTypeService;
	
	@Autowired
	ProductService productService;
	
	//===============================================Model-Attribute===================================
	

	@ModelAttribute("danhSachLoaiMatHang")
	public List<ProductType> danhSachLoaiMatHang() {
		List<ProductType> loaiMatHangs = productTypeService.getAll();
		return loaiMatHangs;
	}

	
	@ModelAttribute("loaiMatHangMoi")
	public ProductType loaiMatHangMoi() {
		return new ProductType();
	}
	
	@ModelAttribute("loaiMatHangChinhSua")
	public ProductType loaiMatHangChinhSua() {
		return new ProductType();
	}

	@ModelAttribute("danhSachMatHang")
	public List<Product> danhSachMatHang() {
		return productService.getAll();
	}
	
	//===============================================Controller========================================
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String typeIndex(ModelMap model) {
		return "admin/product/productType";
	}
	
	@RequestMapping(value="tao-loai-mat-hang-moi", method=RequestMethod.POST)
	public String createType(ModelMap model,
			@ModelAttribute("ProductType") ProductType type,
			@ModelAttribute("newType") ProductType newType,
			BindingResult errors) {
		if (newType.getTenLoai().trim().length() == 0) {
			errors.rejectValue("tenLoai", "newType", "Vui lòng nhập tên loại!");
		} else if (newType.getTenLoai().trim().length() > 50) {
			errors.rejectValue("tenLoai", "newType", "Tên loại không được dài quá 50 kí tự!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
		} else
			if (productTypeService.add(type)) {
				model.addAttribute("message", "Thêm loại mặt hàng thành công");
				model.addAttribute("danhSachLoaiMatHang", productTypeService.getAll());
			} else
				model.addAttribute("message", "Thêm loại mặt hàng không thành công!");
		return "admin/product/productType";
	}
	
	@RequestMapping(value="chinh-sua-loai-mat-hang/{id}", method=RequestMethod.POST)
	public String updateType(ModelMap model,
			@ModelAttribute("ProductType") ProductType type,
			@PathVariable("id") String typeID,
			BindingResult errors) {
		if (type.getTenLoai().trim().length() == 0) {
			errors.rejectValue("tenLoai", "ProductType", "Vui lòng nhập tên loại!");
		} else if (type.getTenLoai().trim().length() > 50) {
			errors.rejectValue("tenLoai", "ProductType", "Tên loại không được dài quá 50 kí tự!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
		} else
			if (productTypeService.update(type)) {
				model.addAttribute("message", "Cập nhật loại mặt hàng thành công");
				model.addAttribute("danhSachLoaiMatHang", productTypeService.getAll());
			} else
				model.addAttribute("message", "Cập nhật loại mặt hàng không thành công!");
		
		return "admin/product/productType";
	}
	
	@RequestMapping(value="xoa-loai-mat-hang/{id}", method=RequestMethod.POST)
	public String deleteType(ModelMap model,
			@ModelAttribute("ProductType") ProductType type,
			@PathVariable("id") String typeID) {
		if(productTypeService.getByID(typeID) == null)
			model.addAttribute("message", "Không tìm thấy mã loại mặt hàng " + typeID);
		else if(productTypeService.delete(typeID)) {
			model.addAttribute("message", "Xóa loại mặt hàng " + typeID + " thành công!");
			model.addAttribute("danhSachLoaiMatHang", productTypeService.getAll());
		} else
			model.addAttribute("message", "Xóa loại mặt hàng " + typeID + " không thành công!");
		
		return "admin/product/productType";
	}
	
	@RequestMapping(value="chi-tiet-loai-mat-hang/{id}", method=RequestMethod.POST)
	public String detailType(ModelMap model,
			@PathVariable("id") String typeID) {
		model.addAttribute("danhSachMatHang", productService.getProductListByType(typeID));
		return "admin/product/productType";
	}
}
