package com.nhasachphuongnam.service;

import java.util.List;

import com.nhasachphuongnam.model.ProductDTO;

public interface ProductService {
	
	public void addProduct(ProductDTO product);
	
	public void updateProduct(ProductDTO product);
	
	public void deleteProduct(String productId);
	
	public ProductDTO getProductById(String productId);
	
	public List<ProductDTO> getAllProducts();
}
