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

import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.service.ExportOrderService;

@Controller
@RequestMapping("admin/don-hang-xuat")
public class ExportOrderController {
	
	@Autowired
	ExportOrderService eoService;
	
	@ModelAttribute("danhSachHoaDon")
	public List<ExportOrder> danhSachHoaDon() {
		List<ExportOrder> res = eoService.getAll();
		return res;
	}
	
	@GetMapping(value="")
	public String index() {
		return "admin/orders/export";
	}
	
	@PostMapping(value="", params="deleteOrderId")
	public String deleteExportOrder(ModelMap model,
			@RequestParam(value="deleteOrderId", required=false) String id) {
		if(eoService.getByID(id) == null) {
			model.addAttribute("message", "Không tìm thấy đơn hàng có mã đơn hàng " + id + "!");
		} else if(eoService.delete(id)) {
			model.addAttribute("message", "xóa đơn hàng " + id + " thành công!");
			model.addAttribute("danhSachHoaDon", eoService.getAll());
		} else {
			model.addAttribute("message", "Xóa đơn hàng " + id + " không thành công!");
		}
		return "admin/orders/export";	
	}
}