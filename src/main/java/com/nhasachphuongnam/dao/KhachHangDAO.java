package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.KhachHang;

public interface KhachHangDAO {
	boolean add(KhachHang khachhang);

	boolean update(KhachHang khachhang);

	boolean delete(String maKH);

	KhachHang getByID(String maKH);

	List<KhachHang> getAll();
	
	String getLastMa();
	
	String getMaByUsername(String username);
	
}
