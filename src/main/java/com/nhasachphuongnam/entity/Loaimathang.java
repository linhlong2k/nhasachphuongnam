package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOAIMATHANG database table.
 * 
 */
@Entity
@Table(name="LOAIMATHANG")
public class Loaimathang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MALOAI")
	private String maloai;

	@Column(name="TENLOAI")
	private String tenloai;

	//bi-directional many-to-one association to Mathang
	@OneToMany(mappedBy="loaimathang")
	private List<Mathang> mathangs;

	public Loaimathang() {
	}

	public String getMaloai() {
		return this.maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getTenloai() {
		return this.tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public List<Mathang> getMathangs() {
		return this.mathangs;
	}

	public void setMathangs(List<Mathang> mathangs) {
		this.mathangs = mathangs;
	}

	public Mathang addMathang(Mathang mathang) {
		getMathangs().add(mathang);
		mathang.setLoaimathang(this);

		return mathang;
	}

	public Mathang removeMathang(Mathang mathang) {
		getMathangs().remove(mathang);
		mathang.setLoaimathang(null);

		return mathang;
	}

}