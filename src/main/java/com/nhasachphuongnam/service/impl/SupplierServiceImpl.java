package com.nhasachphuongnam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.NhaCungCapDAO;
import com.nhasachphuongnam.entity.NhaCungCap;
import com.nhasachphuongnam.model.Supplier;
import com.nhasachphuongnam.service.SupplierService;

@Repository
@Transactional
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	NhaCungCapDAO nhaCungCapDAO;
	
	public String theNextID() {
		String ma = nhaCungCapDAO.getLastMa();
		if(ma == null) {
			return "NCC0000001";
		}
		int index = Integer.parseInt(ma.substring(3, ma.length())) + 1;
		StringBuilder newMaNCC = new StringBuilder("NCC");
		for(int i = 0; i < 7 - String.valueOf(index).length(); i++) {
			newMaNCC.append('0');
		}
		newMaNCC.append(index);
		return newMaNCC.toString();
	}
	
	public Supplier convert(NhaCungCap nhaCungCap) {
		Supplier supplier = new Supplier(nhaCungCap.getMaNCC(), nhaCungCap.getTenNCC(), nhaCungCap.getDiaChi(), nhaCungCap.getSdt());
		return supplier;
	}
	
	public NhaCungCap convert(Supplier supplier) {
		NhaCungCap nhaCungCap = nhaCungCapDAO.getByID(supplier.getMaNhaCungCap());
		if(nhaCungCap == null)
			nhaCungCap = new NhaCungCap();
		nhaCungCap.setTenNCC(supplier.getTenNhaCungCap());
		if(supplier.getDiaChi() != null)
			nhaCungCap.setDiaChi(supplier.getDiaChi());
		if(supplier.getSoDienThoai() != null)
			nhaCungCap.setSdt(supplier.getSoDienThoai());
		return nhaCungCap;
	}
	
	public boolean add(Supplier supplier) {
		NhaCungCap nhaCungCap = convert(supplier);
		nhaCungCap.setMaNCC(theNextID());
		if(nhaCungCapDAO.add(nhaCungCap))
			return true;
		return false;
	}
	
	public boolean update(Supplier Supplier) {
		NhaCungCap nhaCungCap = convert(Supplier);
		if(nhaCungCapDAO.update(nhaCungCap))
			return true;
		return false;
	}
	
	public boolean delete(String ma) {
		if(nhaCungCapDAO.delete(ma)) {
			return true;
		}
		return false;
	}
	
	public Supplier getByID(String ma) {
		NhaCungCap nhaCungCap = nhaCungCapDAO.getByID(ma);
		if(nhaCungCap == null)
			return null;
		Supplier supplier = convert(nhaCungCap);
		return supplier;
	}
	
	public List<Supplier> getAll(){
		List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.getAll();
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for(NhaCungCap i: nhaCungCaps)
			suppliers.add(convert(i));
		return suppliers;
	}
}
