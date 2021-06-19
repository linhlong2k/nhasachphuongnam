package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TaiKhoan")
/* @NamedQuery(name="TaiKhoan.findAll", query="SELECT t FROM TaiKhoan t") */
public class TaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	//bi-directional many-to-one association to KhachHang
	@OneToMany(mappedBy="taiKhoan")
	private List<KhachHang> khachHangs;

	//bi-directional many-to-one association to NhanVien
	@OneToMany(mappedBy="taiKhoan")
	private List<NhanVien> nhanViens;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="MAROLE")
	private Role role;

	public TaiKhoan() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<KhachHang> getKhachHangs() {
		return this.khachHangs;
	}

	public void setKhachHangs(List<KhachHang> khachHangs) {
		this.khachHangs = khachHangs;
	}

	public KhachHang addKhachHang(KhachHang khachHang) {
		getKhachHangs().add(khachHang);
		khachHang.setTaiKhoan(this);

		return khachHang;
	}

	public KhachHang removeKhachHang(KhachHang khachHang) {
		getKhachHangs().remove(khachHang);
		khachHang.setTaiKhoan(null);

		return khachHang;
	}

	public List<NhanVien> getNhanViens() {
		return this.nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

	public NhanVien addNhanVien(NhanVien nhanVien) {
		getNhanViens().add(nhanVien);
		nhanVien.setTaiKhoan(this);

		return nhanVien;
	}

	public NhanVien removeNhanVien(NhanVien nhanVien) {
		getNhanViens().remove(nhanVien);
		nhanVien.setTaiKhoan(null);

		return nhanVien;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}