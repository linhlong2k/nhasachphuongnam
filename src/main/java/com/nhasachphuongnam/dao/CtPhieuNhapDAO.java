package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.CtPhieuNhap;

public interface CtPhieuNhapDAO {

	boolean add(CtPhieuNhap ctphieunhap);

	boolean update(CtPhieuNhap ctphieunhap);

	boolean delete(String maCtPN);

	CtPhieuNhap getByID(String maCtPN);

	List<CtPhieuNhap> getAll();

	List<CtPhieuNhap> getbyMaPN(String ma);
}
