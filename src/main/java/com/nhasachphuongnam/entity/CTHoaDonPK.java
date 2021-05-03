package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CT_HOADON database table.
 * 
 */
@Embeddable
public class CTHoaDonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAHD", insertable=false, updatable=false)
	private String mahd;

	@Column(name="MAMH", insertable=false, updatable=false)
	private String mamh;

	public CTHoaDonPK() {
	}
	public String getMahd() {
		return this.mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMamh() {
		return this.mamh;
	}
	public void setMamh(String mamh) {
		this.mamh = mamh;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CTHoaDonPK)) {
			return false;
		}
		CTHoaDonPK castOther = (CTHoaDonPK)other;
		return 
			this.mahd.equals(castOther.mahd)
			&& this.mamh.equals(castOther.mamh);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mahd.hashCode();
		hash = hash * prime + this.mamh.hashCode();
		
		return hash;
	}
}