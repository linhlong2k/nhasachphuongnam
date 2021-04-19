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
public class Khachhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAKH")
	private String makh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENKH")
	private String tenkh;

	//bi-directional many-to-one association to Danhgia
	@OneToMany(mappedBy="khachhang")
	private List<Danhgia> danhgias;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="khachhang")
	private List<Hoadon> hoadons;

	public Khachhang() {
	}

	public String getMakh() {
		return this.makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTenkh() {
		return this.tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public List<Danhgia> getDanhgias() {
		return this.danhgias;
	}

	public void setDanhgias(List<Danhgia> danhgias) {
		this.danhgias = danhgias;
	}

	public Danhgia addDanhgia(Danhgia danhgia) {
		getDanhgias().add(danhgia);
		danhgia.setKhachhang(this);

		return danhgia;
	}

	public Danhgia removeDanhgia(Danhgia danhgia) {
		getDanhgias().remove(danhgia);
		danhgia.setKhachhang(null);

		return danhgia;
	}

	public List<Hoadon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<Hoadon> hoadons) {
		this.hoadons = hoadons;
	}

	public Hoadon addHoadon(Hoadon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setKhachhang(this);

		return hoadon;
	}

	public Hoadon removeHoadon(Hoadon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setKhachhang(null);

		return hoadon;
	}

}