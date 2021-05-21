package com.nhasachphuongnam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.RoleDAO;
import com.nhasachphuongnam.dao.TaiKhoanDAO;
import com.nhasachphuongnam.entity.Role;
import com.nhasachphuongnam.entity.TaiKhoan;
import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.model.RoleDTO;
import com.nhasachphuongnam.service.LoginService;

@Repository
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired(required = true)
	TaiKhoanDAO taiKhoanDAO;
	
	@Autowired(required = true)
	RoleDAO roleDAO;
	
	//======role=====
	public RoleDTO convert(Role role) {
		RoleDTO roleDTO = new RoleDTO(role.getMaRole(), role.getTenRole());
		return roleDTO;
	}
	
	//=====end-role===
	
	public Login convert(TaiKhoan taiKhoan) {
		Login res = new Login(taiKhoan.getUsername(), taiKhoan.getPassword(), convert(taiKhoan.getRole()));
		return res;
	}
	
	public TaiKhoan convert(Login login) {
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setUsername(login.getUsername());
		taiKhoan.setPassword(login.getPassword());
		taiKhoan.setRole(roleDAO.getByID(login.getRole().getMaRole()));
		return taiKhoan;
	}

	public boolean add(Login login) {
		TaiKhoan taiKhoan = convert(login);
		if(taiKhoanDAO.add(taiKhoan))
			return true;
		return false;
	}
	
	public boolean update(Login login) {
		TaiKhoan taiKhoan = convert(login);
		if(taiKhoanDAO.update(taiKhoan))
			return true;
		return false;
	}
	
	public boolean delete(String ma) {
		if(taiKhoanDAO.delete(ma))
			return true;
		return false;
	}
	
	public Login getByID(String ma) {
		return convert(taiKhoanDAO.getByID(ma));
	}
	
	public List<Login> getAll(){
		List<Login> logins = new ArrayList<Login>();
		List<TaiKhoan> taiKhoans = taiKhoanDAO.getAll();
		for(TaiKhoan i: taiKhoans)
			logins.add(convert(i));
		return logins;
	}
	
	public Boolean checkLogin(Login login) {
		TaiKhoan taiKhoan = taiKhoanDAO.getByID(login.getUsername());
		if(taiKhoan == null)
			return false;
		else if(login.getPassword().equals(taiKhoan.getPassword()))
			return true;
		else return false;
	}
	
	public boolean toAdmin(String username) {
		TaiKhoan taiKhoan = taiKhoanDAO.getByID(username);
		taiKhoan.setRole(roleDAO.getByID("0"));
		if(taiKhoanDAO.update(taiKhoan))
			return true;
		return false;
	}
	
	public boolean toNormal(String username) {
		TaiKhoan taiKhoan = taiKhoanDAO.getByID(username);
		taiKhoan.setRole(roleDAO.getByID("1"));
		if(taiKhoanDAO.update(taiKhoan))
			return true;
		return false;
	}
}
