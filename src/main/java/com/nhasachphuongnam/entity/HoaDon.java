package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HOADON database table.
 * 
 */
@Entity
@Table(name="HOADON")
public class HoaDon  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHD")
	private String maHD;

	@Column(name="THANHTIEN")
	private BigDecimal thanhTien;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="THOIGIAN")
	private Date thoiGian;

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="hoadon")
	private List<CTHoaDon> ctHoadons;

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

	public BigDecimal getThanhTien() {
		return this.thanhTien;
	}

	public void setThanhTien(BigDecimal thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public List<CTHoaDon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<CTHoaDon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public CTHoaDon addCtHoadon(CTHoaDon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setHoadon(this);

		return ctHoadon;
	}

	public CTHoaDon removeCtHoadon(CTHoaDon ctHoadon) {
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