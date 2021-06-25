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

import com.nhasachphuongnam.dao.MatHangDAO;
import com.nhasachphuongnam.entity.MatHang;

@Repository
@Transactional
public class MatHangDAOImpl implements MatHangDAO {
	
	@Autowired
	SessionFactory factory;
	
	public boolean add(MatHang mathang) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(mathang);
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

	public boolean update(MatHang mathang) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(mathang);
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

	public boolean delete(String maMH) {
		boolean flag = true;
		Session session = null;
		session = factory.openSession();
		Transaction tran = session.beginTransaction();
		MatHang mathang = (MatHang) getByID(maMH);
		/*
		 * if(mathang == null) return false;
		 */
		try {
			session.delete(mathang);
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

	public MatHang getByID(String maMH) {
		MatHang res = null;
		Session session = factory.openSession();
		try {
			res = (MatHang) session.get(MatHang.class, maMH);
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<MatHang> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(MatHang.class);
		return cr.list();
	}
	
	public String getLastMa() {
		String sql = "SELECT top 1 MAMH FROM MATHANG ORDER BY MAMH DESC";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		if(results.size() == 0) {
			return null;
		}
		return results.get(0);
	}
	
	//chưa kiểm tra số lượng n với số lượng ban đầu.
	public boolean changeSoLuong(String ma, int n) {
		MatHang temp = this.getByID(ma);
		temp.setSoLuong(temp.getSoLuong() + n);
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(temp);
			tran.commit();
		} catch(HibernateException ex) {
			tran.rollback();
			ex.printStackTrace();
			session.close();
			return false;
		} 
		session.close();
		return true;
	}
}