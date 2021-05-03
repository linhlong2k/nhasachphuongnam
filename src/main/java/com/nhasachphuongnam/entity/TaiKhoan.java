package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TAIKHOAN database table.
 * 
 */
@Entity
@Table(name="TAIKHOAN")
public class TaiKhoan  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	//bi-directional many-to-one association to Hoatdong
	@OneToMany(mappedBy="taikhoan")
	private List<HoatDong> hoatdongs;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanvien;

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

	public List<HoatDong> getHoatdongs() {
		return this.hoatdongs;
	}

	public void setHoatdongs(List<HoatDong> hoatdongs) {
		this.hoatdongs = hoatdongs;
	}

	public HoatDong addHoatdong(HoatDong hoatdong) {
		getHoatdongs().add(hoatdong);
		hoatdong.setTaikhoan(this);

		return hoatdong;
	}

	public HoatDong removeHoatdong(HoatDong hoatdong) {
		getHoatdongs().remove(hoatdong);
		hoatdong.setTaikhoan(null);

		return hoatdong;
	}

	public NhanVien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}