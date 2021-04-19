package com.nhasachphuongnam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.model.ProductDTO;
import com.nhasachphuongnam.service.ProductService;

@Repository
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	SessionFactory factory;

	public void addProduct(ProductDTO productDTO) {
		/*
		 * Product product = new Product(); 
		 * product.set(productDTO.get());
		 * ProductDAO.addProduct(product);
		 */
	}
	
	public void updateProduct(ProductDTO productDTO) {
		/*
		 * Product product = ProductDAO.getProductById(productDTO.getId()); 
		 * if(product != null) { 
		 * product.set(productDTO.get()); 
		 * ProductDAO.updateProduct(product);
		 * }
		 */
	}
	
	public void deleteProduct(String productId) {
	}
	
	public ProductDTO getProductById(String productId) {
		return new ProductDTO();
	}
	
	public List<ProductDTO> getAllProducts(){
		return new ArrayList<ProductDTO>() ;
	}
}
