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

import com.nhasachphuongnam.dao.NhaCungCapDAO;
import com.nhasachphuongnam.entity.NhaCungCap;

@Repository
@Transactional
public class NhaCungCapDAOImpl implements NhaCungCapDAO{
	@Autowired
	SessionFactory factory;

	public boolean add(NhaCungCap nhaCungCap) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(nhaCungCap);
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

	public boolean update(NhaCungCap nhaCungCap) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(nhaCungCap);
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
		NhaCungCap nhaCungCap = (NhaCungCap) session.get(NhaCungCap.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			session.delete(nhaCungCap);
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

	public NhaCungCap getByID(String ma) {
		return (NhaCungCap) factory.getCurrentSession().get(NhaCungCap.class, ma);
	}
	
	@SuppressWarnings("unchecked")
	public List<NhaCungCap> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(NhaCungCap.class);
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
