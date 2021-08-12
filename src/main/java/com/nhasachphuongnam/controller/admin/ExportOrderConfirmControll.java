package com.nhasachphuongnam.controller.admin;

import java.util.ArrayList;
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
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.ProductService;

@Controller
@RequestMapping("admin/xac-nhan-dat-hang")
class ExportOrderConfirmControll {
	
	@Autowired
	ExportOrderService eoService;
	
	@Autowired
	ProductService productService;
	
	@ModelAttribute("danhSachDonHang")		//danh sách đơn hàng đặt chưa được xác nhận
	public List<ExportOrder> danhSachDonHang() {
		List<ExportOrder> res = eoService.getDanhSachUserOrder();
		return res;
	}
	
	@ModelAttribute("donHang")
	public ExportOrder donHang() {
		return new ExportOrder();
	}
	
	@ModelAttribute("danhSachMatHang")
	public List<Product> danhSachMatHang() {
		List<Product> res = new ArrayList<Product>();
		return res;
	}
	
	public void reloadModel(ModelMap model) { //cập nhập lại các model Attribute 
		model.addAttribute("danhSachDonHang", this.danhSachDonHang());
		model.addAttribute("donHang", this.donHang());
		model.addAttribute("danhSachMatHang", this.danhSachMatHang());
	}
	
	@GetMapping(value = "")
	public String index() {
		return "admin/orders/confirm";
	}
	
	@PostMapping(value="", params = "linkSelect")
	public String select(ModelMap model,
			@RequestParam("id") String id) {
		ExportOrder temp = eoService.getByID(id);
		model.addAttribute("donHang", temp);
		model.addAttribute("danhSachMatHang", eoService.getDanhSachMatHangByExportOrderID(temp.getMaDonHang()));
		return "admin/orders/confirm";
	}
	
	@PostMapping(value="", params="ok")
	public String ok(ModelMap model,
			@RequestParam(value="id", required = false) String id,
			@ModelAttribute("user") PersonalInfo nhanVien) {
		if(id.isEmpty()) {
			model.addAttribute("message", "Bạn chưa lựa chọn đơn hàng!");
		} else if(eoService.confirmUserOrder(id, nhanVien.getMa()) == null) {
			model.addAttribute("message", "Không thể chuyển đơn hàng sang trạng thái chuyển hàng!");
		} else {
			model.addAttribute("message", "Chuyển đơn hàng " + id + " sang trạng thái chuyển hàng!");
		}
		
		this.reloadModel(model);
		return "admin/orders/confirm";
	}
	
	@PostMapping(value="", params="cancel")
	public String cancel(ModelMap model,
			@RequestParam(value="id", required = false) String id) {
		if(!id.isEmpty()) {
			if(eoService.delete(id)) {
				model.addAttribute("message", "Xóa đơn hàng " + id + " thành công!");
			} else {
				model.addAttribute("message", "Xóa đơn hàng " + id + " không thành công!");
			}
		}
		
		this.reloadModel(model);
		return "admin/orders/confirm";
	}
}
