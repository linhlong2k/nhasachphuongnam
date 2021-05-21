package com.nhasachphuongnam.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nhasachphuongnam.entity.MatHang;

public class AbcDAOImpl {
	public MatHang getByID(String ma) {
		abc abc = null;
		Session session = factory.openSession();
		try {
			abc = (abc) session.get(abc.class, ma);
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return abc;
	}
}
