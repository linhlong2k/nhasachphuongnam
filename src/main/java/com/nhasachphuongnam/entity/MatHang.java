package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MATHANG database table.
 * 
 */
@Entity
@Table(name="MATHANG")
public class MatHang  {
	@Id
	@Column(name="MAMH")
	private String maMH;

	@Column(name="HINHANH")
	private String hinhAnh;

	@Column(name="MOTA")
	private String moTa;

	@Column(name="MOTANGAN")
	private String moTaNgan;

	@Column(name="SOLUONG")
	private Integer soLuong;

	@Column(name="TENMH")
	private String tenMH;
	
	@Column(name="ALLOW")
	boolean allow;

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="mathang")
	private List<CTHoaDon> ctHoadons;

	//bi-directional many-to-one association to CtPhieunhap
	@OneToMany(mappedBy="mathang")
	private List<CTPhieuNhap> ctPhieunhaps;

	//bi-directional many-to-one association to Gia
	@OneToMany(mappedBy="mathang")
	private List<Gia> gias;

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

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
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

	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenMH() {
		return this.tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	
	public boolean isAllow() {
		return allow;
	}

	public void setAllow(boolean allow) {
		this.allow = allow;
	}

	public List<CTHoaDon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<CTHoaDon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public CTHoaDon addCtHoadon(CTHoaDon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setMathang(this);

		return ctHoadon;
	}

	public CTHoaDon removeCtHoadon(CTHoaDon ctHoadon) {
		getCtHoadons().remove(ctHoadon);
		ctHoadon.setMathang(null);

		return ctHoadon;
	}

	public List<CTPhieuNhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(List<CTPhieuNhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

	public CTPhieuNhap addCtPhieunhap(CTPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().add(ctPhieunhap);
		ctPhieunhap.setMathang(this);

		return ctPhieunhap;
	}

	public CTPhieuNhap removeCtPhieunhap(CTPhieuNhap ctPhieunhap) {
		getCtPhieunhaps().remove(ctPhieunhap);
		ctPhieunhap.setMathang(null);

		return ctPhieunhap;
	}

	public List<Gia> getGias() {
		return this.gias;
	}

	public void setGias(List<Gia> gias) {
		this.gias = gias;
	}

	public Gia addGia(Gia gia) {
		getGias().add(gia);
		gia.setMathang(this);

		return gia;
	}

	public Gia removeGia(Gia gia) {
		getGias().remove(gia);
		gia.setMathang(null);

		return gia;
	}

	public LoaiMatHang getLoaimathang() {
		return this.loaimathang;
	}

	public void setLoaimathang(LoaiMatHang loaimathang) {
		this.loaimathang = loaimathang;
	}

}