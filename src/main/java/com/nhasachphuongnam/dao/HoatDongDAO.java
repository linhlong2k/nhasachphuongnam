package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.HoatDong;

public interface HoatDongDAO {
	boolean add(HoatDong hoatdong);

	boolean update(HoatDong hoatdong);

	boolean delete(String maHDTK);

	HoatDong getByID(String maHDTK);

	List<HoatDong> getAll();
}
