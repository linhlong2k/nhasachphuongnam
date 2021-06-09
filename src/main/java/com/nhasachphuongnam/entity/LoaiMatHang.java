package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="LOAIMATHANG")
/*
 * @NamedQuery(name="Loaimathang.findAll", query="SELECT l FROM Loaimathang l")
 */
public class LoaiMatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MALOAI")
	private String maLoai;

	@Column(name="TENLOAI")
	private String tenLoai;

	//bi-directional many-to-one association to Mathang
	@OneToMany(mappedBy="loaimathang")
	private List<MatHang> mathangs;

	public LoaiMatHang() {
	}

	public String getMaLoai() {
		return this.maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return this.tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<MatHang> getMathangs() {
		return this.mathangs;
	}

	public void setMathangs(List<MatHang> mathangs) {
		this.mathangs = mathangs;
	}

	public MatHang addMathang(MatHang mathang) {
		getMathangs().add(mathang);
		mathang.setLoaimathang(this);

		return mathang;
	}

	public MatHang removeMathang(MatHang mathang) {
		getMathangs().remove(mathang);
		mathang.setLoaimathang(null);

		return mathang;
	}

}