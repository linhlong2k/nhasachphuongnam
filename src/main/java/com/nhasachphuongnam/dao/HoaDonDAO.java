package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.HoaDon;

public interface HoaDonDAO {
	boolean add(HoaDon hoadon);

	boolean update(HoaDon hoadon);

	boolean delete(HoaDon hoadon);

	HoaDon getByID(String maHD);

	List<HoaDon> getAll();
}
