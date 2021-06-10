package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="HOADON")
/* @NamedQuery(name="Hoadon.findAll", query="SELECT h FROM Hoadon h") */
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHD")
	private String maHD;

	@Column(name="DiaChi")
	private String diaChi;

	@Column(name="GIAMGIA")
	private Float giamGia;

	@Column(name="SDT")
	private String sdt;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="THOIGIAN")
	private Date thoiGian;

	@Column(name="TINHTRANG")
	private String tinhtrang;

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="hoadon")
	private List<CtHoaDon> ctHoadons;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne
	@JoinColumn(name="MAKH")
	private KhachHang khachhang;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanvien;

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

	public String getTinhtrang() {
		return this.tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public List<CtHoaDon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<CtHoaDon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public CtHoaDon addCtHoadon(CtHoaDon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setHoadon(this);

		return ctHoadon;
	}

	public CtHoaDon removeCtHoadon(CtHoaDon ctHoadon) {
		getCtHoadons().remove(ctHoadon);
		ctHoadon.setHoadon(null);

		return ctHoadon;
	}

	public KhachHang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public NhanVien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

}