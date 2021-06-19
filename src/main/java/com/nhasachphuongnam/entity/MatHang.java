package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="MatHang")
/* @NamedQuery(name="MatHang.findAll", query="SELECT m FROM MatHang m") */
public class MatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAMH")
	private String maMH;

	@Column(name="ALLOW")
	private boolean allow;

	@Column(name="GIA")
	private BigDecimal gia;

	@Column(name="GIAMGIA")
	private Float giamGia;

	@Lob
	@Column(name="HINHANH")
	private byte[] hinhAnh;

	@Column(name="MOTA")
	private String moTa;

	@Column(name="MOTANGAN")
	private String moTaNgan;

	@Column(name="SOLUONG")
	private int soLuong;

	@Column(name="TENMH")
	private String tenMH;

	//bi-directional many-to-one association to CtHoaDon
	@OneToMany(mappedBy="matHang")
	private List<CtHoaDon> ctHoaDons;

	//bi-directional many-to-one association to CtPhieunhap
	@OneToMany(mappedBy="matHang")
	private List<CtPhieuNhap> ctPhieunhaps;

	//bi-directional many-to-one association to LoaiMatHang
	@ManyToOne
	@JoinColumn(name="MALOAI")
	private LoaiMatHang loaiMatHang;

	public MatHang() {
	}

	public String getMaMH() {
		return this.maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public boolean getAllow() {
		return this.allow;
	}

	public void setAllow(boolean allow) {
		this.allow = allow;
	}

	public BigDecimal getGia() {
		return this.gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Float getGiamGia() {
		return this.giamGia;
	}

	public void setGiamGia(Float giamGia) {
		this.giamGia = giamGia;
	}

	public byte[] getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getMoTaNgan() {
		return this.moTaNgan;
	}

	public void setMoTaNgan(String moTaNgan) {
		this.moTaNgan = moTaNgan;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenMH() {
		return this.tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public List<CtHoaDon> getCtHoaDons() {
		return this.ctHoaDons;
	}

	public void setCtHoaDons(List<CtHoaDon> ctHoaDons) {
		this.ctHoaDons = ctHoaDons;
	}

	public CtHoaDon addCtHoaDon(CtHoaDon ctHoaDon) {
		getCtHoaDons().add(ctHoaDon);
		ctHoaDon.setMatHang(this);

		return ctHoaDon;
	}

	public CtHoaDon removeCtHoaDon(CtHoaDon ctHoaDon) {
		getCtHoaDons().remove(ctHoaDon);
		ctHoaDon.setMatHang(null);

		return ctHoaDon;
	}

	public List<CtPhieuNhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(List<CtPhieuNhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

	public CtPhieuNhap addCtPhieunhap(CtPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().add(ctPhieunhap);
		ctPhieunhap.setMatHang(this);

		return ctPhieunhap;
	}

	public CtPhieuNhap removeCtPhieunhap(CtPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().remove(ctPhieunhap);
		ctPhieunhap.setMatHang(null);

		return ctPhieunhap;
	}

	public LoaiMatHang getLoaiMatHang() {
		return this.loaiMatHang;
	}

	public void setLoaiMatHang(LoaiMatHang loaiMatHang) {
		this.loaiMatHang = loaiMatHang;
	}

}