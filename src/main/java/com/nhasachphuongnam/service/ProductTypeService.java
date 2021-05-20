package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.entity.LoaiMatHang;
import com.nhasachphuongnam.model.ProductType;

public interface ProductTypeService {
	
	ProductType convert(LoaiMatHang loaiMatHang);
	
	boolean add(ProductType productType);
	
	boolean update(ProductType productType);
	
	boolean delete(String maProductType);
	
	ProductType getByID(String maProductType);
	
	List<ProductType> getAll();
}
