package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="[ROLE]")
/* @NamedQuery(name="Role.findAll", query="SELECT r FROM Role r") */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAROLE")
	private String maRole;

	@Column(name="TENROLE")
	private String tenRole;

	//bi-directional many-to-one association to TaiKhoan
	@OneToMany(mappedBy="role")
	private List<TaiKhoan> taiKhoans;

	public Role() {
	}

	public String getMaRole() {
		return this.maRole;
	}

	public void setMaRole(String maRole) {
		this.maRole = maRole;
	}

	public String getTenRole() {
		return this.tenRole;
	}

	public void setTenRole(String tenRole) {
		this.tenRole = tenRole;
	}

	public List<TaiKhoan> getTaiKhoans() {
		return this.taiKhoans;
	}

	public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}

	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
		getTaiKhoans().add(taiKhoan);
		taiKhoan.setRole(this);

		return taiKhoan;
	}

	public TaiKhoan removeTaiKhoan(TaiKhoan taiKhoan) {
		getTaiKhoans().remove(taiKhoan);
		taiKhoan.setRole(null);

		return taiKhoan;
	}

}