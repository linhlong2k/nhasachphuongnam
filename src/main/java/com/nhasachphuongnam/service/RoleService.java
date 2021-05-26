package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.model.RoleDTO;

public interface RoleService {
	
	RoleDTO getByID(String ma);
	
	List<RoleDTO> getAll();
}
