package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PhieuNhap")
/* @NamedQuery(name="PhieuNhap.findAll", query="SELECT p FROM PhieuNhap p") */
public class PhieuNhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAPN")
	private String maPN;

	@Column(name="THOIGIAN")//, columnDefinition = "DATE")
	private Date thoiGian;

	//bi-directional many-to-one association to CtPhieuNhap
	@OneToMany(mappedBy="phieuNhap")
	private List<CtPhieuNhap> ctPhieuNhaps;

	//bi-directional many-to-one association to NhaCungCap
	@ManyToOne
	@JoinColumn(name="MANCC")
	private NhaCungCap nhaCungCap;

	//bi-directional many-to-one association to NhanVien
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanVien;

	public PhieuNhap() {
	}

	public String getMaPN() {
		return this.maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public List<CtPhieuNhap> getCtPhieuNhaps() {
		return this.ctPhieuNhaps;
	}

	public void setCtPhieuNhaps(List<CtPhieuNhap> ctPhieuNhaps) {
		this.ctPhieuNhaps = ctPhieuNhaps;
	}

	public CtPhieuNhap addCtPhieuNhap(CtPhieuNhap ctPhieuNhap) {
		getCtPhieuNhaps().add(ctPhieuNhap);
		ctPhieuNhap.setPhieuNhap(this);

		return ctPhieuNhap;
	}

	public CtPhieuNhap removeCtPhieuNhap(CtPhieuNhap ctPhieuNhap) {
		getCtPhieuNhaps().remove(ctPhieuNhap);
		ctPhieuNhap.setPhieuNhap(null);

		return ctPhieuNhap;
	}

	public NhaCungCap getNhaCungCap() {
		return this.nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public NhanVien getNhanVien() {
		return this.nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

}