package com.nhasachphuongnam.bean;

public class ProductDetail {
	private String maMatHang;
	private String soLuong;
	private long gia;

	public ProductDetail() {
		super();
	}

	public ProductDetail(String soLuong, long gia) {
		super();
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public ProductDetail(String maMatHang, String soLuong, long gia) {
		super();
		this.maMatHang = maMatHang;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMatHang = maMatHang;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

}
