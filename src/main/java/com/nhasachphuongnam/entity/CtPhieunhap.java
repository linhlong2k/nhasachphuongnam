package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CT_PHIEUNHAP database table.
 * 
 */
@Entity
@Table(name="CT_PHIEUNHAP")
public class CtPhieunhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtPhieunhapPK id;

	@Column(name="GIATIEN")
	private BigDecimal giatien;

	@Column(name="SOLUONG")
	private int soluong;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH")
	private Mathang mathang;

	//bi-directional many-to-one association to Phieunhap
	@ManyToOne
	@JoinColumn(name="MAPN")
	private Phieunhap phieunhap;

	public CtPhieunhap() {
	}

	public CtPhieunhapPK getId() {
		return this.id;
	}

	public void setId(CtPhieunhapPK id) {
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

	public Mathang getMathang() {
		return this.mathang;
	}

	public void setMathang(Mathang mathang) {
		this.mathang = mathang;
	}

	public Phieunhap getPhieunhap() {
		return this.phieunhap;
	}

	public void setPhieunhap(Phieunhap phieunhap) {
		this.phieunhap = phieunhap;
	}

}