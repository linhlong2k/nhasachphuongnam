package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.LoaiMatHang;

public interface LoaiMatHangDAO {
	boolean add(LoaiMatHang loai);

	boolean update(LoaiMatHang loai);

	boolean delete(String maLoai);

	LoaiMatHang getByID(String maLoai);

	List<LoaiMatHang> getAll();
	
	String getLastMa();
	/*
	 * public boolean addLoaiMatHang(String maLoai, String tenLoai);
	 * 
	 * public boolean updateLoaiMatHang(String maLoai, String tenLoai);
	 * 
	 * public boolean deleteLoaiMatHang(String maLoai);
	 * 
	 * public String getTenLoaiMatHangByID(String maLoai);
	 * 
	 * public LoaiMatHang getLoaiMatHangByID(String maloai);
	 * 
	 * public Map<String, String> getAllLoaiMatHang();
	 */
}
