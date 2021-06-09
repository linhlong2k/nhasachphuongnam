package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.CtHoaDon;

public interface CtHoaDonDAO {

	boolean add(CtHoaDon cthoadon);

	boolean update(CtHoaDon cthoadon);

	boolean delete(String maCtHD);

	CtHoaDon getByID(String maCtHD);

	List<CtHoaDon> getAll();

	List<CtHoaDon> getbyMaHD(String ma);
}
