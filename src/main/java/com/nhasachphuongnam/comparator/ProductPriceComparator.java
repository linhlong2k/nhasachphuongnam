package com.nhasachphuongnam.comparator;

import java.util.Comparator;

import com.nhasachphuongnam.model.Product;

public class ProductPriceComparator implements Comparator<Product>{
	
	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getGia() < o2.getGia()) {
			return -1;
		} else if(o1.getGia() == o1.getGia()) {
			return 0;
		} else {
			return 1;
		}
	}

}
