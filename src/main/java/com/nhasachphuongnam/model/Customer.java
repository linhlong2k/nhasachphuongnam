package com.nhasachphuongnam.model;

import java.io.UnsupportedEncodingException;

public class Customer {
	private String maKhachHang;
	private String tenKhachHang;
	private byte[] hinhAnh;
	private String soDienThoai;
	private String username;

	public Customer() {
		super();
	}

	public Customer(String tenKhachHang, byte[] hinhAnh, String soDienThoai, String username) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.hinhAnh = hinhAnh;
		this.soDienThoai = soDienThoai;
		this.username = username;
	}

	public Customer(String maKhachHang, String tenKhachHang, byte[] hinhAnh, String soDienThoai, String username) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.hinhAnh = hinhAnh;
		this.soDienThoai = soDienThoai;
		this.username = username;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/* =============================advanced=========================== */
	
	public String getBase64Photo() {
		String base64DataString = null;
		if (hinhAnh != null) {                
			byte[] encode = java.util.Base64.getEncoder().encode(this.getHinhAnh());
            try {
				base64DataString =  new String(encode, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return base64DataString;
	}
	
}
