package com.nhasachphuongnam.controller.admin;

import java.time.LocalDate;
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
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.SupplierService;

@Controller
@RequestMapping("admin/tao-don-hang-xuat")
public class ExportOrderCreateController {
	private List<ProductDetail> selecteds = new ArrayList<ProductDetail>();
	
	@Autowired
	ExportOrderService eoService;
	
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	ProductService productService;
	
	//===============modelAttribute=================================
	
	@ModelAttribute("danhSachMatHang")	//danh sách mặt hàng
	public List<Product> danhSachMatHang(){
		List<Product> matHangs = productService.getAll();
		return matHangs;
	}

	@ModelAttribute("danhSachMatHangDaChon")
	public List<ProductDetail> danhSachMatHangDaChon(){
		return this.selecteds;
	}
	
	public void reloadModel(ModelMap model) {
		//model.addAttribute("danhSachNhaCungCap", this.danhSachNhaCungCap()); //không cần reload
		model.addAttribute("danhSachMatHang", this.danhSachMatHang());
		model.addAttribute("danhSachMatHangDaChon", this.danhSachMatHangDaChon());
	}
	
	//====================Controller==========================
	
	@GetMapping(value="")
	public String index(ModelMap model) {
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="addProductId")
	public String addProduct(ModelMap model,
			@RequestParam(value="addProductId", required=false) String id,
			@RequestParam(value="soLuong", required = false) int soLuong) {
		if(soLuong==0) {
			model.addAttribute("message", "Chọn mặt hàng mới không thành công! Vui lòng nhập số lượng mặt hàng");
			return "admin/orders/createEO";
		}
		if(id == null) {
			model.addAttribute("message", "Mã mặt hàng không nhận được");
			return "admin/orders/createEO";
		}
		for(ProductDetail i: this.selecteds) {
			if(i.getMaMatHang().equals(id)) {
				i.setSoLuong(i.getSoLuong() + soLuong);
				this.reloadModel(model);
				/* model.addAttribute("matHangChon", new ProductDetail()); */
				return "admin/orders/createEO";
			}
		}
		ProductDetail productDetail = new ProductDetail();
		Product temp = productService.getByID(id);
		productDetail.setMaMatHang(id);
		productDetail.setSoLuong(soLuong);
		productDetail.setGia((long)(temp.getGia() * temp.getGiamGia()));
		this.selecteds.add(productDetail);
		this.reloadModel(model);
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="removeProductId")
	public String removeProduct(ModelMap model,
			@RequestParam(value="removeProductId") String id) {
		for(ProductDetail i: this.selecteds) {
			if(i.getMaMatHang().equals(id)) {
				this.selecteds.remove(i);
				break;
			}
		}
		model.addAttribute("danhSachMatHangDaChon", this.selecteds);
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="reset")
	public String removeAllProduct(ModelMap model) {
		this.selecteds.clear();
		this.reloadModel(model);
		return "admin/orders/createEO";
	}
	
	@PostMapping(value="", params="save")
	public String createExportOrder(ModelMap model,
			@RequestParam(value="giamGia", required=false) Float giamGia,
			@ModelAttribute("user") PersonalInfo nhanVien,
			BindingResult errors) {
		if(nhanVien == null) {
			model.addAttribute("message", "Chương trình không tìm thấy nhân viên đang đăng nhập!!!");
			return "admin/orders/createEO";
		}
		if(giamGia == null) {
			model.addAttribute("message", "Lưu đơn hàng xuất không thành công! Vui lòng nhập giảm giá!");
			return "admin/orders/createEO";
		}
		ExportOrder newExportOrder = new ExportOrder();
		newExportOrder.setChiTiets(this.selecteds);
		newExportOrder.setMaNhanVien(nhanVien.getMa());
		newExportOrder.setGiamGia(giamGia);
		newExportOrder.setMaKhachHang(null);
		newExportOrder.setThoiGian(LocalDate.now());
		newExportOrder.setTinhTrang("3");
		newExportOrder.setDiaChi("97 Man Thiện, p.Hiệp Phú, tp.Thủ Đức");
		newExportOrder.setSdt("0123456789");
		String maDonHang = eoService.add(newExportOrder);
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
