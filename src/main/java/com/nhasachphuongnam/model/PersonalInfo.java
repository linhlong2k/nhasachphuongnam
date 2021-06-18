package com.nhasachphuongnam.model;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class PersonalInfo {
	private String ma;
	@NotNull(message = "Tên không được để trống")
	@Size(min = 1,max = 50, message = "Tên không được quá dài hoặc quá ngắn")
	private String ten;
	private byte[] hinhAnh;
	@NotEmpty(message = "Địa chỉ không được để trống")
	private String diaChi;
	/*
	 * @NotEmpty(message = "Ngày sinh không được để trống")
	 * 
	 * @NotNull(message = "Ngày sinh không được để trống")
	 * 
	 * @Past(message = "Ngày sinh phải là ngày trong quá khứ")
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate ngaySinh;
	private String soDienThoai;
	@NotEmpty(message = "Tên đăng nhập không được để trống")
	@Size(max = 25, message = "Tên đăng nhập không được quá dài")
	private String username;
	private String maRole;

	public PersonalInfo() {
		super();
	}
	
	public PersonalInfo(String ten, byte[] hinhAnh, String diaChi, Date ngaySinh, String soDienThoai, String username,
			String maRole) {
		super();
		this.ten = ten;
		this.hinhAnh = hinhAnh;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.soDienThoai = soDienThoai;
		this.username = username;
		this.maRole = maRole;
	}

	public PersonalInfo(String ma, String ten, byte[] hinhAnh, String diaChi, Date ngaySinh, String soDienThoai,
			String username, String maRole) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.hinhAnh = hinhAnh;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.soDienThoai = soDienThoai;
		this.username = username;
		this.maRole = maRole;
	}
	
	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMaRole() {
		return maRole;
	}

	public void setMaRole(String maRole) {
		this.maRole = maRole;
	}

	/* =============================advanced=========================== */

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public String getBase64Photo() {
		String base64DataString = null;
		if (hinhAnh != null) {                
			byte[] encode = java.util.Base64.getEncoder().encode(this.getHinhAnh());
            try {
				base64DataString =  new String(encode, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return base64DataString;
	}
}
