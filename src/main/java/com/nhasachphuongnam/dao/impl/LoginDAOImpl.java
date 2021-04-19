package com.nhasachphuongnam.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nhasachphuongnam.dao.LoginDAO;
import com.nhasachphuongnam.entity.Product;
import com.nhasachphuongnam.entity.Taikhoan;

public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	SessionFactory factory;
	
	public Boolean checkLogin(Taikhoan taikhoan) {
		if(taikhoan.getPassword().equals(getPasswordByUsername(taikhoan.getUsername())))
			return true;
		return false;
	}
	
	public Taikhoan getPasswordByUsername(String username) {
		return (Taikhoan) factory.getCurrentSession().get(Taikhoan.class, username);
	}
}
