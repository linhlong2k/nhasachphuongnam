package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HOADON database table.
 * 
 */
@Entity
@Table(name="HOADON")
public class Hoadon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHD")
	private String mahd;

	@Column(name="THANHTIEN")
	private BigDecimal thanhtien;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="THOIGIAN")
	private Date thoigian;

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="hoadon")
	private List<ctHoaDon> ctHoadons;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne
	@JoinColumn(name="MAKH")
	private Khachhang khachhang;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="MANV")
	private Nhanvien nhanvien;

	public Hoadon() {
	}

	public String getMahd() {
		return this.mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
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

	public List<ctHoaDon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<ctHoaDon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public ctHoaDon addCtHoadon(ctHoaDon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setHoadon(this);

		return ctHoadon;
	}

	public ctHoaDon removeCtHoadon(ctHoaDon ctHoadon) {
		getCtHoadons().remove(ctHoadon);
		ctHoadon.setHoadon(null);

		return ctHoadon;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

}