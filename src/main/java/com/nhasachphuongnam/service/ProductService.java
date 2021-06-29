package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.entity.MatHang;
import com.nhasachphuongnam.model.Product;

public interface ProductService {
	
	Product convert(MatHang matHang);
	
	boolean add(Product product);
	
	boolean update(Product product);
	
	boolean updateDiscount(String ma, Float giamGia);
	
	boolean delete(String maProduct);
	
	boolean cleanAll(String maProduct);
	
	Product getByID(String maProduct);
	
	List<Product> getProductListByType(String ma);
	
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
