package com.nhasachphuongnam.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductType {
	private String maLoai;
	@NotNull(message = "Tên loại mặt hàng không được để trống")
	@NotEmpty(message = "Tên loại mặt hàng không được để trống")
	@Size(max = 50, message = "Tên loại mặt hàng quá dài")
	private String tenLoai;

	public ProductType() {
		super();
	}

	public ProductType(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

}
