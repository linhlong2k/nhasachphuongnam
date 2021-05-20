/*
 * package com.nhasachphuongnam.dao.impl;
 * 
 * import java.math.BigDecimal; import java.math.BigInteger; import
 * java.util.ArrayList; import java.util.Date; import java.util.List;
 * 
 * import org.hibernate.Criteria; import org.hibernate.HibernateException;
 * import org.hibernate.SQLQuery; import org.hibernate.Session; import
 * org.hibernate.SessionFactory; import org.hibernate.Transaction; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.nhasachphuongnam.dao.GiaDAO; import
 * com.nhasachphuongnam.entity.Gia; import com.nhasachphuongnam.entity.MatHang;
 * 
 * @Repository
 * 
 * @Transactional public class GiaDAOImpl implements GiaDAO {
 * 
 * @Autowired SessionFactory factory;
 * 
 * public boolean add(Gia gia) { boolean flag = true; Session session =
 * factory.openSession(); Transaction tran = session.beginTransaction(); try {
 * session.save(gia); tran.commit(); } catch (HibernateException ex) {
 * tran.rollback(); ex.printStackTrace(); flag = false; } finally {
 * session.close(); } return flag; }
 * 
 * public boolean update(Gia gia) { boolean flag = true; Session session =
 * factory.openSession(); Transaction tran = session.beginTransaction(); try {
 * session.merge(gia); tran.commit(); } catch (HibernateException ex) {
 * tran.rollback(); ex.printStackTrace(); flag = false; } finally {
 * session.close(); } return flag; }
 * 
 * public boolean delete(String maGia) { boolean flag = true; Gia gia =
 * getByID(maGia); Session session = factory.openSession(); Transaction tran =
 * session.beginTransaction(); if(gia == null) return false; try {
 * session.delete(gia); tran.commit(); } catch (HibernateException ex) {
 * tran.rollback(); ex.printStackTrace(); flag = false; } finally {
 * session.close(); } return flag; }
 * 
 * public Gia getByID(String maGia) { return
 * (Gia)factory.getCurrentSession().get(Gia.class, maGia); }
 * 
 * @SuppressWarnings("unchecked") public List<Gia> getAll(){ Criteria cr =
 * factory.getCurrentSession().createCriteria(Gia.class); return cr.list(); }
 * 
 * public BigDecimal getGiaCurrent(String maMH) { String sql =
 * "SELECT GIA FROM GIA WHERE GIA.MAMH='" + maMH +"' ORDER BY THOIGIAN DESC";
 * Session session = factory.getCurrentSession(); SQLQuery query =
 * session.createSQLQuery(sql);
 * 
 * @SuppressWarnings("unchecked") List<BigDecimal> results =
 * (List<BigDecimal>)query.list(); BigDecimal gia = new BigDecimal(0); for
 * (BigDecimal i : results) if (!i.equals(0)) gia = i; return gia; } }
 */