package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.NhanVien;

public interface NhanVienDAO {
	boolean add(NhanVien nhanvien);

	boolean update(NhanVien nhanvien);

	boolean delete(String maNV);

	NhanVien getByID(String maNV);

	List<NhanVien> getAll();
	
	String getLastMa();
	
	String getMaByUsername(String username);
}
