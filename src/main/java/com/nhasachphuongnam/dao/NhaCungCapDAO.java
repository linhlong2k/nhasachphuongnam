package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.NhaCungCap;

public interface NhaCungCapDAO {
	
	boolean add(NhaCungCap ncc);

	boolean update(NhaCungCap ncc);

	boolean delete(String maNCC);

	NhaCungCap getByID(String maNCC);

	String getLastMa();
	
	List<NhaCungCap> getAll();
}
