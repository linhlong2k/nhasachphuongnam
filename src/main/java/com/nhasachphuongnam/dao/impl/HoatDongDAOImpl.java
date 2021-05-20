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

import com.nhasachphuongnam.dao.HoatDongDAO;
import com.nhasachphuongnam.entity.HoatDong;

@Repository
@Transactional
public class HoatDongDAOImpl implements HoatDongDAO{
	@Autowired
	SessionFactory factory;

	public boolean add(HoatDong hoatDong) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(hoatDong);
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

	public boolean update(HoatDong hoatDong) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(hoatDong);
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
		HoatDong hoatDong = (HoatDong) session.get(HoatDong.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			session.delete(hoatDong);
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

	public HoatDong getByID(String ma) {
		return (HoatDong) factory.getCurrentSession().get(HoatDong.class, ma);
	}
	
	@SuppressWarnings("unchecked")
	public List<HoatDong> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(HoatDong.class);
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
