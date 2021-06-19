package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CtHoaDonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAHD", insertable=false, updatable=false)
	private String maHD;

	@Column(name="MAMH", insertable=false, updatable=false)
	private String maMH;

	public CtHoaDonPK() {
	}
	public String getMaHD() {
		return this.maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaMH() {
		return this.maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtHoaDonPK)) {
			return false;
		}
		CtHoaDonPK castOther = (CtHoaDonPK)other;
		return 
			this.maHD.equals(castOther.maHD)
			&& this.maMH.equals(castOther.maMH);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maHD.hashCode();
		hash = hash * prime + this.maMH.hashCode();
		
		return hash;
	}
}