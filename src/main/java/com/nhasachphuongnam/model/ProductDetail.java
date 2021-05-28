package com.nhasachphuongnam.model;

public class ProductDetail {
	private String maMatHang;
	private int soLuong;
	private long gia;
	private float giamGia;

	public ProductDetail() {
		super();
	}

	public ProductDetail(String maMatHang, int soLuong, long gia, float giamGia) {
		super();
		this.maMatHang = maMatHang;
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

}
