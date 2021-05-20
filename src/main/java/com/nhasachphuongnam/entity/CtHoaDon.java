package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CT_HOADON")
//@NamedQuery(name="CtHoadon.findAll", query="SELECT c FROM CtHoadon c")
public class CtHoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtHoaDonPK id;

	@Column(name="GIA")
	private BigDecimal gia;

	@Column(name="GIAMGIA")
	private float giamgia;

	@Column(name="SOLUONG")
	private int soLuong;

	//bi-directional many-to-one association to Hoadon
	@ManyToOne
	@JoinColumn(name="MAHD", insertable=false, updatable=false)
	private HoaDon hoadon;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH", insertable=false, updatable=false)
	private MatHang mathang;

	public CtHoaDon() {
	}

	public CtHoaDonPK getId() {
		return this.id;
	}

	public void setId(CtHoaDonPK id) {
		this.id = id;
	}

	public BigDecimal getGia() {
		return this.gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public float getGiamgia() {
		return this.giamgia;
	}

	public void setGiamgia(float giamgia) {
		this.giamgia = giamgia;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
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