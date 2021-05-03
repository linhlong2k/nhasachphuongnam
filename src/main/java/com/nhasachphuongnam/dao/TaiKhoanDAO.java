package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.TaiKhoan;

public interface TaiKhoanDAO {
	boolean add(TaiKhoan taikhoan);

	boolean update(TaiKhoan taikhoan);

	boolean delete(String maTK);

	TaiKhoan getByID(String maTK);

	List<TaiKhoan> getAll();
}
