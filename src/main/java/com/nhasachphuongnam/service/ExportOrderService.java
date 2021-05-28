package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.model.ExportOrder;

public interface ExportOrderService {
	
	ExportOrder convert(HoaDon var) ;
	
	boolean add(ExportOrder var) ;
	
	boolean update(ExportOrder var) ;
	
	boolean delete(String ma) ;
	
	ExportOrder getByID(String ma);
	
	List<ExportOrder> getAll() ;
}
