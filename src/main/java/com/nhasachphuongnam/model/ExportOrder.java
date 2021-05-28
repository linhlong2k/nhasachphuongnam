package com.nhasachphuongnam.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ExportOrder {
	
	private String maDonHang;
	// định dạng lưu trữ: mã mặt hàng:tên mặt hàng:số lượng:giá tiền
	private List<ProductDetail> chiTiets;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date thoiGian;
	private PersonalInfo nhanVien;
	private PersonalInfo khachHang;
	private String diaChi;
	private String sdt;
	
	public ExportOrder() {
		super();
	}

	public ExportOrder(String maDonHang, List<ProductDetail> chiTiets, Date thoiGian, PersonalInfo nhanVien,
			PersonalInfo khachHang, String diaChi, String sdt) {
		super();
		this.maDonHang = maDonHang;
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public List<ProductDetail> getChiTiets() {
		return chiTiets;
	}

	public void setChiTiets(List<ProductDetail> chiTiets) {
		this.chiTiets = chiTiets;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public PersonalInfo getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(PersonalInfo nhanVien) {
		this.nhanVien = nhanVien;
	}

	public PersonalInfo getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(PersonalInfo khachHang) {
		this.khachHang = khachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	
	
	//==================advanced========
	/*
	 * public void setKhachHang(String ma) {
	 * 
	 * }
	 */

}