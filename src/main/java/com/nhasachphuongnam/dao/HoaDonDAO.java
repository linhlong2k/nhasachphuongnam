package com.nhasachphuongnam.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.nhasachphuongnam.entity.HoaDon;

public interface HoaDonDAO {
	
	boolean add(HoaDon hoaDon);

	boolean update(HoaDon hoaDon);

	boolean delete(String ma);

	HoaDon getByID(String ma);

	List<HoaDon> getAll();

	String getLastMa();
	
	List<HoaDon> getBetweenThoiGian(Date start, Date end);
	
	List<HoaDon> getHoaDonByMaKhachHang(String id);
	
	List<HoaDon> getHoaDonByMaNhanVien(String id);
}
