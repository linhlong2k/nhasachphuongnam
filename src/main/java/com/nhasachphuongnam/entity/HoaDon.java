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
@Table(name="HoaDon")
/* @NamedQuery(name="HoaDon.findAll", query="SELECT h FROM HoaDon h") */
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHD")
	private String maHD;

	@Column(name="DIACHI")
	private String diaChi;

	@Column(name="GIAMGIA")
	private Float giamGia;

	@Column(name="SDT")
	private String sdt;

	@Column(name="THOIGIAN")//, columnDefinition = "DATE")
	private Date thoiGian;

	@Column(name="TINHTRANG")
	private String tinhTrang;

	//bi-directional many-to-one association to CtHoaDon
	@OneToMany(mappedBy="hoaDon")
	private List<CtHoaDon> ctHoaDons;

	//bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name="MAKH")
	private KhachHang khachHang;

	//bi-directional many-to-one association to NhanVien
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanVien;

	public HoaDon() {
	}

	public String getMaHD() {
		return this.maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Float getGiamGia() {
		return this.giamGia;
	}

	public void setGiamGia(Float giamGia) {
		this.giamGia = giamGia;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getTinhTrang() {
		return this.tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public List<CtHoaDon> getCtHoaDons() {
		return this.ctHoaDons;
	}

	public void setCtHoaDons(List<CtHoaDon> ctHoaDons) {
		this.ctHoaDons = ctHoaDons;
	}

	public CtHoaDon addCtHoaDon(CtHoaDon ctHoaDon) {
		getCtHoaDons().add(ctHoaDon);
		ctHoaDon.setHoaDon(this);

		return ctHoaDon;
	}

	public CtHoaDon removeCtHoaDon(CtHoaDon ctHoaDon) {
		getCtHoaDons().remove(ctHoaDon);
		ctHoaDon.setHoaDon(null);

		return ctHoaDon;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return this.nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

}