package com.nhasachphuongnam.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.bean.Product;
import com.nhasachphuongnam.dao.GiaDAO;
import com.nhasachphuongnam.dao.LoaiMatHangDAO;
import com.nhasachphuongnam.dao.MatHangDAO;
import com.nhasachphuongnam.entity.Gia;
import com.nhasachphuongnam.entity.MatHang;
import com.nhasachphuongnam.service.ProductService;

@Repository
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired(required=true)
	MatHangDAO matHangDAO;
	
	@Autowired(required = true)
	LoaiMatHangDAO loaiMatHangDAO;
	
	@Autowired(required = true)
	GiaDAO giaDAO;

	public String theNextMaMH() {
		String mamh = matHangDAO.getLastMaMH();
		int index = Integer.parseInt(mamh.substring(2, mamh.length()));
		String newmamh = "MH";
		index++;
		for(int i = 0; i < 10 - String.valueOf(index).length(); i++)
			newmamh += '0';
		newmamh += String.valueOf(index);
		return newmamh;
	}
	
	public Product convert(MatHang mathang) {
		Product res = new Product(mathang.getMaMH(), mathang.getTenMH(), 0, mathang.getSoLuong(), mathang.getMoTaNgan(), mathang.getMoTa(), mathang.getHinhAnh(), mathang.getLoaimathang().getMaLoai());
		List<Gia> giaList = mathang.getGias();
		res.setGia(giaList.get(giaList.size()-1).getGia().longValue());
		return res;
	}
	
	public MatHang convert(Product product) {
			//add mat hang
		MatHang matHang = new MatHang();
		matHang.setMaMH(product.getMaMH());
		matHang.setTenMH(product.getTenMH());
		if(product.getHinhAnh() != null)
			matHang.setHinhAnh(product.getHinhAnh());
		if(product.getMoTaNgan() != null)
			matHang.setMoTaNgan(product.getMoTaNgan());
		if(product.getMoTa() != null)
			matHang.setMoTa(product.getMoTa());
		matHang.setSoLuong(product.getSoLuong());
		matHang.setLoaimathang(loaiMatHangDAO.getByID(product.getMaLoai()));
		return matHang;
	}
	
	public boolean add(Product product) {
		MatHang matHang = convert(product);
		matHang.setMaMH(theNextMaMH());
		matHang.setAllow(true);
			//add gia
		Gia giaMH = new Gia();
		giaMH.setMathang(matHang);
		giaMH.setGia(BigDecimal.valueOf(product.getGia()));
		//get today
		LocalDate today = java.time.LocalDate.now();
		giaMH.setThoiGian(Date.valueOf(today));
			//database
		if(matHangDAO.add(matHang))
			if(giaDAO.add(giaMH))
				return true;
		return false;
	}
	
	public boolean update(Product product) {
		MatHang matHang = convert(product);
			//add gia
		if(product.getGia() != giaDAO.getGiaCurrent(product.getMaMH()).longValue()) {
			Gia giaMH = new Gia();
			giaMH.setMathang(matHang);
			giaMH.setGia(BigDecimal.valueOf(product.getGia()));
			//get today
			LocalDate today = java.time.LocalDate.now();
			giaMH.setThoiGian(Date.valueOf(today));
				//database
			if(matHangDAO.update(matHang))
				if(giaDAO.add(giaMH))
					return true;
		} else
			if(matHangDAO.update(matHang))
				return true;
		return false;
	}
	
	public boolean delete(String maProduct) {
		MatHang mathang = matHangDAO.getByID(maProduct);
		mathang.setAllow(false);
		if(matHangDAO.update(mathang))
			return true;
		return false;
	}
	
	public Product getByID(String maProduct) {
		return convert(matHangDAO.getByID(maProduct));
	}
	
	public List<Product> getAll(){
		List<Product> productList = new ArrayList<Product>();
		List<MatHang> matHangList = matHangDAO.getAll();
		for(MatHang i: matHangList) {
			if(i.isAllow()) {
				productList.add(convert(i));
			}
		}
		return productList;
	}
}
