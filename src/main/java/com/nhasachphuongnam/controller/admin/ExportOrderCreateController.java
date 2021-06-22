package com.nhasachphuongnam.controller.admin;

import java.util.ArrayList;
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

import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.model.Supplier;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.SupplierService;

@Controller
@RequestMapping("admin/tao-don-hang-xuat")
public class ExportOrderCreateController {
	private List<ProductDetail> selecteds = new ArrayList<ProductDetail>();
	private ExportOrder newExportOrder = new ExportOrder();
	
	/*
	 * public void resetModelAttribute(ModelMap model) {
	 * model.addAttribute("donHangNhapMoi", new ExportOrder());
	 * this.selecteds.clear(); model.addAttribute("danhSachMatHangDaChon",
	 * this.selecteds); model.addAttribute("matHangChon", new ProductDetail()); }
	 */
	
	@Autowired
	ExportOrderService eoService;
	
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	ProductService productService;
	
	//===============modelAttribute=================================
	
	@ModelAttribute("danhSachNhaCungCap")	//danh sách nhà cung cấp
	public List<Supplier> danhSachNhaCungCap() {
		List<Supplier> res = supplierService.getAll();
		return res;
	}
	
	@ModelAttribute("danhSachMatHang")	//danh sách mặt hàng
	public List<Product> danhSachMatHang(){
		List<Product> matHangs = productService.getAll();
		return matHangs;
	}
	
	@ModelAttribute("donHangNhapMoi")	//đơn hàng nhập mới
	public ExportOrder donHangNhapMoi() {
		return this.newExportOrder;
	}


	@ModelAttribute("danhSachMatHangDaChon")
	public List<ProductDetail> danhSachMatHangDaChon(){
		return this.selecteds;
	}
	
	@ModelAttribute("matHangChon")
	public ProductDetail matHangChon() {
		return new ProductDetail();
	}
	
	public void reloadModel(ModelMap model) {
		//model.addAttribute("danhSachNhaCungCap", this.danhSachNhaCungCap()); //không cần reload
		model.addAttribute("danhSachMatHang", this.danhSachMatHang());
		model.addAttribute("donHangNhapMoi", this.donHangNhapMoi());
		model.addAttribute("danhSachMatHangDaChon", this.danhSachMatHangDaChon());
		model.addAttribute("matHangChon", this.matHangChon());
	}
	
	//====================Controller==========================
	
	@GetMapping(value="")
	public String index(ModelMap model) {
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="linkPinDonHang")		//ghim thông tin đơn hàng để modelAttribute donHangNhapMoi không bị reload
	public String pinThongTin(ModelMap model,
			@ModelAttribute("donHangNhapMoi") ExportOrder ExportOrder) {
		if(ExportOrder.getThoiGian() == null) {
			model.addAttribute("message", "Thông tin đơn hàng nhập mới không đủ\nVui lòng nhập thời gian");
		} else {
			this.newExportOrder = ExportOrder;
		}
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="linkAddProduct")
	public String themMatHang(ModelMap model,
			@ModelAttribute("matHangChon") ProductDetail prodDetail) {
		boolean flag = true;
		for(ProductDetail i: this.selecteds) {
			if(i.getMaMatHang().equals(prodDetail.getMaMatHang())) {
				i.setSoLuong(i.getSoLuong() + prodDetail.getSoLuong());
				i.setGiamGia(i.getGiamGia());
				flag = false;
				break;
			}
		}
		if(flag) {
			selecteds.add(prodDetail);
		}
		this.reloadModel(model);
		/* model.addAttribute("matHangChon", new ProductDetail()); */
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="linkDeleteProductId")
	public String xoaMatHang(ModelMap model,
			@RequestParam(value="linkDeleteProductId") String id) {
		for(ProductDetail i: this.selecteds) {
			if(i.getMaMatHang().equals(id)) {
				this.selecteds.remove(i);
				break;
			}
		}
		model.addAttribute("danhSachMatHangDaChon", this.selecteds);
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="linkReset")
	public String resetMatHang(ModelMap model) {
		this.selecteds.clear();
		this.reloadModel(model);
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="linkSave")
	public String saveDonHangNhap(ModelMap model,
			@ModelAttribute("donHangNhapMoi") ExportOrder ExportOrder,
			@ModelAttribute("user") PersonalInfo nhanVien,
			BindingResult errors) {
		if(ExportOrder == null || ExportOrder.getThoiGian() == null) {
			model.addAttribute("message", "Thêm đơn hàng nhập không thành công! Vui lòng chọn thời gian");
			return "admin/orders/createEO";
		}
		ExportOrder.setChiTiets(this.selecteds);
		ExportOrder.setMaNhanVien(nhanVien.getMa());
		String maDonHang = eoService.add(ExportOrder);
		if(maDonHang != null) {
			model.addAttribute("message", "Thêm đơn hàng nhập thành công! Đơn hàng nhập vừa thêm có mã đơn hàng là " + maDonHang);
		} else {
			model.addAttribute("message", "Thêm đơn hàng nhập không thành công!");
		}
		
		this.selecteds.clear();
		this.reloadModel(model);
		return "admin/orders/createEO";
	}
}
