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

import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.entity.NhanVien;

@Repository
@Transactional
public class NhanVienDAOImpl implements NhanVienDAO {
	@Autowired
	SessionFactory factory;

	public boolean add(NhanVien nhanVien) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(nhanVien);
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

	public boolean update(NhanVien nhanVien) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(nhanVien);
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
		NhanVien nhanVien = (NhanVien) session.get(NhanVien.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			session.delete(nhanVien);
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

	public NhanVien getByID(String ma) {
		return (NhanVien) factory.getCurrentSession().get(NhanVien.class, ma);
	}
	
	@SuppressWarnings("unchecked")
	public List<NhanVien> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(NhanVien.class);
		return cr.list();
	}
	
	/*
	 * ===================================advanced==================================
	 */
	
	public String getMaByUsername(String username) {
		String sql = "SELECT MANV FROM NHANVIEN WHERE NHANVIEN.USERNAME='" + username +"'";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		return results != null ? results.get(0) : null;
	}
}
