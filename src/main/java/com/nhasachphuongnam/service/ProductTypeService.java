package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.bean.ProductType;
import com.nhasachphuongnam.entity.LoaiMatHang;

public interface ProductTypeService {
	
	ProductType convert(LoaiMatHang loaiMatHang);
	
	boolean add(ProductType productType);
	
	boolean update(ProductType productType);
	
	boolean delete(String maProductType);
	
	ProductType getByID(String maProductType);
	
	List<ProductType> getAll();
}
