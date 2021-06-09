package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.MatHang;

public interface MatHangDAO {

	boolean add(MatHang mathang);

	boolean update(MatHang mathang);

	boolean delete(String maMH);

	MatHang getByID(String maMH);

	List<MatHang> getAll();
	
	String getLastMa();
	
	boolean changeSoLuong(String ma, int n);

}
