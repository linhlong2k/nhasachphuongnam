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
@RequestMapping("admin/xac-nhan-nhan-hang")
public class ExportOrderSuccessController {
	@Autowired
	ExportOrderService eoService;
	
	@ModelAttribute("danhSachDonHang")
	public List<ExportOrder> danhSachDonHang(){
		List<ExportOrder> res = eoService.getDanhSachUserDeliveryOrder();
		return res;
	}
	
	public void reloadModel(ModelMap model) {
		model.addAttribute("danhSachDonHang", this.danhSachDonHang());
	}
	
	@GetMapping(value="")
	public String index() {
		return "admin/orders/finish";
	}
	
	@PostMapping(value="", params="ok")
	public String ok(ModelMap model,
			@RequestParam(value="id") String id) {
		if(id.isEmpty()) {		//trường hợp này không xảy ra.
			model.addAttribute("message", "Không nhận được mã đơn hàng!");
		}else if(eoService.comfirmUserDeliveryOrder(id) == null) {
			model.addAttribute("message", "Xác nhận đơn hàng vận chuyển " + id + " không thành công");
		} else {
			model.addAttribute("message", "Xác nhận đơn hàng vận chuyển " + id + " thành công!");
		}
		
		this.reloadModel(model);
		return "admin/orders/finish";
	}
	
	@PostMapping(value="", params="cancel")
	public String cancel(ModelMap model,
			@RequestParam(value="id") String id) {
		if(eoService.delete(id)) {
			model.addAttribute("message", "Xóa đơn hàng " + id + " thành công!");
		} else {
			model.addAttribute("message", "Xóa đơn hàng " + id + " không thành công!");
		}
		
		this.reloadModel(model);
		return "admin/orders/finish";
	}
}
