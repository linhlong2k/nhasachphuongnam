package com.nhasachphuongnam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.RoleDAO;
import com.nhasachphuongnam.entity.Role;
import com.nhasachphuongnam.model.RoleDTO;
import com.nhasachphuongnam.service.RoleService;

@Repository
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired(required = true)
	RoleDAO roleDAO;
	
	public RoleDTO getByID(String ma) {
		Role role = roleDAO.getByID(ma);
		if(role == null)
			return null;
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setMaRole(ma);
		roleDTO.setTenRole(role.getTenRole());
		return roleDTO;
	}
}
