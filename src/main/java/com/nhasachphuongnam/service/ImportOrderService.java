package com.nhasachphuongnam.service;

import java.time.LocalDate;
import java.util.List;

import com.nhasachphuongnam.entity.PhieuNhap;
import com.nhasachphuongnam.model.ImportOrder;

public interface ImportOrderService {
	
	ImportOrder convert(PhieuNhap var) ;
	
	String add(ImportOrder var) ;
	
	boolean update(ImportOrder var) ;
	
	boolean delete(String ma) ;
	
	ImportOrder getByID(String ma);
	
	List<ImportOrder> getAll() ;
	
	List<ImportOrder> getAllBetweenDate(LocalDate start, LocalDate end);
}
