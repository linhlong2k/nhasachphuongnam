
package com.nhasachphuongnam.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<RoleDTO> getAll(){
		List<RoleDTO> roleList = new ArrayList<RoleDTO>();
		List<Role> roles = roleDAO.getAll();
		for(Role i: roles) {
			RoleDTO temp = new RoleDTO();
			temp.setMaRole(i.getMaRole());
			temp.setTenRole(i.getTenRole());
			roleList.add(temp);
		}
		return roleList;
	}
}
