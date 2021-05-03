package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.bean.Product;
import com.nhasachphuongnam.entity.MatHang;

public interface ProductService {
	
	Product convert(MatHang mathang);
	
	boolean add(Product product);
	
	boolean update(Product product);
	
	boolean delete(String maProduct);
	
	Product getByID(String maProduct);
	
	List<Product> getAll();
	/*
	 * public void addProduct(ProductDTO product);
	 * 
	 * public void updateProduct(ProductDTO product);
	 * 
	 * public void deleteProduct(String productId);
	 * 
	 * public ProductDTO getProductById(String productId);
	 * 
	 * public List<ProductDTO> getAllProducts();
	 */
}
