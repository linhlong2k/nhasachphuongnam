package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.HoaDon;

public interface HoaDonDAO {
	
	boolean add(HoaDon hoaDon);

	boolean update(HoaDon hoaDon);

	boolean delete(String ma);

	HoaDon getByID(String ma);

	List<HoaDon> getAll();
}
