package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HOATDONG")
/* @NamedQuery(name="Hoatdong.findAll", query="SELECT h FROM Hoatdong h") */
public class HoatDong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHDTK")
	private String maHDTK;

	@Column(name="GHICHU")
	private String ghiChu;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="THOIGIAN")
	private Date thoiGian;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanvien;

	public HoatDong() {
	}

	public String getMaHDTK() {
		return this.maHDTK;
	}

	public void setMaHDTK(String maHDTK) {
		this.maHDTK = maHDTK;
	}

	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public NhanVien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

}