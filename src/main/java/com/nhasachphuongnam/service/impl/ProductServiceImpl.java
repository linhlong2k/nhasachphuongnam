package com.nhasachphuongnam.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.LoaiMatHangDAO;
import com.nhasachphuongnam.dao.MatHangDAO;
import com.nhasachphuongnam.entity.LoaiMatHang;
import com.nhasachphuongnam.entity.MatHang;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ProductService;

@Repository
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	MatHangDAO matHangDAO;
	
	@Autowired
	LoaiMatHangDAO loaiMatHangDAO;

	public String theNextID() {
		String ma = matHangDAO.getLastMa();
		if(ma == null) {
			return "MH00000000001";
		}
		int index = Integer.parseInt(ma.substring(2, ma.length())) + 1;
		StringBuilder newMaMH = new StringBuilder("MH");
		for(int i = 0; i < 10 - String.valueOf(index).length(); i++) {
			newMaMH.append('0');
		}
		newMaMH.append(index);
		return newMaMH.toString();
	}
	
	public Product convert(MatHang matHang) {
		Product res = new Product(matHang.getMaMH(), matHang.getTenMH(), matHang.getHinhAnh(), matHang.getSoLuong(), matHang.getMoTaNgan(), matHang.getMoTa(), matHang.getAllow(), matHang.getGia().longValue(), matHang.getGiamGia(), matHang.getLoaiMatHang().getMaLoai());
		return res;
	}
	
	public MatHang convert(Product product) {
			//
		MatHang matHang;
		try{
			matHang = matHangDAO.getByID(product.getMaMatHang());
			matHang.setTenMH(product.getTenMatHang());
		} catch(NullPointerException ex) {
			ex.printStackTrace();
			matHang = new MatHang();
			matHang.setTenMH(product.getTenMatHang());
		}
		
		if(product.getHinhAnh() != null)
			matHang.setHinhAnh(product.getHinhAnh());
		if(product.getMoTaNgan() != null)
			matHang.setMoTaNgan(product.getMoTaNgan());
		if(product.getMoTa() != null)
			matHang.setMoTa(product.getMoTa());
		if(product.getGiamGia() != null)
			matHang.setGiamGia(product.getGiamGia());
		matHang.setSoLuong(product.getSoLuong());
		matHang.setLoaiMatHang(loaiMatHangDAO.getByID(product.getMaLoai()));
		matHang.setGia(new BigDecimal(product.getGia()));
		return matHang;
	}
	
	public boolean add(Product product) {
		MatHang matHang = convert(product);
		matHang.setMaMH(theNextID());
		matHang.setAllow(true);
		matHang.setGiamGia(Float.valueOf(0));
		if(matHangDAO.add(matHang))
			return true;
		return false;
	}
	
	public boolean update(Product product) {
		MatHang matHang = convert(product);
		if(matHangDAO.update(matHang))
			return true;
		return false;
	}
	
	//Chỉ làm mặt hàng bị ẩn đi trong danh sách
	public boolean delete(String maProduct) {
		MatHang matHang = matHangDAO.getByID(maProduct);
		matHang.setAllow(false);
		if(matHangDAO.update(matHang))
			return true;
		return false;
	}
	
	//xóa toàn bộ thông tin hay đơn hàng liên quan đến mặt hàng này
	public boolean cleanAll(String maProduct) {
		if(matHangDAO.delete(maProduct))
			return true;
		return false;
	}
	
	public Product getByID(String maProduct) {
		MatHang temp = matHangDAO.getByID(maProduct);
		if(temp == null)
			return null;
		Product res = convert(temp);
		return res;
	}
	
	//==============================advanced=========================================
	
	public List<Product> getProductListByType(String ma) {
		LoaiMatHang loai = loaiMatHangDAO.getByID(ma);
		if(loai == null)
			return null;
		List<MatHang> matHangList = loai.getMatHangs();
		List<Product> res = new ArrayList<Product>();
		for(MatHang i: matHangList)
			res.add(convert(i));
		return res;
	}
	
	public List<Product> getAll(){
		List<Product> productList = new ArrayList<Product>();
		List<MatHang> matHangList = matHangDAO.getAll();
		for(MatHang i: matHangList) {
			if(i.getAllow() == true) {
				productList.add(convert(i));
			}
		}
		return productList;
	}
	
	public boolean updateDiscount(String ma, Float giamGia) {
		MatHang temp = matHangDAO.getByID(ma);
		if(temp == null) {
			return false;
		}
		temp.setGiamGia(giamGia);
		if(matHangDAO.update(temp)) {
			return true;
		}
		return false;
	}
}
