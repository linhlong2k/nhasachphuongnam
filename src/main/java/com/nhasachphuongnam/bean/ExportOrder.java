package com.nhasachphuongnam.bean;

public class ExportOrder extends Order{
	private String maKhachHang;

	public ExportOrder() {
		super();
	}

	public ExportOrder(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	};
	
}
