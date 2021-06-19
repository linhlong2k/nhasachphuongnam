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
@Table(name="KhachHang")
/* @NamedQuery(name="KhachHang.findAll", query="SELECT k FROM KhachHang k") */
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAKH")
	private String maKH;

	@Column(name="DIACHI")
	private String diaChi;

	@Lob
	@Column(name="HINHANH")
	private byte[] hinhAnh;

	@Column(name="NGAYSINH")//, columnDefinition = "DATE")
	private Date ngaySinh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENKH")
	private String tenKH;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="khachHang")
	private List<HoaDon> hoadons;

	//bi-directional many-to-one association to TaiKhoan
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan taiKhoan;

	public KhachHang() {
	}

	public String getMaKH() {
		return this.maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
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

	public String getTenKH() {
		return this.tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public List<HoaDon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<HoaDon> hoadons) {
		this.hoadons = hoadons;
	}

	public HoaDon addHoadon(HoaDon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setKhachHang(this);

		return hoadon;
	}

	public HoaDon removeHoadon(HoaDon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setKhachHang(null);

		return hoadon;
	}

	public TaiKhoan getTaiKhoan() {
		return this.taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

}