package com.nhasachphuongnam.controller.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.bean.GioHang;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.ProductService;

@Controller
@RequestMapping("thanh-toan")
public class PaymentUserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ExportOrderService eoService;
	
	@ModelAttribute("danhSachSanPham")
	public List<Product> danhSachSanPham(ModelMap model,
			@ModelAttribute("gioHang") List<GioHang> gioHangs) {
		long tongTien = 0;
		List<Product> res = new ArrayList<Product>();
		Product temp;
		if(gioHangs == null) {
			System.out.println("gio hang null");
			return null;
		}
		for(GioHang i: gioHangs) {
			temp  = productService.getByID(i.getMaMatHang());
			temp.setSoLuong(i.getSoLuong());
			tongTien += temp.getGia() * (1- temp.getGiamGia()) * temp.getSoLuong();
			res.add(temp);
		}
		model.addAttribute("tongTien", tongTien);
		return res;
	}

	@GetMapping(value="")
	public String index() {
		return "user/payment";
	}
	
	//chương trình chưa có check null
	@PostMapping(value="")
	public String payment(ModelMap model,
			HttpServletResponse response,
			@RequestParam("soDienThoai") String soDienThoai,
			@RequestParam("diaChi") String diaChi,
			@ModelAttribute("user") PersonalInfo khachHang,
			@ModelAttribute("gioHang") List<GioHang> gioHangs) {
		ExportOrder res = new ExportOrder();
		res.setDiaChi(diaChi);
		res.setGiamGia(Float.valueOf(0));
		res.setMaKhachHang(khachHang.getMa());
		res.setSdt(soDienThoai);
		res.setThoiGian(LocalDate.now());
		res.setTinhTrang("1");
		List<ProductDetail> temp = new ArrayList<ProductDetail>();
		ProductDetail temp2;
		for(GioHang i: gioHangs) {
			temp2 = new ProductDetail();
			temp2.setMaMatHang(i.getMaMatHang());
			temp2.setSoLuong(i.getSoLuong());
			Product temp3 = productService.getByID(i.getMaMatHang());
			if(temp3 == null) {
				model.addAttribute("message", "Không tìm thấy mặt hàng " + i.getMaMatHang() + "!");
				return "user/payment";
			} else if(temp3.getSoLuong() < i.getSoLuong()) {
				model.addAttribute("message", "Thanh toán không thành công, mặt hàng " + temp3.getTenMatHang() + " có số lượng quá nhiều!");
				return "user/payment";
			}
			temp2.setGia((long)(temp3.getGia() * (1 - temp3.getGiamGia())));
			temp.add(temp2);
		}
		res.setChiTiets(temp);
		String id = eoService.add(res);
		if(id == null) {
			model.addAttribute("message", "Thanh toán không thành công!");
			return "user/payment";
		}
		Cookie cookie = new Cookie("gioHang", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:thanh-toan/thanh-toan-thanh-cong/" + id + ".htm";
	}
}
