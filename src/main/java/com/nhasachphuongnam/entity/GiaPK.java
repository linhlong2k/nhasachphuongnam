package com.nhasachphuongnam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The primary key class for the GIA database table.
 * 
 */
@Embeddable
public class GiaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAMH", insertable=false, updatable=false)
	private String mamh;

	@Column(name="THOIGIAN")
	private Date thoigian;

	public GiaPK() {
	}
	public String getMamh() {
		return this.mamh;
	}
	public void setMamh(String mamh) {
		this.mamh = mamh;
	}
	public Date getThoigian() {
		return this.thoigian;
	}
	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GiaPK)) {
			return false;
		}
		GiaPK castOther = (GiaPK)other;
		return 
			this.mamh.equals(castOther.mamh)
			&& this.thoigian.equals(castOther.thoigian);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mamh.hashCode();
		hash = hash * prime + this.thoigian.hashCode();
		
		return hash;
	}
}