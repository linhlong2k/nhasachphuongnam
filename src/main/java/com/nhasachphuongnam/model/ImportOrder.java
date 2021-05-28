package com.nhasachphuongnam.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ImportOrder {
	private String maDonHang;
	// định dạng lưu trữ: mã mặt hàng:tên mặt hàng:số lượng:giá tiền
	private List<ProductDetail> chiTiets;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date thoiGian;
	private PersonalInfo nhanVien;
	private Supplier nhaCungCap;

	public ImportOrder() {
		super();
	}

	public ImportOrder(List<ProductDetail> chiTiets, Date thoiGian, PersonalInfo nhanVien, Supplier nhaCungcap) {
		super();
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.nhanVien = nhanVien;
		this.nhaCungCap = nhaCungcap;
	}

	public ImportOrder(String maDonHang, List<ProductDetail> chiTiets, Date thoiGian, PersonalInfo nhanVien,
			Supplier nhaCungcap) {
		super();
		this.maDonHang = maDonHang;
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.nhanVien = nhanVien;
		this.nhaCungCap = nhaCungcap;
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

	public Supplier getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(Supplier nhaCungcap) {
		this.nhaCungCap = nhaCungcap;
	}

}
