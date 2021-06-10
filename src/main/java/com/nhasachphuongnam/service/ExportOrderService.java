package com.nhasachphuongnam.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.nhasachphuongnam.entity.CtHoaDon;
import com.nhasachphuongnam.entity.CtHoaDonPK;
import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.entity.KhachHang;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.ProductDetail;

public interface ExportOrderService {
	
	String theNextMa();
	
	ExportOrder convert(HoaDon var);

	HoaDon convert(ExportOrder var);
	
	String add(ExportOrder var);
	
	boolean update(ExportOrder var);
	
	boolean delete(String ma);
	
	ExportOrder getByID(String ma);
	
	List<ExportOrder> getAll();
}
