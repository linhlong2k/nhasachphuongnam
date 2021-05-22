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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="NHANVIEN")
//@NamedQuery(name="Nhanvien.findAll", query="SELECT n FROM Nhanvien n")
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

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="NGAYSINH")
	private Date ngaySinh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENNV")
	private String tenNV;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="nhanvien")
	private List<HoaDon> hoadons;

	//bi-directional many-to-one association to Hoatdong
	@OneToMany(mappedBy="nhanvien")
	private List<HoatDong> hoatdongs;

	//bi-directional many-to-one association to Taikhoan
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan taikhoan;

	//bi-directional many-to-one association to Phieunhap
	@OneToMany(mappedBy="nhanvien")
	private List<PhieuNhap> phieunhaps;

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

	public List<HoatDong> getHoatdongs() {
		return this.hoatdongs;
	}

	public void setHoatdongs(List<HoatDong> hoatdongs) {
		this.hoatdongs = hoatdongs;
	}

	public HoatDong addHoatdong(HoatDong hoatdong) {
		getHoatdongs().add(hoatdong);
		hoatdong.setNhanvien(this);

		return hoatdong;
	}

	public HoatDong removeHoatdong(HoatDong hoatdong) {
		getHoatdongs().remove(hoatdong);
		hoatdong.setNhanvien(null);

		return hoatdong;
	}

	public TaiKhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
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

}