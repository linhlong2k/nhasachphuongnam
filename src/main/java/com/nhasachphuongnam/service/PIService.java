package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.entity.KhachHang;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.model.PersonalInfo;

public interface PIService {
	
	PersonalInfo convert(KhachHang khachHang);
	
	PersonalInfo convert(NhanVien nhanVien);
	
	boolean add(PersonalInfo pi, Login login);
	
	boolean update(PersonalInfo pi);
	
	boolean delete(String ma);
	
	PersonalInfo getByID(String ma);
	
	List<PersonalInfo> getAllCustomer();
	
	List<PersonalInfo> getAllStaff();
	
	boolean updatePhoto(String id, byte[] photo);
}
