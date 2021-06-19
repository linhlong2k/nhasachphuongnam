package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CtPhieuNhapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAMH", insertable=false, updatable=false)
	private String maMH;

	@Column(name="MAPN", insertable=false, updatable=false)
	private String maPN;

	public CtPhieuNhapPK() {
	}
	public String getMaMH() {
		return this.maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getMaPN() {
		return this.maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
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
			this.maMH.equals(castOther.maMH)
			&& this.maPN.equals(castOther.maPN);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maMH.hashCode();
		hash = hash * prime + this.maPN.hashCode();
		
		return hash;
	}
}