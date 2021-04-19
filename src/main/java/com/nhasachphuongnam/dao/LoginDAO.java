package com.nhasachphuongnam.dao;

import com.nhasachphuongnam.entity.Taikhoan;

public interface LoginDAO {
	public Boolean checkLogin(Taikhoan taiKhoan);
	
	public Taikhoan getPasswordByUsername(String username);
}
