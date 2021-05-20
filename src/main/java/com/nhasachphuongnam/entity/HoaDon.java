package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="HOADON")
//@NamedQuery(name="Hoadon.findAll", query="SELECT h FROM Hoadon h")
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHD")
	private String maHD;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="THOIGIAN")
	private Date thoiGian;

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

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
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