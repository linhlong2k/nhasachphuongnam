package com.nhasachphuongnam.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String maDH;
	// định dạng lưu trữ: mã mặt hàng:tên mặt hàng:số lượng:giá tiền
	private List<String> chiTiet;
	private Date thoiGian;
	private String maNhanVien;

	public Order() {
		super();
	}

	public Order(String maDH, List<String> chiTiet, Date thoiGian, String maNhanVien) {
		super();
		this.maDH = maDH;
		this.chiTiet = chiTiet;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public List<String> getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(List<String> chiTiet) {
		this.chiTiet = chiTiet;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	/*------------------------------------------------advanced-----------------------------------------------------------------*/
	public List<String> getChiTiet(String chitiet){
		List<String> res = new ArrayList();
		String[] temp = chitiet.split(":");
		for(String i: temp){
			res.add(i);
		
		}
		return res;
	}
	public List<String> dsMatHang(){
		List<String> res = new ArrayList();
		for(String i: chiTiet) {
			res.add(i.split(":")[0]);
		}
		return res;
	}
	

}
