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

import com.nhasachphuongnam.dao.TaiKhoanDAO;
import com.nhasachphuongnam.entity.TaiKhoan;

@Repository
@Transactional
public class TaiKhoanDAOImpl implements TaiKhoanDAO{
	@Autowired
	SessionFactory factory;

	public boolean add(TaiKhoan taiKhoan) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(taiKhoan);
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

	public boolean update(TaiKhoan taiKhoan) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(taiKhoan);
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
		TaiKhoan taiKhoan = (TaiKhoan) session.get(TaiKhoan.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			session.delete(taiKhoan);
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

	public TaiKhoan getByID(String ma) {
		TaiKhoan taiKhoan = null;
		Session session = factory.openSession();
		try {
			taiKhoan = (TaiKhoan) session.get(TaiKhoan.class, ma);
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return taiKhoan;
	}
	
	@SuppressWarnings("unchecked")
	public List<TaiKhoan> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(TaiKhoan.class);
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
