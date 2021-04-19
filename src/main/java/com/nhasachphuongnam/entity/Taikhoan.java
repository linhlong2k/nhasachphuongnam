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
public class Taikhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	//bi-directional many-to-one association to Hoatdong
	@OneToMany(mappedBy="taikhoan")
	private List<Hoatdong> hoatdongs;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="MANV")
	private Nhanvien nhanvien;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="MAROLE")
	private Role role;

	public Taikhoan() {
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

	public List<Hoatdong> getHoatdongs() {
		return this.hoatdongs;
	}

	public void setHoatdongs(List<Hoatdong> hoatdongs) {
		this.hoatdongs = hoatdongs;
	}

	public Hoatdong addHoatdong(Hoatdong hoatdong) {
		getHoatdongs().add(hoatdong);
		hoatdong.setTaikhoan(this);

		return hoatdong;
	}

	public Hoatdong removeHoatdong(Hoatdong hoatdong) {
		getHoatdongs().remove(hoatdong);
		hoatdong.setTaikhoan(null);

		return hoatdong;
	}

	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}