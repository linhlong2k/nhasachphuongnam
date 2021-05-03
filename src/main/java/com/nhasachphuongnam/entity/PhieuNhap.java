package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PHIEUNHAP database table.
 * 
 */
@Entity
@Table(name="PHIEUNHAP")
public class PhieuNhap  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAPN")
	private String maPN;

	@Column(name="THANHTIEN")
	private BigDecimal thanhTien;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="THOIGIAN")
	private Date thoiGian;

	//bi-directional many-to-one association to CtPhieunhap
	@OneToMany(mappedBy="phieunhap")
	private List<CTPhieuNhap> ctPhieunhaps;

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

	public BigDecimal getThanhTien() {
		return this.thanhTien;
	}

	public void setThanhTien(BigDecimal thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public List<CTPhieuNhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(List<CTPhieuNhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

	public CTPhieuNhap addCtPhieunhap(CTPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().add(ctPhieunhap);
		ctPhieunhap.setPhieunhap(this);

		return ctPhieunhap;
	}

	public CTPhieuNhap removeCtPhieunhap(CTPhieuNhap ctPhieunhap) {
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