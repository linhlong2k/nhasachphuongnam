package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PHIEUNHAP")
/* @NamedQuery(name="Phieunhap.findAll", query="SELECT p FROM Phieunhap p") */
public class PhieuNhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAPN")
	private String maPN;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="THOIGIAN")
	private Date thoiGian;

	//bi-directional many-to-one association to CtPhieunhap
	@OneToMany(mappedBy="phieunhap")
	private List<CtPhieuNhap> ctPhieunhaps;

	//bi-directional many-to-one association to Nhacungcap
	@ManyToOne
	@JoinColumn(name="MANCC")
	private NhaCungCap nhacungcap;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanvien;

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

	public List<CtPhieuNhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(List<CtPhieuNhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

	public CtPhieuNhap addCtPhieunhap(CtPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().add(ctPhieunhap);
		ctPhieunhap.setPhieunhap(this);

		return ctPhieunhap;
	}

	public CtPhieuNhap removeCtPhieunhap(CtPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().remove(ctPhieunhap);
		ctPhieunhap.setPhieunhap(null);

		return ctPhieunhap;
	}

	public NhaCungCap getNhacungcap() {
		return this.nhacungcap;
	}

	public void setNhacungcap(NhaCungCap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	public NhanVien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

}