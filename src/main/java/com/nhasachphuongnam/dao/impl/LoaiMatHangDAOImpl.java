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
import com.nhasachphuongnam.entity.MatHang;

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
			session.update(loai);
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
		/* loai.setMathangs(null); */
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		LoaiMatHang loai = (LoaiMatHang) session.get(LoaiMatHang.class, maLoai);
		LoaiMatHang loaiNull = (LoaiMatHang) session.get(LoaiMatHang.class, "L000000000");
		if(loai == null)
			return false;
		try {
			for(MatHang i: loai.getMatHangs()) {
				i.setLoaiMatHang(loaiNull);
				session.update(i);
			}
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

	@SuppressWarnings("unchecked")
	public List<LoaiMatHang> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(LoaiMatHang.class);
		return cr.list();
	}
	
	public String getLastMa() {
		String sql = "SELECT top 1 MALOAI FROM LOAIMATHANG ORDER BY MALOAI DESC";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		if(results.size() == 0) {
			return null;
		}
		return results.get(0);
	}
}