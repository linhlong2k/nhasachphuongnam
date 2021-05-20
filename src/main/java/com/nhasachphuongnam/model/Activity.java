package com.nhasachphuongnam.model;

public class Activity {
	private String maHoatDong;
	private String maNhanVien;
	private String thoiGian;
	private String ghiChu;

	public Activity() {
		super();
	}

	public Activity(String maNhanVien, String thoiGian, String ghiChu) {
		super();
		this.maNhanVien = maNhanVien;
		this.thoiGian = thoiGian;
		this.ghiChu = ghiChu;
	}

	public Activity(String maHoatDong, String maNhanVien, String thoiGian, String ghiChu) {
		super();
		this.maHoatDong = maHoatDong;
		this.maNhanVien = maNhanVien;
		this.thoiGian = thoiGian;
		this.ghiChu = ghiChu;
	}

	public String getMaHoatDong() {
		return maHoatDong;
	}

	public void setMaHoatDong(String maHoatDong) {
		this.maHoatDong = maHoatDong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
