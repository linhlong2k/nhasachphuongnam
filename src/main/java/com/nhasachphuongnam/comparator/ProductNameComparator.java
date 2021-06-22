package com.nhasachphuongnam.comparator;

import java.util.Comparator;

import com.nhasachphuongnam.model.Product;

public class ProductNameComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getTenMatHang().trim().compareTo(o2.getTenMatHang().trim());
	}

}
