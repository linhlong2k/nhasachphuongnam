package com.nhasachphuongnam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.LoaiMatHangDAO;
import com.nhasachphuongnam.entity.LoaiMatHang;
import com.nhasachphuongnam.model.ProductType;
import com.nhasachphuongnam.service.ProductTypeService;

@Repository
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{
	@Autowired
	LoaiMatHangDAO loaiMatHangDAO;
	
	public String theNextID() {
		String ma = loaiMatHangDAO.getLastMa();
		if(ma == null) {
			return "L000000001";
		}
		int index = Integer.parseInt(ma.substring(1, ma.length())) + 1;
		StringBuilder newMaL = new StringBuilder("L");
		for(int i = 0; i < 9 - String.valueOf(index).length(); i++) {
			newMaL.append('0');
		}
		newMaL.append(index);
		return newMaL.toString();
	}
	
	public ProductType convert(LoaiMatHang loaiMatHang) {
		ProductType type = new ProductType();
		type.setMaLoai(loaiMatHang.getMaLoai());
		type.setTenLoai(loaiMatHang.getTenLoai());
		return type;
	}
	
	public LoaiMatHang convert(ProductType type) {
		LoaiMatHang loai = new LoaiMatHang();
		loai.setMaLoai(type.getMaLoai());
		loai.setTenLoai(type.getTenLoai());
		return loai;
	}
	
	public boolean add(ProductType productType) {
		LoaiMatHang loai = convert(productType);
		loai.setMaLoai(this.theNextID());
		if(loaiMatHangDAO.add(loai))
			return true;
		return false;
	}
	
	public boolean update(ProductType productType) {
		LoaiMatHang loai = convert(productType);
		if(loaiMatHangDAO.update(loai))
			return true;
		return false;
	}
	
	//delete this ProductType and setAllow(false) for product producttype items
	public boolean delete(String maProductType) {
		if(loaiMatHangDAO.delete(maProductType)) {
			return true;
		}
		return false;
	}
	
	public ProductType getByID(String maProductType) {
		LoaiMatHang loai = loaiMatHangDAO.getByID(maProductType);
		if(loai == null)
			return null;
		ProductType type = convert(loai);
		return type;
	}
	
	public List<ProductType> getAll(){
		List<LoaiMatHang> loais = loaiMatHangDAO.getAll();
		List<ProductType> types = new ArrayList<ProductType>();
		for(LoaiMatHang i: loais)
			types.add(convert(i));
		return types;
	}
}
