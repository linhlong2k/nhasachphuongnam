package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the CT_HOADON database table.
 * 
 */
@Entity
@Table(name="CT_HOADON")
public class ctHoaDon implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ctHoaDonPK id;

	@Column(name="GIATIEN")
	private BigDecimal giatien;

	@Column(name="SOLUONG")
	private int soluong;

	//bi-directional many-to-one association to Hoadon
	@ManyToOne
	@JoinColumn(name="MAHD")
	private Hoadon hoadon;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH")
	private Mathang mathang;

	public ctHoaDon() {
	}

	public ctHoaDonPK getId() {
		return this.id;
	}

	public void setId(ctHoaDonPK id) {
		this.id = id;
	}

	public BigDecimal getGiatien() {
		return this.giatien;
	}

	public void setGiatien(BigDecimal giatien) {
		this.giatien = giatien;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Hoadon getHoadon() {
		return this.hoadon;
	}

	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}

	public Mathang getMathang() {
		return this.mathang;
	}

	public void setMathang(Mathang mathang) {
		this.mathang = mathang;
	}

}