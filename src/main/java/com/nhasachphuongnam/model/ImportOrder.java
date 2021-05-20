package com.nhasachphuongnam.model;

public class ImportOrder extends Order {
	private String maNhaCungCap;

	public ImportOrder() {
		super();
	}

	public ImportOrder(String maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

}
