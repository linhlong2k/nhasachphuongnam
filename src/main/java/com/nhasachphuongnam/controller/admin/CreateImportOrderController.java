package com.nhasachphuongnam.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.model.Supplier;
import com.nhasachphuongnam.service.ImportOrderService;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.SupplierService;

@Controller
@RequestMapping("admin/tao-don-hang-nhap")
public class CreateImportOrderController {
	
	private List<ProductDetail> selecteds = new ArrayList<ProductDetail>();
	private ImportOrder newImportOrder = new ImportOrder();
	
	/*
	 * public void resetModelAttribute(ModelMap model) {
	 * model.addAttribute("donHangNhapMoi", new ImportOrder());
	 * this.selecteds.clear(); model.addAttribute("danhSachMatHangDaChon",
	 * this.selecteds); model.addAttribute("matHangChon", new ProductDetail()); }
	 */
	
	@Autowired
	ImportOrderService ioService;
	
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
	public ImportOrder donHangNhapMoi() {
		System.out.println("đơn hàng nhập mới!" + this.newImportOrder.getMaNhaCungCap());;
		return this.newImportOrder;
	}


	@ModelAttribute("danhSachMatHangDaChon")
	public List<ProductDetail> danhSachMatHangDaChon(){
		return this.selecteds;
	}
	
	@ModelAttribute("matHangChon")
	public ProductDetail matHangChon() {
		return new ProductDetail();
	}
	
	//====================Controller==========================
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		this.selecteds = new ArrayList<ProductDetail>();
		return "admin/orders/createIO";
	}
	
	@RequestMapping(value="thong-tin-don-hang-nhap", method=RequestMethod.POST)
	public String themThongTin(ModelMap model,
			@ModelAttribute("donHangNhapMoi") ImportOrder importOrder) {
		if(importOrder.getThoiGian() == null) {
			model.addAttribute("message", "Thông tin đơn hàng nhập mới không đủ\nVui lòng nhập thời gian");
		} else {
			this.newImportOrder = importOrder;
		}
		return "admin/orders/createIO";
	}
	
	@RequestMapping(value="them-mat-hang", method=RequestMethod.POST)
	public String themMatHang(ModelMap model,
			@ModelAttribute("matHangChon") ProductDetail proddetail) {
		boolean flag = true;
		for(ProductDetail i: this.selecteds) {
			if(i.getMaMatHang().equals(proddetail.getMaMatHang())) {
				i.setSoLuong(i.getSoLuong() + proddetail.getSoLuong());
				flag = false;
				break;
			}
		}
		if(flag) {
			selecteds.add(proddetail);
		}
		model.addAttribute("danhSachMatHangDaChon", this.selecteds);
		/* model.addAttribute("matHangChon", new ProductDetail()); */
		return "admin/orders/createIO";
	}
	
	@RequestMapping(value="xoa-mat-hang/{id}", method=RequestMethod.POST)
	public String xoaMatHang(ModelMap model,
			@PathVariable("id") String id) {
		for(ProductDetail i: this.selecteds) {
			if(i.getMaMatHang().equals(id)) {
				this.selecteds.remove(i);
				break;
			}
		}
		model.addAttribute("danhSachMatHangDaChon", this.selecteds);
		return "admin/orders/createIO";
	}
	
	@RequestMapping(value="reset", method=RequestMethod.POST)
	public String resetMatHang(ModelMap model) {
		this.selecteds.clear();
		model.addAttribute("danhSachMatHangDaChon", this.selecteds);
		return "admin/orders/createIO";
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String saveDonHangNhap(ModelMap model,
			@ModelAttribute("donHangNhapMoi") ImportOrder importOrder) {
		importOrder.setChiTiets(this.selecteds);
		System.out.println(importOrder.getMaNhaCungCap());
		if(ioService.add(importOrder)) {
			model.addAttribute("message", "Thêm đơn hàng nhập thành công!");
		} else {
			model.addAttribute("message", "Thêm đơn hàng nhập không thành công!");
		}
			
		return "admin/orders/createIO";
	}
}
