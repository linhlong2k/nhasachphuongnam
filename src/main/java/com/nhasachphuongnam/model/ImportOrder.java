package com.nhasachphuongnam.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ImportOrder {
	private String maDonHang;
	private List<ProductDetail> chiTiets;
	/*
	 * @NotEmpty(message = "Thời gian không được để trống")
	 * 
	 * @NotNull(message = "Thời gian không được để trống")
	 */
	//không thể dúng được annonitation @pastorpresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate thoiGian;
	private String maNhanVien;
	private String maNhaCungCap;

	public ImportOrder() {
		super();
	}

	public ImportOrder(List<ProductDetail> chiTiets, LocalDate thoiGian, String maNhanVien, String maNhaCungCap) {
		super();
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
		this.maNhaCungCap = maNhaCungCap;
	}

	public ImportOrder(String maDonHang, List<ProductDetail> chiTiets, LocalDate thoiGian, String maNhanVien,
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

	public LocalDate getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(LocalDate thoiGian) {
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
