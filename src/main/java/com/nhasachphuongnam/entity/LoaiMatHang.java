package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="LoaiMatHang")
/*
 * @NamedQuery(name="LoaiMatHang.findAll", query="SELECT l FROM LoaiMatHang l")
 */
public class LoaiMatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MALOAI")
	private String maLoai;

	@Column(name="TENLOAI")
	private String tenLoai;

	//bi-directional many-to-one association to MatHang
	@OneToMany(mappedBy="loaiMatHang")
	private List<MatHang> matHangs;

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

	public List<MatHang> getMatHangs() {
		return this.matHangs;
	}

	public void setMatHangs(List<MatHang> matHangs) {
		this.matHangs = matHangs;
	}

	public MatHang addMatHang(MatHang matHang) {
		getMatHangs().add(matHang);
		matHang.setLoaiMatHang(this);

		return matHang;
	}

	public MatHang removeMatHang(MatHang matHang) {
		getMatHangs().remove(matHang);
		matHang.setLoaiMatHang(null);

		return matHang;
	}

}