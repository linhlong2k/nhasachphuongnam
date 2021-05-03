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
public class NhaCungCap  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MANCC")
	private String maNCC;

	@Column(name="DIACHI")
	private String diaChi;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TENNCC")
	private String tenNCC;

	//bi-directional many-to-one association to Phieunhap
	@OneToMany(mappedBy="nhacungcap")
	private List<PhieuNhap> phieunhaps;

	public NhaCungCap() {
	}

	public String getMaNCC() {
		return this.maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTenNCC() {
		return this.tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public List<PhieuNhap> getPhieunhaps() {
		return this.phieunhaps;
	}

	public void setPhieunhaps(List<PhieuNhap> phieunhaps) {
		this.phieunhaps = phieunhaps;
	}

	public PhieuNhap addPhieunhap(PhieuNhap phieunhap) {
		getPhieunhaps().add(phieunhap);
		phieunhap.setNhacungcap(this);

		return phieunhap;
	}

	public PhieuNhap removePhieunhap(PhieuNhap phieunhap) {
		getPhieunhaps().remove(phieunhap);
		phieunhap.setNhacungcap(null);

		return phieunhap;
	}

}