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
	
	@Autowired(required=true)
	MatHangDAO matHangDAO;
	
	@Autowired(required = true)
	LoaiMatHangDAO loaiMatHangDAO;

	public String theNextMaMH() {
		String mamh = matHangDAO.getLastMa();
		int index = Integer.parseInt(mamh.substring(2, mamh.length()));
		String newmamh = "MH";
		index++;
		for(int i = 0; i < 10 - String.valueOf(index).length(); i++)
			newmamh += '0';
		newmamh += String.valueOf(index);
		return newmamh;
	}
	
	public Product convert(MatHang matHang) {
		Product res = new Product(matHang.getMaMH(), matHang.getTenMH(), matHang.getHinhAnh(), matHang.getSoLuong(), matHang.getMoTaNgan(), matHang.getMoTa(), matHang.getAllow(), matHang.getGia().longValue(), matHang.getLoaimathang().getMaLoai());
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
		matHang.setSoLuong(product.getSoLuong());
		matHang.setLoaimathang(loaiMatHangDAO.getByID(product.getMaLoai()));
		matHang.setGia(new BigDecimal(product.getGia()));
		return matHang;
	}
	
	public boolean add(Product product) {
		MatHang matHang = convert(product);
		matHang.setMaMH(theNextMaMH());
		matHang.setAllow(true);
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
		return convert(matHangDAO.getByID(maProduct));
	}
	
	//==============================advanced=========================================
	
	public List<Product> getProductListByType(String ma) {
		LoaiMatHang loai = loaiMatHangDAO.getByID(ma);
		if(loai == null)
			return null;
		List<MatHang> matHangList = loai.getMathangs();
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
}
