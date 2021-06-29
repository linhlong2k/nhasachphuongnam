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

import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.service.ImportOrderService;

@Controller
@RequestMapping("admin/don-hang-nhap")
public class ImportOrderController {
	@Autowired
	ImportOrderService ioService;
	
	@ModelAttribute("danhSachPhieuNhap")
	public List<ImportOrder> danhSachPhieuNhap() {
		List<ImportOrder> res = ioService.getAll();
		return res;
	}
	
	@GetMapping(value="")
	public String index() {
		return "admin/orders/import";
	}
	
	@PostMapping(value="", params="deleteOrderId")
	public String deleteImportOrder(ModelMap model,
			@RequestParam(value="deleteOrderId", required=false) String id) {
		if(ioService.getByID(id) == null) {
			model.addAttribute("message", "Không tìm thấy đơn hàng có mã đơn hàng " + id + "!");
		} else if(ioService.delete(id)) {
			model.addAttribute("message", "xóa đơn hàng " + id + " thành công!");
			model.addAttribute("danhSachPhieuNhap", ioService.getAll());
		} else {
			model.addAttribute("message", "Xóa đơn hàng " + id + " không thành công!");
		}
		return "admin/orders/import";	
	}
}
