package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the NHANVIEN database table.
 * 
 */
@Entity
@Table(name="NHANVIEN")
@NamedQuery(name="Nhanvien.findAll", query="SELECT n FROM Nhanvien n")
public class Nhanvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MANV")
	private String manv;

	@Column(name="DIACHI")
	private String diachi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="NGAYSINH")
	private Date ngaysinh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENNV")
	private String tennv;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="nhanvien")
	private List<Hoadon> hoadons;

	//bi-directional many-to-one association to Phieunhap
	@OneToMany(mappedBy="nhanvien")
	private List<Phieunhap> phieunhaps;

	//bi-directional many-to-one association to Taikhoan
	@OneToMany(mappedBy="nhanvien")
	private List<Taikhoan> taikhoans;

	public Nhanvien() {
	}

	public String getManv() {
		return this.manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaysinh() {
		return this.ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTennv() {
		return this.tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public List<Hoadon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<Hoadon> hoadons) {
		this.hoadons = hoadons;
	}

	public Hoadon addHoadon(Hoadon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setNhanvien(this);

		return hoadon;
	}

	public Hoadon removeHoadon(Hoadon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setNhanvien(null);

		return hoadon;
	}

	public List<Phieunhap> getPhieunhaps() {
		return this.phieunhaps;
	}

	public void setPhieunhaps(List<Phieunhap> phieunhaps) {
		this.phieunhaps = phieunhaps;
	}

	public Phieunhap addPhieunhap(Phieunhap phieunhap) {
		getPhieunhaps().add(phieunhap);
		phieunhap.setNhanvien(this);

		return phieunhap;
	}

	public Phieunhap removePhieunhap(Phieunhap phieunhap) {
		getPhieunhaps().remove(phieunhap);
		phieunhap.setNhanvien(null);

		return phieunhap;
	}

	public List<Taikhoan> getTaikhoans() {
		return this.taikhoans;
	}

	public void setTaikhoans(List<Taikhoan> taikhoans) {
		this.taikhoans = taikhoans;
	}

	public Taikhoan addTaikhoan(Taikhoan taikhoan) {
		getTaikhoans().add(taikhoan);
		taikhoan.setNhanvien(this);

		return taikhoan;
	}

	public Taikhoan removeTaikhoan(Taikhoan taikhoan) {
		getTaikhoans().remove(taikhoan);
		taikhoan.setNhanvien(null);

		return taikhoan;
	}

}