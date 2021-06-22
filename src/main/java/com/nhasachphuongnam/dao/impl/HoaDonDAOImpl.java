package com.nhasachphuongnam.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.HoaDonDAO;
import com.nhasachphuongnam.entity.CtHoaDon;
import com.nhasachphuongnam.entity.HoaDon;

@Repository
@Transactional
public class HoaDonDAOImpl implements HoaDonDAO {
	
	@Autowired
	SessionFactory factory;
	
	//thêm đơn hàng xuất mới
	public boolean add(HoaDon hoaDon) {
		boolean flag = true;	//biến kiểm tra việc thêm có thành công hay không
		Session session = factory.openSession();	//tạo phiên làm việc mới với database
		Transaction tran = session.beginTransaction();	//tạo transaction mới để lưu lại thông tin và rollback khi cần thiết
		try {
			session.save(hoaDon);	//lưu đơn hàng mới
			for(CtHoaDon i: hoaDon.getCtHoaDons()) {	
				session.save(i);	//lưu từng mặt hàng của đơn hàng mới vào trong table CT_HOADON	
			}
			tran.commit();
		} catch(HibernateException ex) {
			tran.rollback();	//nếu không thêm thành công thì trả lại thông tin trước đó trên database
			ex.printStackTrace();	//in thông tin lỗi
			flag = false;	//thêm đơn hàng không thành công
		} finally {
			session.close();	//Đóng phiên làm việc với database
		}
		return flag;
	}

	public boolean update(HoaDon hoaDon) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(hoaDon);
			tran.commit();
		} catch(HibernateException ex) {
			tran.rollback();
			ex.printStackTrace();
			flag = false;
		} finally {
			session.close();
		}
		return flag;
	}

	public boolean delete(String ma) {
		boolean flag = true;
		Session session = null;
		session = factory.openSession();
		Transaction tran = session.beginTransaction();
		HoaDon hoaDon = (HoaDon) session.get(HoaDon.class, ma);
		if(hoaDon == null) {
			return false;
		}
		try {
			session.delete(hoaDon);
			tran.commit();
		} catch(HibernateException ex) {
			tran.rollback();
			ex.printStackTrace();
			flag = false;
		} finally {
			session.close();
		}
		return flag;
	}

	public HoaDon getByID(String ma) {
		HoaDon hoaDon = null;
		Session session = factory.openSession();
		try {
			hoaDon = (HoaDon) session.get(HoaDon.class, ma);
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return hoaDon;
	}
	
	@SuppressWarnings("unchecked")
	public List<HoaDon> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(HoaDon.class);
		return cr.list();
	}
	
	/*
	 * ===================================advanced==================================
	 */
	//Lấy mã đơn hàng của đơn hàng cuối danh sách, dùng để tạo mã đơn hàng mới
	public String getLastMa() {
		String sql = "SELECT top 1 MAHD FROM HoaDon ORDER BY MAHD DESC";	//câu lênh query sqlServer tìm ra mã đơn hàng của đơn hàng cuối cùng trong table HOADON
		Session session = factory.getCurrentSession();	//Mở 1 phiên làm việc mới với database (đây là dạng phiên làm việc tự động đóng)
		SQLQuery query = session.createSQLQuery(sql);	//Thực hiện truy vấn với câu lệnh query được tạo trước đó
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();	//Lấy thông tin trả về sau khi truy vấn
		if(results == null) {
			return null;	//Kiểm tra null
		}
		return results.get(0);	//trả về mã đơn hàng của đơn hàng cuối danh sách
	}
	
//Lấy danh sách đơn hàng trong khoản thời gian input
@SuppressWarnings("unchecked")
public List<HoaDon> getBetweenThoiGian(Date start, Date end) {
	Criteria cr = factory.getCurrentSession().createCriteria(HoaDon.class);		//dùng criteria truy vấn table HOADON
	cr.add(Restrictions.between("thoiGian", start, end));	//lọc đơn hàng trong khoảng thời gian start, end
	cr.add(Restrictions.eq("tinhTrang", "3"));	//lọc nhưng đơn hàng đã hoàn thành
	if(cr.list() == null) {
		return null;	//Kiểm tra null
	}
	return cr.list();	//trả về danh sách đơn hàng đã hoàn thành trong khoản thời gian
}
	
	@SuppressWarnings("unchecked")
	public List<HoaDon> getHoaDonByMaKhachHang(String id){
		Criteria cr = factory.getCurrentSession().createCriteria(HoaDon.class);
		cr.add(Restrictions.eq("khachHang.maKH", id));
		
		return cr.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<HoaDon> getHoaDonByMaNhanVien(String id){
		Criteria cr = factory.getCurrentSession().createCriteria(HoaDon.class);
		cr.add(Restrictions.eq("nhanVien.maNV", id));
		
		return cr.list();
	}
	
	public String getby() {
		String sql = "";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);

		@SuppressWarnings("unchecked")
		List<String> results = (List<String>) query.list();
		return results.get(0);
	}
}
