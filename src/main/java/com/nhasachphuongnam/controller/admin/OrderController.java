
package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.ImportOrderService;

@Controller

@RequestMapping("admin/don-hang/")
public class OrderController {

	@Autowired
	ExportOrderService exService;
	
	@Autowired
	ImportOrderService ioService;
	
	@ModelAttribute("danhSachHoaDon")
	public List<ExportOrder> danhSachHoaDon() {
		List<ExportOrder> res = exService.getAll();
		return res;
	}

	@ModelAttribute("danhSachPhieuNhap")
	public List<ImportOrder> danhSachPhieuNhap() {
		List<ImportOrder> res = ioService.getAll();
		return res;
	}

	@RequestMapping("index")
	public String index() {
		return "admin/orders/index";
	}
	
	@RequestMapping("xoa-don-hang/{id}")
	public String deleteDonHang(ModelMap model,
			@PathVariable("id") String id) {
		if(id.substring(0, 2).equals("HD")) {
			if(exService.getByID(id) == null) {
				model.addAttribute("message", "Không tìm thấy đơn hàng có mã đơn hàng " + id + "!");
			} else if(exService.delete(id)) {
				model.addAttribute("message", "Xóa đơn hàng " + id + " thành công!");
				model.addAttribute("danhSachHoaDon", exService.getAll());
			} else {
				model.addAttribute("message", "Xóa đơn hàng " + id + " không thành công!");
			}
		} else {
			if(ioService.getByID(id) == null) {
				model.addAttribute("message", "Không tìm thấy đơn hàng có mã đơn hàng " + id + "!");
			} else if(ioService.delete(id)) {
				model.addAttribute("message", "xóa đơn hàng " + id + " thành công!");
				model.addAttribute("danhSachPhieuNhap", ioService.getAll());
			} else
				model.addAttribute("message", "Xóa đơn hàng " + id + " không thành công!");
		}
		return "admin/orders/index";
	}
	//===============================phieu-nhap==============================
	@RequestMapping(value="them-phieu-nhap", method=RequestMethod.GET)
	public String insertPhieuNhapGET() {
		return "admin/orders/createIO";
	}
	
}