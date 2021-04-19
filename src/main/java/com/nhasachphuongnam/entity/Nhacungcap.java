package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the NHACUNGCAP database table.
 * 
 */
@Entity
@Table(name="NHACUNGCAP")
public class Nhacungcap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MANCC")
	private String mancc;

	@Column(name="DIACHI")
	private String diachi;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENNCC")
	private String tenncc;

	//bi-directional many-to-one association to Phieunhap
	@OneToMany(mappedBy="nhacungcap")
	private List<Phieunhap> phieunhaps;

	public Nhacungcap() {
	}

	public String getMancc() {
		return this.mancc;
	}

	public void setMancc(String mancc) {
		this.mancc = mancc;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTenncc() {
		return this.tenncc;
	}

	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}

	public List<Phieunhap> getPhieunhaps() {
		return this.phieunhaps;
	}

	public void setPhieunhaps(List<Phieunhap> phieunhaps) {
		this.phieunhaps = phieunhaps;
	}

	public Phieunhap addPhieunhap(Phieunhap phieunhap) {
		getPhieunhaps().add(phieunhap);
		phieunhap.setNhacungcap(this);

		return phieunhap;
	}

	public Phieunhap removePhieunhap(Phieunhap phieunhap) {
		getPhieunhaps().remove(phieunhap);
		phieunhap.setNhacungcap(null);

		return phieunhap;
	}

}