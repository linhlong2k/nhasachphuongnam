package com.nhasachphuongnam.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ImportOrder {
	private String maDonHang;
	// định dạng lưu trữ: mã mặt hàng:tên mặt hàng:số lượng:giá tiền
	private List<ProductDetail> chiTiets;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thoiGian;
	private String maNhanVien;
	private String maNhaCungCap;

	public ImportOrder() {
		super();
	}

	public ImportOrder(List<ProductDetail> chiTiets, Date thoiGian, String maNhanVien, String maNhaCungCap) {
		super();
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
		this.maNhaCungCap = maNhaCungCap;
	}

	public ImportOrder(String maDonHang, List<ProductDetail> chiTiets, Date thoiGian, String maNhanVien,
			String maNhaCungCap) {
		super();
		this.maDonHang = maDonHang;
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
		this.maNhaCungCap = maNhaCungCap;
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

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

}
