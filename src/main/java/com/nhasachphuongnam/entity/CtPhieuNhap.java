package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="CT_PhieuNhap")
/*
 * @NamedQuery(name="CtPhieuNhap.findAll", query="SELECT c FROM CtPhieuNhap c")
 */
public class CtPhieuNhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtPhieuNhapPK id;

	@Column(name="GIA")
	private BigDecimal gia;

	@Column(name="GIAMGIA")
	private Float giamGia;

	@Column(name="SOLUONG")
	private int soLuong;

	//bi-directional many-to-one association to MatHang
	@ManyToOne
	@JoinColumn(name="MAMH", insertable=false, updatable=false)
	private MatHang matHang;

	//bi-directional many-to-one association to PhieuNhap
	@ManyToOne
	@JoinColumn(name="MAPN", insertable=false, updatable=false)
	private PhieuNhap phieuNhap;

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

	public Float getGiamGia() {
		return this.giamGia;
	}

	public void setGiamGia(Float giamGia) {
		this.giamGia = giamGia;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public MatHang getMatHang() {
		return this.matHang;
	}

	public void setMatHang(MatHang matHang) {
		this.matHang = matHang;
	}

	public PhieuNhap getPhieuNhap() {
		return this.phieuNhap;
	}

	public void setPhieuNhap(PhieuNhap phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

}