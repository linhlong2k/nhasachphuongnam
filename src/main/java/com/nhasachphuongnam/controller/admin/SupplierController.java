package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhasachphuongnam.model.Supplier;
import com.nhasachphuongnam.service.SupplierService;

@Controller
@RequestMapping("admin/nha-cung-cap/")
public class SupplierController {

	@Autowired(required = true)
	SupplierService supplierService;
	

	@ModelAttribute("danhSachNhaCungCap")
	public List<Supplier> danhSachNhaCungCap() {
		List<Supplier> res = supplierService.getAll();
		return res;
	}
	 
	
	@ModelAttribute("nhaCungCapNew")
	public Supplier nhaCungCapNew() {
		return new Supplier();
	}
	
	@ModelAttribute("nhaCungCapIndex")
	public Supplier nhaCungCapIndex() {
		return new Supplier();
	}

	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index() {
		return "admin/supplier/index";
	}
	
	@RequestMapping(value="index", params = "chinh-sua-nha-cung-cap", method=RequestMethod.POST)
	public String updateSupplier(ModelMap model,
			@ModelAttribute("nhaCungCapIndex") Supplier supplier) {
		model.addAttribute("nhaCungCapNew", supplierService.getByID(supplier.getMaNhaCungCap()));
		return "admin/supplier/index";
	}
	
	@RequestMapping(value="index", params = "xoa-nha-cung-cap", method=RequestMethod.POST)
	public String deleteSupplier(ModelMap model,
			@ModelAttribute("nhaCungCapIndex") Supplier supplier) {
		if(supplierService.getByID(supplier.getMaNhaCungCap()) == null)
			model.addAttribute("message", "Không tìm thấy nhà cung cấp này trong database");
		else if(supplierService.delete(supplier.getMaNhaCungCap())) {
			model.addAttribute("message", "Xóa nhà cung cấp " + supplier.getMaNhaCungCap() + " thành công");
			model.addAttribute("danhSachNhaCungCap", supplierService.getAll());
		} else
			model.addAttribute("message", "Xóa nhà cung cấp " + supplier.getMaNhaCungCap() + " không thành công");
		return "admin/supplier/index";
	}
	
	@RequestMapping(value="cap-nhat-nha-cung-cap", method=RequestMethod.POST)
	public String mergeSupplier(ModelMap model,
			@ModelAttribute("nhaCungCapNew") Supplier supplier,
			BindingResult errors) {
		if (supplier.getTenNhaCungCap().trim().length() == 0) {
			errors.rejectValue("tenNhaCungCap", "nhaCungCapNew", "Vui lòng nhập tên nhà cung cấp!");
		} else
			if(supplierService.getByID(supplier.getMaNhaCungCap()) == null)
				if (supplierService.add(supplier)) {
					model.addAttribute("message", "Thêm nhà cung cấp " + supplier.getMaNhaCungCap() + " thành công");
					model.addAttribute("danhSachNhaCungCap", supplierService.getAll());
					model.addAttribute("nhaCungCapNew", new Supplier()); 
				} else
					model.addAttribute("message", "Thêm nhà cung cấp " + supplier.getMaNhaCungCap() + " không thành công");
			else
				if (supplierService.update(supplier)) {
					model.addAttribute("message", "Cập nhật nhà cung cấp " + supplier.getMaNhaCungCap() + " thành công");
					model.addAttribute("danhSachNhaCungCap", supplierService.getAll());
					model.addAttribute("nhaCungCapNew", new Supplier()); 
				} else
					model.addAttribute("message", "Cập nhật nhà cung cấp " + supplier.getMaNhaCungCap() + " không thành công");
		return "admin/supplier/index";
	}
	
	@RequestMapping(value="cap-nhat-nha-cung-cap", params = "reset", method=RequestMethod.POST)
	public String removeAllInfomation(ModelMap model) {
		model.addAttribute("nhaCungCapNew", new Supplier());
		return "admin/supplier/index";
	}
}
