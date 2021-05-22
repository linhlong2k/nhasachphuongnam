package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="HOATDONG")
//@NamedQuery(name="Hoatdong.findAll", query="SELECT h FROM Hoatdong h")
public class HoatDong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHDTK")
	private String maHDTK;

	@Column(name="GHICHU")
	private String ghiChu;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
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