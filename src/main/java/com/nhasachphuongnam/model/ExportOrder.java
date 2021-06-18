package com.nhasachphuongnam.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ExportOrder {

	private String maDonHang;
	// định dạng lưu trữ: mã mặt hàng:tên mặt hàng:số lượng:giá tiền
	private List<ProductDetail> chiTiets;
	/*
	 * @NotEmpty(message = "Thời gian không được để trống")
	 * 
	 * @NotNull(message = "Thời gian không được để trống")
	 */
	//không thể dùng annonitation @PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate thoiGian;
	private String maNhanVien;
	private String maKhachHang;
	@NotEmpty(message = "Địa chỉ không được để trống")
	@NotNull(message = "Địa chỉ không được để trống")
	private String diaChi;
	private String sdt;
	private Float giamGia;
	private String tinhTrang;

	public ExportOrder() {
		super();
	}

	public ExportOrder(List<ProductDetail> chiTiets, LocalDate thoiGian, String maNhanVien, String maKhachHang,
			String diaChi, String sdt, Float giamGia, String tinhTrang) {
		super();
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.giamGia = giamGia;
		this.tinhTrang = tinhTrang;
	}

	public ExportOrder(String maDonHang, List<ProductDetail> chiTiets, LocalDate thoiGian, String maNhanVien,
			String maKhachHang, String diaChi, String sdt, Float giamGia, String tinhTrang) {
		super();
		this.maDonHang = maDonHang;
		this.chiTiets = chiTiets;
		this.thoiGian = thoiGian;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.giamGia = giamGia;
		this.tinhTrang = tinhTrang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public List<ProductDetail> getChiTiets() {
		return chiTiets;
	}

	public void setChiTiets(List<ProductDetail> chiTiets) {
		this.chiTiets = chiTiets;
	}

	public LocalDate getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(LocalDate thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Float getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(Float giamGia) {
		this.giamGia = giamGia;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}