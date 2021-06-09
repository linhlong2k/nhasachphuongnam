package com.nhasachphuongnam.model;

import java.io.UnsupportedEncodingException;

public class Product {
	private String maMatHang;
	private String tenMatHang;
	private byte[] hinhAnh;
	private int soLuong;
	private String moTaNgan;
	private String moTa;
	private boolean daXoa;
	private long gia;
	private Float giamGia;
	private String maLoai;

	public Product() {
		super();
	}

	public Product(String tenMatHang, byte[] hinhAnh, int soLuong, String moTaNgan, String moTa, boolean daXoa,
			long gia, Float giamGia, String maLoai) {
		super();
		this.tenMatHang = tenMatHang;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		this.moTaNgan = moTaNgan;
		this.moTa = moTa;
		this.daXoa = daXoa;
		this.gia = gia;
		this.giamGia = giamGia;
		this.maLoai = maLoai;
	}

	public Product(String maMatHang, String tenMatHang, byte[] hinhAnh, int soLuong, String moTaNgan, String moTa,
			boolean daXoa, long gia, Float giamGia, String maLoai) {
		super();
		this.maMatHang = maMatHang;
		this.tenMatHang = tenMatHang;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		this.moTaNgan = moTaNgan;
		this.moTa = moTa;
		this.daXoa = daXoa;
		this.gia = gia;
		this.giamGia = giamGia;
		this.maLoai = maLoai;
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

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
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

	public boolean isDaXoa() {
		return daXoa;
	}

	public void setDaXoa(boolean daXoa) {
		this.daXoa = daXoa;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public Float getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(Float giamGia) {
		this.giamGia = giamGia;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	
	/* =============================advanced=========================== */

	public String getBase64Photo() {
		String base64DataString = null;
		if (hinhAnh != null) {
			byte[] encode = java.util.Base64.getEncoder().encode(this.getHinhAnh());
			try {
				base64DataString = new String(encode, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return base64DataString;
	}
}