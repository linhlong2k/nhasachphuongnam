package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="KHACHHANG")
/* @NamedQuery(name="Khachhang.findAll", query="SELECT k FROM Khachhang k") */
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

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="NGAYSINH")
	private Date ngaySinh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENKH")
	private String tenKH;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="khachhang")
	private List<HoaDon> hoadons;

	//bi-directional many-to-one association to Taikhoan
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan taikhoan;

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
		hoadon.setKhachhang(this);

		return hoadon;
	}

	public HoaDon removeHoadon(HoaDon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setKhachhang(null);

		return hoadon;
	}

	public TaiKhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

}