package com.nhasachphuongnam.dao;

import java.util.Date;
import java.util.List;

import com.nhasachphuongnam.entity.PhieuNhap;

public interface PhieuNhapDAO {

	boolean add(PhieuNhap phieunhap);

	boolean update(PhieuNhap phieunhap);

	boolean delete(String maPN);

	PhieuNhap getByID(String maPN);

	List<PhieuNhap> getAll();

	String getLastMa();
	
	List<PhieuNhap> getBetweenThoiGian(Date start, Date end);
}
