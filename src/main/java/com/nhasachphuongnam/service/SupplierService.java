package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.entity.NhaCungCap;
import com.nhasachphuongnam.model.Supplier;

public interface SupplierService {
	
	Supplier convert(NhaCungCap nhaCungCap);
	
	NhaCungCap convert(Supplier supplier);
	
	boolean add(Supplier supplier);
	
	boolean update(Supplier Supplier);
	
	boolean delete(String ma);
	
	Supplier getByID(String ma);
	
	List<Supplier> getAll();
}
