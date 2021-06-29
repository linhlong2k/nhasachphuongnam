package com.nhasachphuongnam.controller.user;

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
import com.nhasachphuongnam.bean.GioHangModelAttribute;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ProductService;

@Controller
@RequestMapping("gio-hang")
public class CartUserController {
	
	@Autowired
	GioHangModelAttribute gioHangService;
	
	@Autowired
	ProductService productService;
	
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
	public String index(ModelMap model) {
		return "user/cart";
	}
	
	@PostMapping(value="", params = "btnDelete")
	public String deleteProductFormCart(ModelMap model, HttpServletResponse response,
			@RequestParam(value="productId", required = false) String maMatHang,
			@ModelAttribute("gioHang") List<GioHang> gioHangs) {
		if(gioHangs.isEmpty() || gioHangs == null || maMatHang == null) {
			model.addAttribute("message", "Không tìm thấy mặt hàng trong giỏ hàng");
			gioHangs = new ArrayList<GioHang>();
		}
		else {
			gioHangs = gioHangService.removeGioHang(gioHangs, maMatHang);
			if(gioHangs == null) {
				model.addAttribute("message", "Không tìm thấy mặt hàng trong giỏ hàng");
				return "user/cart";
			}
		}
		model.addAttribute("gioHang", gioHangs);
		Cookie gioHangCookie = new Cookie("gioHang", String.valueOf(gioHangService.gioHang2String(gioHangs)));
		gioHangCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(gioHangCookie);
		model.addAttribute("danhSachSanPham", this.danhSachSanPham(model, gioHangs));
		return "user/cart";
	}
	
	@PostMapping(value="", params = "btnSave")
	public String saveProductFromCart(ModelMap model,
			@RequestParam(value="productId", required = false) String maMatHang,
			@RequestParam(value="soLuong", required = false) int soLuong,
			HttpServletResponse response,
			@ModelAttribute("gioHang") List<GioHang> gioHangs) {
		if(maMatHang == null) {
			model.addAttribute("message", "Không thể nhận dạng được mặt hàng");
			return "user/cart";
		}
		if(soLuong == 0) {
			model.addAttribute("message", "Số lượng bạn nhận không đúng");
			return "user/cart";
		}
		GioHang temp = new GioHang();
		temp.setMaMatHang(maMatHang);
		temp.setSoLuong(soLuong);
		/* List<GioHang> gioHangs = (List<GioHang>) request.getAttribute("gioHang"); */
		if(gioHangs.isEmpty() || gioHangs == null) {
			gioHangs = new ArrayList<GioHang>();
			gioHangs = gioHangService.addGioHang(gioHangs, temp);
		}
		else {
			gioHangs = gioHangService.updateGioHang(gioHangs, temp);
			if(gioHangs == null) {
				model.addAttribute("message", "Không tìm thấy mã mặt hàng trong giỏ hàng");
				return "user/cart";
			}
		}
		model.addAttribute("gioHang", gioHangs);
		Cookie gioHangCookie = new Cookie("gioHang", String.valueOf(gioHangService.gioHang2String(gioHangs)));
		gioHangCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(gioHangCookie);
		model.addAttribute("danhSachSanPham", this.danhSachSanPham(model, gioHangs));
		return "user/cart";
	}
	
}
