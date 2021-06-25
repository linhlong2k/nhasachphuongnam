package com.nhasachphuongnam.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.entity.HoaDon;
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
			session.save(nhanVien.getTaiKhoan());
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
			session.update(nhanVien);
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
			Criteria cr = session.createCriteria(HoaDon.class);
			cr.add(Restrictions.eq("nhanVien.maNV", nhanVien.getMaNV()));
			@SuppressWarnings("unchecked")
			List<HoaDon> hoaDons = cr.list();
			if(hoaDons != null) {
				for(HoaDon i: hoaDons) {
					i.setNhanVien(null);
					session.save(i);
				}
			}
			session.delete(nhanVien);
			session.delete(nhanVien.getTaiKhoan());
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
		NhanVien nhanVien = null;
		Session session = factory.openSession();
		try {
			nhanVien = (NhanVien) session.get(NhanVien.class, ma);
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return nhanVien;
	}
	
	@SuppressWarnings("unchecked")
	public List<NhanVien> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(NhanVien.class);
		return cr.list();
	}
	
	/*
	 * ===================================advanced==================================
	 */
	public String getLastMa() {
		String sql = "SELECT top 1 MANV FROM NHANVIEN ORDER BY MANV DESC";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		if(results.size() == 0) {
			return null;
		}
		return results.get(0);
	}
	
	public String getMaByUsername(String username) {
		String sql = "SELECT MANV FROM NHANVIEN WHERE NHANVIEN.USERNAME='" + username +"'";
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<String> results = (List<String>)query.list();
		return results != null ? results.get(0) : null;
	}
}
