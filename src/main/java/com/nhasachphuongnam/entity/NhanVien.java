package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NhanVien")
/* @NamedQuery(name="NhanVien.findAll", query="SELECT n FROM NhanVien n") */
public class NhanVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MANV")
	private String maNV;

	@Column(name="DIACHI")
	private String diaChi;

	@Lob
	@Column(name="HINHANH")
	private byte[] hinhAnh;

	@Column(name="NGAYSINH")//, columnDefinition = "DATE")
	private Date ngaySinh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENNV")
	private String tenNV;

	//bi-directional many-to-one association to HoaDon
	@OneToMany(mappedBy="nhanVien")
	private List<HoaDon> hoaDons;

	//bi-directional many-to-one association to HoatDong
	@OneToMany(mappedBy="nhanVien")
	private List<HoatDong> hoatDongs;

	//bi-directional many-to-one association to TaiKhoan
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan taiKhoan;

	//bi-directional many-to-one association to PhieuNhap
	@OneToMany(mappedBy="nhanVien")
	private List<PhieuNhap> phieuNhaps;

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

	public byte[] getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Date getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
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

	public List<HoaDon> getHoaDons() {
		return this.hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public HoaDon addHoaDon(HoaDon hoaDon) {
		getHoaDons().add(hoaDon);
		hoaDon.setNhanVien(this);

		return hoaDon;
	}

	public HoaDon removeHoaDon(HoaDon hoaDon) {
		getHoaDons().remove(hoaDon);
		hoaDon.setNhanVien(null);

		return hoaDon;
	}

	public List<HoatDong> getHoatDongs() {
		return this.hoatDongs;
	}

	public void setHoatDongs(List<HoatDong> hoatDongs) {
		this.hoatDongs = hoatDongs;
	}

	public HoatDong addHoatDong(HoatDong hoatDong) {
		getHoatDongs().add(hoatDong);
		hoatDong.setNhanVien(this);
		return hoatDong;
	}

	public HoatDong removeHoatDong(HoatDong hoatDong) {
		getHoatDongs().remove(hoatDong);
		hoatDong.setNhanVien(null);

		return hoatDong;
	}

	public TaiKhoan getTaiKhoan() {
		return this.taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<PhieuNhap> getPhieuNhaps() {
		return this.phieuNhaps;
	}

	public void setPhieuNhaps(List<PhieuNhap> phieuNhaps) {
		this.phieuNhaps = phieuNhaps;
	}

	public PhieuNhap addPhieuNhap(PhieuNhap phieuNhap) {
		getPhieuNhaps().add(phieuNhap);
		phieuNhap.setNhanVien(this);

		return phieuNhap;
	}

	public PhieuNhap removePhieuNhap(PhieuNhap phieuNhap) {
		getPhieuNhaps().remove(phieuNhap);
		phieuNhap.setNhanVien(null);

		return phieuNhap;
	}

}