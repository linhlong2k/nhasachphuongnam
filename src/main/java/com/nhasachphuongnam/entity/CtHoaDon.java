package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="CT_HoaDon")
/* @NamedQuery(name="CtHoaDon.findAll", query="SELECT c FROM CtHoaDon c") */
public class CtHoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtHoaDonPK id;

	@Column(name="GIA")
	private BigDecimal gia;

	@Column(name="SOLUONG")
	private int soLuong;

	//bi-directional many-to-one association to HoaDon
	@ManyToOne
	@JoinColumn(name="MAHD", insertable=false, updatable=false)
	private HoaDon hoaDon;

	//bi-directional many-to-one association to MatHang
	@ManyToOne
	@JoinColumn(name="MAMH", insertable=false, updatable=false)
	private MatHang matHang;

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

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public HoaDon getHoaDon() {
		return this.hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public MatHang getMatHang() {
		return this.matHang;
	}

	public void setMatHang(MatHang matHang) {
		this.matHang = matHang;
	}

}