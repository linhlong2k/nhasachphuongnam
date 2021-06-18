package com.nhasachphuongnam.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Supplier {
	private String maNhaCungCap;
	@NotEmpty(message = "Tên nhà cung cấp không được để trống")
	@NotNull(message = "Tên nhà cung cấp không được để trống")
	@Size(max = 50, message = "Tên nhà cung cấp quá dài")
	private String tenNhaCungCap;
	@NotEmpty(message = "Địa chỉ không được để trống")
	@NotNull(message = "Địa chỉ không được để trống")
	private String diaChi;
	private String soDienThoai;

	public Supplier() {
		super();
	}

	public Supplier(String tenNhaCungCap, String diaChi, String soDienThoai) {
		super();
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public Supplier(String maNhaCungCap, String tenNhaCungCap, String diaChi, String soDienThoai) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
