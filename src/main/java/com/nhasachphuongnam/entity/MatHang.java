package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="MATHANG")
/* @NamedQuery(name="Mathang.findAll", query="SELECT m FROM Mathang m") */
public class MatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAMH")
	private String maMH;

	@Column(name="ALLOW")
	private boolean allow;

	@Column(name="GIA")
	private BigDecimal gia;

	@Column(name="GIamGia")
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

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="mathang")
	private List<CtHoaDon> ctHoadons;

	//bi-directional many-to-one association to CtPhieunhap
	@OneToMany(mappedBy="mathang")
	private List<CtPhieuNhap> ctPhieunhaps;

	//bi-directional many-to-one association to Loaimathang
	@ManyToOne
	@JoinColumn(name="MALOAI")
	private LoaiMatHang loaimathang;

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

	public List<CtHoaDon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<CtHoaDon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public CtHoaDon addCtHoadon(CtHoaDon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setMathang(this);

		return ctHoadon;
	}

	public CtHoaDon removeCtHoadon(CtHoaDon ctHoadon) {
		getCtHoadons().remove(ctHoadon);
		ctHoadon.setMathang(null);

		return ctHoadon;
	}

	public List<CtPhieuNhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(List<CtPhieuNhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

	public CtPhieuNhap addCtPhieunhap(CtPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().add(ctPhieunhap);
		ctPhieunhap.setMathang(this);

		return ctPhieunhap;
	}

	public CtPhieuNhap removeCtPhieunhap(CtPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().remove(ctPhieunhap);
		ctPhieunhap.setMathang(null);

		return ctPhieunhap;
	}

	public LoaiMatHang getLoaimathang() {
		return this.loaimathang;
	}

	public void setLoaimathang(LoaiMatHang loaimathang) {
		this.loaimathang = loaimathang;
	}

}