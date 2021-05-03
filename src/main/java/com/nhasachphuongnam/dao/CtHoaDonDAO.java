package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.CTHoaDon;

public interface CtHoaDonDAO {
	boolean add(CTHoaDon cthoadon);

	boolean update(CTHoaDon cthoadon);

	boolean delete(String maCtHD);

	CTHoaDon getByID(String maCtHD);

	List<CTHoaDon> getAll();
}
