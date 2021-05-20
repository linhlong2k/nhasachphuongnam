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

import com.nhasachphuongnam.dao.LoaiMatHangDAO;
import com.nhasachphuongnam.entity.LoaiMatHang;

@Repository
@Transactional
public class LoaiMatHangDAOImpl implements LoaiMatHangDAO {
	@Autowired
	SessionFactory factory;
	
	public boolean add(LoaiMatHang loai) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(loai);
			tran.commit();
		} catch (HibernateException ex) {
			tran.rollback();
			ex.printStackTrace();
			flag = false;
		} finally {
			session.close();
		}
		return flag;
	}

	public boolean update(LoaiMatHang loai) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.merge(loai);
			tran.commit();
		} catch (HibernateException ex) {
			tran.rollback();
			ex.printStackTrace();
			flag = false;
		} finally {
			session.close();
		}
		return flag;
	}

	public boolean delete(String maLoai) {
		boolean flag = true;
		LoaiMatHang loai = getByID(maLoai);
		/* loai.setMathangs(null); */
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		if(loai == null)
			return false;
		try {
			session.delete(loai);
			tran.commit();
		} catch (HibernateException ex) {
			tran.rollback();
			ex.printStackTrace();
			flag = false;
		} finally {
			session.close();
		}
		return flag;
	}

	public LoaiMatHang getByID(String maLoai) {
		return (LoaiMatHang) factory.getCurrentSession().get(LoaiMatHang.class, maLoai);
	}

	public List<LoaiMatHang> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(LoaiMatHang.class);
		return cr.list();
	}
	
	public String getLastMaLoai() {
		String sql = "SELECT top 1 MALOAI FROM LOAIMATHANG ORDER BY MALOAI DESC";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		return results.get(0);
	}
}