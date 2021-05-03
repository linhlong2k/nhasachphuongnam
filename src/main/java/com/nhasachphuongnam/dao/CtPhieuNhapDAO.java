package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.CTPhieuNhap;

public interface CtPhieuNhapDAO {
	boolean add(CTPhieuNhap ctphieunhap);

	boolean update(CTPhieuNhap ctphieunhap);

	boolean delete(String maCtPN);

	CTPhieuNhap getByID(String maCtPN);

	List<CTPhieuNhap> getAll();
}
