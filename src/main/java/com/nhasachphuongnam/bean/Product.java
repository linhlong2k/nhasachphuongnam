package com.nhasachphuongnam.bean;

public class Product {
	private String maMH;
	private String tenMH;
	private int soLuong;
	private String moTaNgan;
	private String moTa;
	private String hinhAnh;
	private String maLoai;

	public Product() {
		super();
	}
	
	public Product(String tenMH, int soLuong, String moTaNgan, String moTa, String hinhAnh, String maLoai) {
		super();
		this.tenMH = tenMH;
		this.soLuong = soLuong;
		this.moTaNgan = moTaNgan;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.maLoai = maLoai;
	}

	public Product(String maMH, String tenMH, int soLuong, String moTaNgan, String moTa, String hinhAnh,
			String maLoai) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soLuong = soLuong;
		this.moTaNgan = moTaNgan;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.maLoai = maLoai;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMoTaNgan() {
		return moTaNgan;
	}

	public void setMoTaNgan(String moTaNgan) {
		this.moTaNgan = moTaNgan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
}