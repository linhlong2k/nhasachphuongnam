package com.nhasachphuongnam.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.ProductDao;
import com.nhasachphuongnam.entity.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory factory;
	
	public void addProduct(Product product) {
		factory.getCurrentSession().save(product);
	}
	
	public void updateProduct(Product product) {
		factory.getCurrentSession().merge(product);
	}
	
	public void DeleteProduct(String maProduct) {
		factory.getCurrentSession().delete(getProductById(maProduct));
	}
	
	public Product getProductById(String maProduct) {
		return (Product) factory.getCurrentSession().get(Product.class, maProduct);
	}
	
	public List<Product> getAllProducts(){
		/*
		 * Criteria cr = factory.getCurrentSession().createCriteria(Employee.class);
		 * return cr.list();
		 */
		String hql = "FROM MATHANG";
		Query query = factory.getCurrentSession().createQuery(hql);
		List results = query.list();
		return query.list();
	}
}
