package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * The persistent class for the HOATDONG database table.
 * 
 */
@Entity
@Table(name="HOATDONG")
@NamedQuery(name="Hoatdong.findAll", query="SELECT h FROM Hoatdong h")
public class Hoatdong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHDTK")
	private String mahdtk;

	@Column(name="GHICHU")
	private String ghichu;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="THOIGIAN")
	private Date thoigian;

	//bi-directional many-to-one association to Taikhoan
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Taikhoan taikhoan;

	public Hoatdong() {
	}

	public String getMahdtk() {
		return this.mahdtk;
	}

	public void setMahdtk(String mahdtk) {
		this.mahdtk = mahdtk;
	}

	public String getGhichu() {
		return this.ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Date getThoigian() {
		return this.thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

}