package com.nhasachphuongnam.model;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Staff {
	private String maNhanVien;
	private String tenNhanVien;
	private byte[] hinhAnh;
	private String diaChi;
	private Date ngaySinh;
	private String soDienThoai;
	private String username;

	public Staff() {
		super();
	}

	public Staff(String tenNhanVien, byte[] hinhAnh, String diaChi, Date ngaySinh, String soDienThoai,
			String username) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.hinhAnh = hinhAnh;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.username = username;
	}

	public Staff(String maNhanVien, String tenNhanVien, byte[] hinhAnh, String diaChi, Date ngaySinh,
			String soDienThoai, String username) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.hinhAnh = hinhAnh;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.username = username;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
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
