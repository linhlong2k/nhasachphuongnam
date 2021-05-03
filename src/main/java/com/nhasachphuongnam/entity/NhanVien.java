package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the NHANVIEN database table.
 * 
 */
@Entity
@Table(name="NHANVIEN")
public class NhanVien  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MANV")
	private String maNV;

	@Column(name="DIACHI")
	private String diaChi;

	@Column(name="NGAYSINH")
	private String ngaySinh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENNV")
	private String tenNV;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="nhanvien")
	private List<HoaDon> hoadons;

	//bi-directional many-to-one association to Phieunhap
	@OneToMany(mappedBy="nhanvien")
	private List<PhieuNhap> phieunhaps;

	//bi-directional many-to-one association to Taikhoan
	@OneToMany(mappedBy="nhanvien")
	private List<TaiKhoan> taikhoans;

	public NhanVien() {
	}

	public String getMaNV() {
		return this.maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTenNV() {
		return this.tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public List<HoaDon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<HoaDon> hoadons) {
		this.hoadons = hoadons;
	}

	public HoaDon addHoadon(HoaDon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setNhanvien(this);

		return hoadon;
	}

	public HoaDon removeHoadon(HoaDon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setNhanvien(null);

		return hoadon;
	}

	public List<PhieuNhap> getPhieunhaps() {
		return this.phieunhaps;
	}

	public void setPhieunhaps(List<PhieuNhap> phieunhaps) {
		this.phieunhaps = phieunhaps;
	}

	public PhieuNhap addPhieunhap(PhieuNhap phieunhap) {
		getPhieunhaps().add(phieunhap);
		phieunhap.setNhanvien(this);

		return phieunhap;
	}

	public PhieuNhap removePhieunhap(PhieuNhap phieunhap) {
		getPhieunhaps().remove(phieunhap);
		phieunhap.setNhanvien(null);

		return phieunhap;
	}

	public List<TaiKhoan> getTaikhoans() {
		return this.taikhoans;
	}

	public void setTaikhoans(List<TaiKhoan> taikhoans) {
		this.taikhoans = taikhoans;
	}

	public TaiKhoan addTaikhoan(TaiKhoan taikhoan) {
		getTaikhoans().add(taikhoan);
		taikhoan.setNhanvien(this);

		return taikhoan;
	}

	public TaiKhoan removeTaikhoan(TaiKhoan taikhoan) {
		getTaikhoans().remove(taikhoan);
		taikhoan.setNhanvien(null);

		return taikhoan;
	}

}