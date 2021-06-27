package com.nhasachphuongnam.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.service.ImportOrderService;
import com.nhasachphuongnam.service.PIService;
import com.nhasachphuongnam.service.SupplierService;

@Controller
@RequestMapping("admin/chi-tiet-phieu-nhap")
public class ImportOrderDetailController {
	
	private ImportOrder importOrder;
	
	@Autowired
	ImportOrderService ioService;
	
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	PIService piService;
	
	@ModelAttribute("donHang")
	public ImportOrder donHang(ModelMap model) {
		if(this.importOrder != null) {
			if(this.importOrder.getMaNhaCungCap() != null) {
				model.addAttribute("nhaCungCap", supplierService.getByID(this.importOrder.getMaNhaCungCap()));
			}
			if(this.importOrder.getMaNhanVien() != null) {
				model.addAttribute("nhanVien", piService.getByID(this.importOrder.getMaNhanVien()));
			}
			long tongTien = 0;
			for(ProductDetail i: this.importOrder.getChiTiets()) {
				tongTien += i.getGia() * (1 - i.getGiamGia()) * i.getSoLuong();
			}
			model.addAttribute("tongTien", tongTien);
			return this.importOrder;
		}
		return null;
	}
	
	@GetMapping(value="{id}")
	public String index(ModelMap model,
			@PathVariable("id") String id) {
		if(id != null) {
			this.importOrder = ioService.getByID(id);
			model.addAttribute("donHang", this.donHang(model));
		}
		return "admin/orders/ImportOrderDetail";
	}
	
	@PostMapping(value="{id}")
	public String print() {
		return "admin/orders/ImportOrderPrint";
	}
}
