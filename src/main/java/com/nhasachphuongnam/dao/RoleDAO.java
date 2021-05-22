package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.Role;

public interface RoleDAO {

	boolean add(Role role);

	boolean update(Role role);

	boolean delete(String maRole);

	Role getByID(String maRole);

	List<Role> getAll();
}

