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

	public boolean add(HoaDon hoaDon) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(hoaDon);
			for(CtHoaDon i: hoaDon.getCtHoadons()) {
				session.save(i);
			}
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
	public String getLastMa() {
		String sql = "SELECT top 1 MAHD FROM HOADON ORDER BY MAHD DESC";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		return results.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<HoaDon> getBetweenThoiGian(Date start, Date end) {
		Criteria cr = factory.getCurrentSession().createCriteria(HoaDon.class);
		cr.add(Restrictions.between("thoiGian", start, end));
		cr.add(Restrictions.eq("tinhtrang", "3"));
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
