package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MATHANG database table.
 * 
 */
@Entity
@Table(name="MATHANG")
public class Mathang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAMH")
	private String mamh;

	@Column(name="HINHANH")
	private String hinhanh;

	@Column(name="MOTA")
	private String mota;

	@Column(name="MOTANGAN")
	private String motangan;

	@Column(name="SOLUONG")
	private int soluong;

	@Column(name="TENMH")
	private String tenmh;

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="mathang")
	private List<CtHoadon> ctHoadons;

	//bi-directional many-to-one association to CtPhieunhap
	@OneToMany(mappedBy="mathang")
	private List<CtPhieunhap> ctPhieunhaps;

	//bi-directional many-to-one association to Danhgia
	@OneToMany(mappedBy="mathang")
	private List<Danhgia> danhgias;

	//bi-directional many-to-one association to Gia
	@OneToMany(mappedBy="mathang")
	private List<Gia> gias;

	//bi-directional many-to-one association to Loaimathang
	@ManyToOne
	@JoinColumn(name="MALOAI")
	private Loaimathang loaimathang;

	public Mathang() {
	}

	public String getMamh() {
		return this.mamh;
	}

	public void setMamh(String mamh) {
		this.mamh = mamh;
	}

	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getMotangan() {
		return this.motangan;
	}

	public void setMotangan(String motangan) {
		this.motangan = motangan;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getTenmh() {
		return this.tenmh;
	}

	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}

	public List<CtHoadon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<CtHoadon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public CtHoadon addCtHoadon(CtHoadon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setMathang(this);

		return ctHoadon;
	}

	public CtHoadon removeCtHoadon(CtHoadon ctHoadon) {
		getCtHoadons().remove(ctHoadon);
		ctHoadon.setMathang(null);

		return ctHoadon;
	}

	public List<CtPhieunhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(List<CtPhieunhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

	public CtPhieunhap addCtPhieunhap(CtPhieunhap ctPhieunhap) {
		getCtPhieunhaps().add(ctPhieunhap);
		ctPhieunhap.setMathang(this);

		return ctPhieunhap;
	}

	public CtPhieunhap removeCtPhieunhap(CtPhieunhap ctPhieunhap) {
		getCtPhieunhaps().remove(ctPhieunhap);
		ctPhieunhap.setMathang(null);

		return ctPhieunhap;
	}

	public List<Danhgia> getDanhgias() {
		return this.danhgias;
	}

	public void setDanhgias(List<Danhgia> danhgias) {
		this.danhgias = danhgias;
	}

	public Danhgia addDanhgia(Danhgia danhgia) {
		getDanhgias().add(danhgia);
		danhgia.setMathang(this);

		return danhgia;
	}

	public Danhgia removeDanhgia(Danhgia danhgia) {
		getDanhgias().remove(danhgia);
		danhgia.setMathang(null);

		return danhgia;
	}

	public List<Gia> getGias() {
		return this.gias;
	}

	public void setGias(List<Gia> gias) {
		this.gias = gias;
	}

	public Gia addGia(Gia gia) {
		getGias().add(gia);
		gia.setMathang(this);

		return gia;
	}

	public Gia removeGia(Gia gia) {
		getGias().remove(gia);
		gia.setMathang(null);

		return gia;
	}

	public Loaimathang getLoaimathang() {
		return this.loaimathang;
	}

	public void setLoaimathang(Loaimathang loaimathang) {
		this.loaimathang = loaimathang;
	}

}