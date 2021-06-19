package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="NhaCungCap")
/* @NamedQuery(name="NhaCungCap.findAll", query="SELECT n FROM NhaCungCap n") */
public class NhaCungCap implements Serializable {
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

	//bi-directional many-to-one association to PhieuNhap
	@OneToMany(mappedBy="nhaCungCap")
	private List<PhieuNhap> phieuNhaps;

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

	public List<PhieuNhap> getPhieuNhaps() {
		return this.phieuNhaps;
	}

	public void setPhieuNhaps(List<PhieuNhap> phieuNhaps) {
		this.phieuNhaps = phieuNhaps;
	}

	public PhieuNhap addPhieuNhap(PhieuNhap phieuNhap) {
		getPhieuNhaps().add(phieuNhap);
		phieuNhap.setNhaCungCap(this);

		return phieuNhap;
	}

	public PhieuNhap removePhieuNhap(PhieuNhap phieuNhap) {
		getPhieuNhaps().remove(phieuNhap);
		phieuNhap.setNhaCungCap(null);

		return phieuNhap;
	}

}