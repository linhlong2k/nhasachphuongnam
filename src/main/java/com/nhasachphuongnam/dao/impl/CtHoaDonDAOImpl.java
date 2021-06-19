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

import com.nhasachphuongnam.dao.CtHoaDonDAO;
import com.nhasachphuongnam.entity.CtHoaDon;

@Repository
@Transactional
public class CtHoaDonDAOImpl implements CtHoaDonDAO{
	@Autowired
	SessionFactory factory;

	public boolean add(CtHoaDon ctHoaDon) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(ctHoaDon);
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

	public boolean update(CtHoaDon ctHoaDon) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(ctHoaDon);
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
		CtHoaDon ctHoaDon = (CtHoaDon) session.get(CtHoaDon.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			session.delete(ctHoaDon);
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

	public CtHoaDon getByID(String ma) {
		return (CtHoaDon) factory.getCurrentSession().get(CtHoaDon.class, ma);
	}
	
	@SuppressWarnings("unchecked")
	public List<CtHoaDon> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(CtHoaDon.class);
		return cr.list();
	}
	
	/*
	 * ===================================advanced==================================
	 */
	
	@SuppressWarnings("unchecked")
	public List<CtHoaDon> getbyMaHD(String ma) {
		String sql = "  SELECT * FROM CT_HOADON WHERE MAHD = :mahd";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);

		query.addEntity(CtHoaDon.class);
		query.setParameter("mahd", ma);
		return query.list();
	}

}