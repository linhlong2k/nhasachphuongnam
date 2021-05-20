package com.nhasachphuongnam.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.HoaDonDAO;
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
		/*
		 * if(ctHoaDon == null) return false;
		 */
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
		return (HoaDon) factory.getCurrentSession().get(HoaDon.class, ma);
	}
	
	public List<HoaDon> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(HoaDon.class);
		return cr.list();
	}
	
	/*
	 * ===================================advanced==================================
	 */
	
	public String getby() {
		String sql = "";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);

		@SuppressWarnings("unchecked")
		List<String> results = (List<String>) query.list();
		return results.get(0);
	}
}
