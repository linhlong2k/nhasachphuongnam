package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HOATDONG database table.
 * 
 */
@Entity
@Table(name="HOATDONG")
public class HoatDong  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHDTK")
	private String maHDTK;

	@Column(name="GHICHU")
	private String ghiChu;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="THOIGIAN")
	private Date thoiGian;

	//bi-directional many-to-one association to Taikhoan
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan taikhoan;

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

	public TaiKhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

}