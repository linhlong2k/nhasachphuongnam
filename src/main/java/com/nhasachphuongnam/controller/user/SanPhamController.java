package com.nhasachphuongnam.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.bean.GioHang;
import com.nhasachphuongnam.bean.GioHangModelAttribute;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductType;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.ProductTypeService;
import com.nhasachphuongnam.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
	
	@Autowired
	GioHangModelAttribute gioHangService;
	
	@Autowired
	ProductService productService = new ProductServiceImpl();
	
	@Autowired
	ProductTypeService 	productTypeService;

	@ModelAttribute("danhSachSanPham")
	public List<Product> danhSachMatHang(){
		return productService.getAll();
	}
	
	//chưa xử lý loại sản phẩm "null";
	@ModelAttribute("danhSachLoaiSanPham")
	public List<ProductType> danhSachLoaiSanPham(){
		return productTypeService.getAll();
	}
	
	//chưa xử lý trong jsp và controller, chưa viết comparator, giới hạn 10 sản phẩm cho cái này
	@ModelAttribute("danhSachSanPhamGanDay")
	public List<Product> danhSachSanPhamGanDay(){
		return new ArrayList<Product>();
	}
	
	@RequestMapping(value="")
	public String index(ModelMap model,
			@RequestParam(value="product-type", required = false) String maProductType) {
		if(maProductType != null) {
			model.addAttribute("danhSachSanPham", productService.getProductListByType(maProductType));
		}
		return "user/product";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String addToCart(ModelMap model,
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("gioHang") List<GioHang> gioHangs,
			@RequestParam("id") String maMatHang) {
		GioHang temp = new GioHang();
		temp.setMaMatHang(maMatHang);
		temp.setSoLuong(1);
		/* List<GioHang> gioHangs = (List<GioHang>) request.getAttribute("gioHang"); */
		if(gioHangs.isEmpty() || gioHangs == null) {
			gioHangs = new ArrayList<GioHang>();
			gioHangs = gioHangService.addGioHang(gioHangs, temp);
		}
		else {
			gioHangs = gioHangService.addGioHang(gioHangs, temp);
		}
		model.addAttribute("gioHang", gioHangs);
		Cookie gioHangCookie = new Cookie("gioHang", String.valueOf(gioHangService.gioHang2String(gioHangs)));
		gioHangCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(gioHangCookie);
		return "user/product";
	}
}
