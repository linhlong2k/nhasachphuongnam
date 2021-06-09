package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="CT_PHIEUNHAP")
/*
 * @NamedQuery(name="CtPhieunhap.findAll", query="SELECT c FROM CtPhieunhap c")
 */
public class CtPhieuNhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtPhieuNhapPK id;

	@Column(name="GIA")
	private BigDecimal gia;

	@Column(name="GIAMGIA")
	private Float giamgia;

	@Column(name="SOLUONG")
	private int soLuong;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH", insertable=false, updatable=false)
	private MatHang mathang;

	//bi-directional many-to-one association to Phieunhap
	@ManyToOne
	@JoinColumn(name="MAPN", insertable=false, updatable=false)
	private PhieuNhap phieunhap;

	public CtPhieuNhap() {
	}

	public CtPhieuNhapPK getId() {
		return this.id;
	}

	public void setId(CtPhieuNhapPK id) {
		this.id = id;
	}

	public BigDecimal getGia() {
		return this.gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Float getGiamgia() {
		return this.giamgia;
	}

	public void setGiamgia(Float giamgia) {
		this.giamgia = giamgia;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
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