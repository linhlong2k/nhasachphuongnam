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

import com.nhasachphuongnam.dao.RoleDAO;
import com.nhasachphuongnam.entity.Role;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO{
	
	@Autowired
	SessionFactory factory;

	public boolean add(Role role) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(role);
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

	public boolean update(Role role) {
		boolean flag = true;
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.update(role);
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
		Role role = (Role) session.get(Role.class, ma);
		/*
		 * if(ctHoaDon == null) return false;
		 */
		try {
			session.delete(role);
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

	public Role getByID(String ma) {
		Role role = null;
		Session session = factory.openSession();
		try {
			role = (Role) session.get(Role.class, ma);
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getAll(){
		Criteria cr = factory.getCurrentSession().createCriteria(Role.class);
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
