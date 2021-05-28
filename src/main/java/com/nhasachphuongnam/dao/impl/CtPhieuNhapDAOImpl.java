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

import com.nhasachphuongnam.dao.CtPhieuNhapDAO;
import com.nhasachphuongnam.entity.CtPhieuNhap;

@Repository
@Transactional
public class CtPhieuNhapDAOImpl implements CtPhieuNhapDAO{
	@Autowired
	SessionFactory factory;
	
	public boolean add(CtPhieuNhap ctPhieuNhap) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(ctPhieuNhap);
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

	public boolean update(CtPhieuNhap ctPhieuNhap) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(ctPhieuNhap);
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
		CtPhieuNhap ctPhieuNhap = (CtPhieuNhap) session.get(CtPhieuNhap.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			session.delete(ctPhieuNhap);
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

	public CtPhieuNhap getByID(String ma) {
		return (CtPhieuNhap) factory.getCurrentSession().get(CtPhieuNhap.class, ma);
	}
	
	@SuppressWarnings("unchecked")
	public List<CtPhieuNhap> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(CtPhieuNhap.class);
		return cr.list();
	}
	
	/*
	 * ===================================advanced==================================
	 */
	
	@SuppressWarnings("unchecked")
	public List<CtPhieuNhap> getbyMaPN(String ma) {
		String sql = "  SELECT * FROM CT_PHIEUNHAP WHERE MAPN = :mapn";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);

		query.addEntity(CtPhieuNhap.class);
		query.setParameter("mapn", ma);
		return query.list();
	}
}
