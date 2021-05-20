package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="[ROLE]")
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAROLE")
	private String maRole;

	@Column(name="TENROLE")
	private String tenRole;

	//bi-directional many-to-one association to Taikhoan
	@OneToMany(mappedBy="role")
	private List<TaiKhoan> taikhoans;

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

	public List<TaiKhoan> getTaikhoans() {
		return this.taikhoans;
	}

	public void setTaikhoans(List<TaiKhoan> taikhoans) {
		this.taikhoans = taikhoans;
	}

	public TaiKhoan addTaikhoan(TaiKhoan taikhoan) {
		getTaikhoans().add(taikhoan);
		taikhoan.setRole(this);

		return taikhoan;
	}

	public TaiKhoan removeTaikhoan(TaiKhoan taikhoan) {
		getTaikhoans().remove(taikhoan);
		taikhoan.setRole(null);

		return taikhoan;
	}

}