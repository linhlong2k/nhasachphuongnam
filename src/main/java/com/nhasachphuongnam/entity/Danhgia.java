package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DANHGIA database table.
 * 
 */
@Entity
@Table(name="DANHGIA")
public class Danhgia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MADG")
	private String madg;

	@Column(name="DANHGIA")
	private int danhgia;

	@Column(name="NOIDUNG")
	private String noidung;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne
	@JoinColumn(name="MAKH")
	private Khachhang khachhang;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH")
	private Mathang mathang;

	public Danhgia() {
	}

	public String getMadg() {
		return this.madg;
	}

	public void setMadg(String madg) {
		this.madg = madg;
	}

	public int getDanhgia() {
		return this.danhgia;
	}

	public void setDanhgia(int danhgia) {
		this.danhgia = danhgia;
	}

	public String getNoidung() {
		return this.noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Mathang getMathang() {
		return this.mathang;
	}

	public void setMathang(Mathang mathang) {
		this.mathang = mathang;
	}

}