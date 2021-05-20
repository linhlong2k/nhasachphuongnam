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
	@Autowired(required=true)
	LoaiMatHangDAO loaiMatHangDAO;
	
	public String theNextMaLoai() {
		String mamh = loaiMatHangDAO.getLastMaLoai();
		int index = Integer.parseInt(mamh.substring(1, mamh.length()));
		String newmamh = "L";
		index++;
		for(int i = 0; i < 9 - String.valueOf(index).length(); i++)
			newmamh += '0';
		newmamh += String.valueOf(index);
		return newmamh;
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
		loai.setMaLoai(theNextMaLoai());
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
			/*
			LoaiMatHang loai = loaiMatHangDAO.getByID(maProductType);
			if(loai == null)
				return false;
			List<MatHang> matHangList = loai.getMathangs();
			for(MatHang i: matHangList)
				loaiMatHangDAO.delete(i.getMaMH());
				*/
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
