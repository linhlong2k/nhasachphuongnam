package com.nhasachphuongnam.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GioHangModelAttribute {

	/* public List<GioHang> gioHang = new ArrayList<GioHang>(); */

	@ModelAttribute("gioHang")
	public List<GioHang> abc(@CookieValue(value = "gioHang", required = false) String gioHangString) {
		if(gioHangString == null) {
			return new ArrayList<GioHang>();
		}
		return this.string2GioHang(gioHangString);
	}

	public List<GioHang> string2GioHang(String var) {
		List<GioHang> gioHang = new ArrayList<GioHang>();
		String[] temp = var.split("/");
		String[] temp2;
		for (String i : temp) {
			temp2 = i.split(":");
			GioHang temp3 = new GioHang(temp2[0], Integer.valueOf(temp2[1]));
			gioHang.add(temp3);
		}
		return gioHang;
	}
	
	public String gioHang2String(List<GioHang> var) {
		StringBuilder res = new StringBuilder();
		for(GioHang i: var) {
			res.append(i.getMaMatHang());
			res.append(":");
			res.append(String.valueOf(i.getSoLuong()));
			res.append("/");
		}
		String res2 = res.substring(0, res.length()-1);
		return res2;
	}

	public List<GioHang> addGioHang(List<GioHang> var1 ,GioHang var2) {
		for(GioHang i: var1) {
			if(i.getMaMatHang().equals(var2.getMaMatHang())) {
				i.setSoLuong(i.getSoLuong()+1);
				return var1;
			}
		}
		var1.add(var2);
		return var1;
	}
	
	public List<GioHang> updateGioHang(List<GioHang> var1 ,GioHang var2){
		for(GioHang i: var1) {
			if(i.getMaMatHang().equals(var2.getMaMatHang())) {
				i.setSoLuong(var2.getSoLuong());
				return var1;
			}
		}
		return null;
	}

	public List<GioHang> removeGioHang(List<GioHang> var1 ,GioHang var2) {
		if (var1.remove(var2)) {
			return var1;
		}
		return null;
	}
	
	public List<GioHang> removeGioHang(List<GioHang> var1 ,String var2) {
		for(GioHang i: var1) {
			if(i.getMaMatHang().equals(var2)) {
				var1.remove(i);
				return var1;
			}
		}
		return null;
	}

	public List<GioHang> removeGioHang(List<GioHang> var1 ,int index) {
		if(index > var1.size()-1){
			return null;
		}
		var1.remove(index);
		return var1;
	}
	
	

	/*
	 * @ModelAttribute("gioHang") public List<ProductDetail> gioHang(ProductDetail
	 * var){ for(ProductDetail i: this.gioHang) {
	 * if(var.getMaMatHang().equals(i.getMaMatHang())) { i.setSoLuong(i.getSoLuong()
	 * + 1); return this.gioHang; } } this.gioHang.add(var); return this.gioHang; }
	 */
}
