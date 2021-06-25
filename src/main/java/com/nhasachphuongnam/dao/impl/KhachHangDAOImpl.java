package com.nhasachphuongnam.dao.impl;

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

import com.nhasachphuongnam.dao.KhachHangDAO;
import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.entity.KhachHang;

@Repository
@Transactional
public class KhachHangDAOImpl implements KhachHangDAO{
	@Autowired
	SessionFactory factory;

	public boolean add(KhachHang khachHang) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(khachHang.getTaiKhoan());
			session.save(khachHang);
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

	public boolean update(KhachHang khachHang) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(khachHang);
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
		KhachHang khachHang = (KhachHang) session.get(KhachHang.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			Criteria cr = session.createCriteria(HoaDon.class);
			cr.add(Restrictions.eq("khachHang.maKH", khachHang.getMaKH()));
			@SuppressWarnings("unchecked")
			List<HoaDon> hoaDons = cr.list();
			if(hoaDons != null) {
				for(HoaDon i: hoaDons) {
					i.setKhachHang(null);
					session.save(i);
				}
			}
			session.delete(khachHang);
			session.delete(khachHang.getTaiKhoan());
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

	public KhachHang getByID(String ma) {
		KhachHang khachHang = null;
		Session session = factory.openSession();
		try {
			khachHang = (KhachHang) session.get(KhachHang.class, ma);
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return khachHang;
	}
	
	@SuppressWarnings("unchecked")
	public List<KhachHang> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(KhachHang.class);
		return cr.list();
	}
	
	/*
	 * ===================================advanced==================================
	 */
	public String getLastMa() {
		String sql = "SELECT top 1 MAKH FROM KHACHHANG ORDER BY MAKH DESC";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		if(results.size() == 0) {
			return null;
		}
		return results.get(0);
	}
	
	public String getMaByUsername(String username) {
		String sql = "SELECT MAKH FROM KHACHHANG WHERE KHACHHANG.USERNAME='" + username +"'";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		return results.get(0);
	}
}
