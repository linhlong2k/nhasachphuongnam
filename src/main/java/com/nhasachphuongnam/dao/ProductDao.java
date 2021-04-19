package com.nhasachphuongnam.dao;

import java.util.List;

import com.nhasachphuongnam.entity.*;

public interface ProductDao {
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void DeleteProduct(String maProduct);
	
	public Product getProductById(String maProduct);
	
	public List<Product> getAllProducts();
}
