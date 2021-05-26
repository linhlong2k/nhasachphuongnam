package com.nhasachphuongnam.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nhasachphuongnam.model.RoleDTO;
import com.nhasachphuongnam.service.RoleService;

@ControllerAdvice
public class RoleModelAttribute {
	@Autowired(required = true)
	RoleService roleService;
	
	@ModelAttribute("roles")
	public List<RoleDTO> getAll(){
		List<RoleDTO> res = roleService.getAll();
		return res;
	}
}
