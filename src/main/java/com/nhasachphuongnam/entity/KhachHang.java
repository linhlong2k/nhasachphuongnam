package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the KHACHHANG database table.
 * 
 */
@Entity
@Table(name="KHACHHANG")
public class KhachHang  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAKH")
	private String maKH;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENKH")
	private String tenKH;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="khachhang")
	private List<HoaDon> hoadons;

	public KhachHang() {
	}

	public String getMaKH() {
		return this.maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTenKH() {
		return this.tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public List<HoaDon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<HoaDon> hoadons) {
		this.hoadons = hoadons;
	}

	public HoaDon addHoadon(HoaDon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setKhachhang(this);

		return hoadon;
	}

	public HoaDon removeHoadon(HoaDon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setKhachhang(null);

		return hoadon;
	}

}