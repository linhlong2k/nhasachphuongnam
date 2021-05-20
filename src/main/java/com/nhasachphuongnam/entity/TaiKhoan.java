package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TAIKHOAN")
//@NamedQuery(name="Taikhoan.findAll", query="SELECT t FROM Taikhoan t")
public class TaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	//bi-directional many-to-one association to Khachhang
	@OneToMany(mappedBy="taikhoan")
	private List<KhachHang> khachhangs;

	//bi-directional many-to-one association to Nhanvien
	@OneToMany(mappedBy="taikhoan")
	private List<NhanVien> nhanviens;

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

	public List<KhachHang> getKhachhangs() {
		return this.khachhangs;
	}

	public void setKhachhangs(List<KhachHang> khachhangs) {
		this.khachhangs = khachhangs;
	}

	public KhachHang addKhachhang(KhachHang khachhang) {
		getKhachhangs().add(khachhang);
		khachhang.setTaikhoan(this);

		return khachhang;
	}

	public KhachHang removeKhachhang(KhachHang khachhang) {
		getKhachhangs().remove(khachhang);
		khachhang.setTaikhoan(null);

		return khachhang;
	}

	public List<NhanVien> getNhanviens() {
		return this.nhanviens;
	}

	public void setNhanviens(List<NhanVien> nhanviens) {
		this.nhanviens = nhanviens;
	}

	public NhanVien addNhanvien(NhanVien nhanvien) {
		getNhanviens().add(nhanvien);
		nhanvien.setTaikhoan(this);

		return nhanvien;
	}

	public NhanVien removeNhanvien(NhanVien nhanvien) {
		getNhanviens().remove(nhanvien);
		nhanvien.setTaikhoan(null);

		return nhanvien;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}