package com.nhasachphuongnam.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.Product;

public interface ExportOrderService {
	
	String theNextMa();
	
	ExportOrder convert(HoaDon var);

	HoaDon convert(ExportOrder var);
	
	String add(ExportOrder var);
	
	boolean update(ExportOrder var);
	
	boolean delete(String ma);
	
	ExportOrder getByID(String ma);
	
	List<ExportOrder> getAll();
	
	List<ExportOrder> GetAllByMaKH(String id);
	
	List<ExportOrder> getAllByMaNV(String id);
	
	List<ExportOrder> GetAllBetweenDate(LocalDate start, LocalDate end);
	
	List<ExportOrder> getDanhSachDatHang();
	
	List<Product> getDanhSachMatHangByMaHD(String ma);
	
	List<ExportOrder> getDanhSachGiaoHang();
	
	String xacNhanDatHang(String ma, String maNhanVien);
	
	String xacNhanNhanHang(String ma);
	
}
