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
public class CTPhieuNhap  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CTPhieuNhapPK id;

	@Column(name="GIATIEN")
	private BigDecimal giaTien;

	@Column(name="SOLUONG")
	private Integer soLuong;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH", insertable=false, updatable=false)
	private MatHang mathang;

	//bi-directional many-to-one association to Phieunhap
	@ManyToOne
	@JoinColumn(name="MAPN", insertable=false, updatable=false)
	private PhieuNhap phieunhap;

	public CTPhieuNhap() {
	}

	public CTPhieuNhapPK getId() {
		return this.id;
	}

	public void setId(CTPhieuNhapPK id) {
		this.id = id;
	}

	public BigDecimal getGiaTien() {
		return this.giaTien;
	}

	public void setGiaTien(BigDecimal giaTien) {
		this.giaTien = giaTien;
	}

	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public MatHang getMathang() {
		return this.mathang;
	}

	public void setMathang(MatHang mathang) {
		this.mathang = mathang;
	}

	public PhieuNhap getPhieunhap() {
		return this.phieunhap;
	}

	public void setPhieunhap(PhieuNhap phieunhap) {
		this.phieunhap = phieunhap;
	}

}