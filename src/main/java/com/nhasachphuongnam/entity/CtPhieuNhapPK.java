package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CtPhieuNhapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAMH", insertable=false, updatable=false)
	private String mamh;

	@Column(name="MAPN", insertable=false, updatable=false)
	private String mapn;

	public CtPhieuNhapPK() {
	}
	public String getMamh() {
		return this.mamh;
	}
	public void setMamh(String mamh) {
		this.mamh = mamh;
	}
	public String getMapn() {
		return this.mapn;
	}
	public void setMapn(String mapn) {
		this.mapn = mapn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtPhieuNhapPK)) {
			return false;
		}
		CtPhieuNhapPK castOther = (CtPhieuNhapPK)other;
		return 
			this.mamh.equals(castOther.mamh)
			&& this.mapn.equals(castOther.mapn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mamh.hashCode();
		hash = hash * prime + this.mapn.hashCode();
		
		return hash;
	}
}