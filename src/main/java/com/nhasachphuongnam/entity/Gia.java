package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the GIA database table.
 * 
 */
@Entity
@Table(name="GIA")
@NamedQuery(name="Gia.findAll", query="SELECT g FROM Gia g")
public class Gia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MAGIA")
	private long magia;

	@Column(name="GIA")
	private BigDecimal gia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="THOIGIAN")
	private Date thoiGian;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH")
	private MatHang mathang;

	public Gia() {
	}

	public long getMagia() {
		return this.magia;
	}

	public void setMagia(long magia) {
		this.magia = magia;
	}

	public BigDecimal getGia() {
		return this.gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public MatHang getMathang() {
		return this.mathang;
	}

	public void setMathang(MatHang mathang) {
		this.mathang = mathang;
	}

}