package com.nhasachphuongnam.bean;

public class GioHang {
	private String maMatHang;
	private int soLuong;

	public GioHang() {
		super();
	}

	public GioHang(String maMathang, int soLuong) {
		super();
		this.maMatHang = maMathang;
		this.soLuong = soLuong;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(String maMathang) {
		this.maMatHang = maMathang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	
}
