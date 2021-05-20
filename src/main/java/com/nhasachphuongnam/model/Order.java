package com.nhasachphuongnam.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nhasachphuongnam.bean.ProductDetail;

public class Order {
	private String maDonHang;
	// định dạng lưu trữ: mã mặt hàng:tên mặt hàng:số lượng:giá tiền
	private List<ProductDetail> chiTiets;
	private Date thoiGian;
	private String maNhanVien;

	public Order() {
		super();
	}

	public Order(List<ProductDetail> chiTiets, Date thoiGian, String maNhanVien) {
		super();
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
	}

	public Order(String maDonHang, List<ProductDetail> chiTiets, Date thoiGian, String maNhanVien) {
		super();
		this.maDonHang = maDonHang;
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
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

	public void setChiTiet(List<ProductDetail> chiTiets) {
		this.chiTiets = chiTiets;
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

	/*
	 * =====================================advanced================================
	 */


}
