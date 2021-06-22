package com.nhasachphuongnam.dao;

import java.util.Date;
import java.util.List;

import com.nhasachphuongnam.entity.HoaDon;

public interface HoaDonDAO {
	
	boolean add(HoaDon hoaDon);		//thêm hóa đơn mới vào database

	boolean update(HoaDon hoaDon);		//Cập nhập thông tin mới của đơn hàng vào database

	boolean delete(String ma);		//Xóa đơn hàng theo mã đơn hàng

	HoaDon getByID(String ma);		//Tìm đơn hàng theo mã đơn hàng

	List<HoaDon> getAll();		//Lấy toàn bộ đơn hàng trên database

	String getLastMa();		//Lấy mã đơn hàng của đơn hàng cuối danh sách, dùng để tạo mã đơn hàng mới
	
	List<HoaDon> getBetweenThoiGian(Date start, Date end);		//Lấy danh sách đơn hàng trong khoản thời gian input
	
	List<HoaDon> getHoaDonByMaKhachHang(String id);		//Lấy danh sách đơn hàng của khách hàng
	
	List<HoaDon> getHoaDonByMaNhanVien(String id);		//lấy danh sách đơn hàng thuộc phụ trách của nhân viên
}
