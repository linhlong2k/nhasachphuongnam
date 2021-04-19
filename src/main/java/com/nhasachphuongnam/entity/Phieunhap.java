package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the PHIEUNHAP database table.
 * 
 */
@Entity
@Table(name="PHIEUNHAP")
public class Phieunhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAPN")
	private String mapn;

	@Column(name="THANHTIEN")
	private BigDecimal thanhtien;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="THOIGIAN")
	private Date thoigian;

	//bi-directional many-to-one association to CtPhieunhap
	@OneToMany(mappedBy="phieunhap")
	private List<CtPhieunhap> ctPhieunhaps;

	//bi-directional many-to-one association to Nhacungcap
	@ManyToOne
	@JoinColumn(name="MANCC")
	private Nhacungcap nhacungcap;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="MANV")
	private Nhanvien nhanvien;

	public Phieunhap() {
	}

	public String getMapn() {
		return this.mapn;
	}

	public void setMapn(String mapn) {
		this.mapn = mapn;
	}

	public BigDecimal getThanhtien() {
		return this.thanhtien;
	}

	public void setThanhtien(BigDecimal thanhtien) {
		this.thanhtien = thanhtien;
	}

	public Date getThoigian() {
		return this.thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public List<CtPhieunhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(List<CtPhieunhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

	public CtPhieunhap addCtPhieunhap(CtPhieunhap ctPhieunhap) {
		getCtPhieunhaps().add(ctPhieunhap);
		ctPhieunhap.setPhieunhap(this);

		return ctPhieunhap;
	}

	public CtPhieunhap removeCtPhieunhap(CtPhieunhap ctPhieunhap) {
		getCtPhieunhaps().remove(ctPhieunhap);
		ctPhieunhap.setPhieunhap(null);

		return ctPhieunhap;
	}

	public Nhacungcap getNhacungcap() {
		return this.nhacungcap;
	}

	public void setNhacungcap(Nhacungcap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

}