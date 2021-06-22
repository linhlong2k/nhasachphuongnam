package com.nhasachphuongnam.model;

public class ProductDetail {
	private String maMatHang;
	private String tenMatHang;
	private int soLuong;
	private long gia;
	private float giamGia;

	public ProductDetail() {
		super();
	}

	public ProductDetail(String maMatHang, String tenMatHang, int soLuong, long gia, float giamGia) {
		super();
		this.maMatHang = maMatHang;
		this.tenMatHang = tenMatHang;
		this.soLuong = soLuong;
		this.gia = gia;
		this.giamGia = giamGia;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMatHang = maMatHang;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public float getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}

	// ==================================advanced=======================================

}
