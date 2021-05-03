package com.nhasachphuongnam.entity;

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
public class CTHoaDon  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CTHoaDonPK id;

	@Column(name="GIATIEN")
	private BigDecimal giaTien;

	@Column(name="SOLUONG")
	private Integer soLuong;

	//bi-directional many-to-one association to Hoadon
	@ManyToOne
	@JoinColumn(name="MAHD", insertable=false, updatable=false)
	private HoaDon hoadon;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH", insertable=false, updatable=false)
	private MatHang mathang;

	public CTHoaDon() {
	}

	public CTHoaDonPK getId() {
		return this.id;
	}

	public void setId(CTHoaDonPK id) {
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

	public HoaDon getHoadon() {
		return this.hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public MatHang getMathang() {
		return this.mathang;
	}

	public void setMathang(MatHang mathang) {
		this.mathang = mathang;
	}

}