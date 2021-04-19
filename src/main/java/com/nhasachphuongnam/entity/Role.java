package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the [ROLE] database table.
 * 
 */
@Entity
@Table(name="[ROLE]")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAROLE")
	private String marole;
	
	@Column(name="TENROLE")
	private String tenrole;

	//bi-directional many-to-one association to Taikhoan
	@OneToMany(mappedBy="role")
	private List<Taikhoan> taikhoans;

	public Role() {
	}

	public String getMarole() {
		return this.marole;
	}

	public void setMarole(String marole) {
		this.marole = marole;
	}

	public String getTenrole() {
		return this.tenrole;
	}

	public void setTenrole(String tenrole) {
		this.tenrole = tenrole;
	}

	public List<Taikhoan> getTaikhoans() {
		return this.taikhoans;
	}

	public void setTaikhoans(List<Taikhoan> taikhoans) {
		this.taikhoans = taikhoans;
	}

	public Taikhoan addTaikhoan(Taikhoan taikhoan) {
		getTaikhoans().add(taikhoan);
		taikhoan.setRole(this);

		return taikhoan;
	}

	public Taikhoan removeTaikhoan(Taikhoan taikhoan) {
		getTaikhoans().remove(taikhoan);
		taikhoan.setRole(null);

		return taikhoan;
	}

}