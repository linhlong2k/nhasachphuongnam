package com.nhasachphuongnam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.CtHoaDonDAO;
import com.nhasachphuongnam.dao.CtPhieuNhapDAO;
import com.nhasachphuongnam.dao.KhachHangDAO;
import com.nhasachphuongnam.dao.NhaCungCapDAO;
import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.dao.PhieuNhapDAO;
import com.nhasachphuongnam.entity.CtPhieuNhap;
import com.nhasachphuongnam.entity.NhaCungCap;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.entity.PhieuNhap;
import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.model.Supplier;
import com.nhasachphuongnam.service.ImportOrderService;
import com.nhasachphuongnam.service.PIService;
import com.nhasachphuongnam.service.SupplierService;

@Repository
@Transactional
public class ImportOrderServiceImpl implements ImportOrderService{
	
	@Autowired
	PhieuNhapDAO phieuNhapDAO;
	
	@Autowired
	KhachHangDAO khachHangDAO;
	
	@Autowired
	NhanVienDAO nhanVienDAO;
	
	@Autowired
	NhaCungCapDAO nhaCungCapDAO;
	
	@Autowired
	CtPhieuNhapDAO ctPhieuNhapDAO;
	
	@Autowired
	PIService piService;
	
	@Autowired
	SupplierService supplierService;
	
	public String theNextMa() {
		String ma = phieuNhapDAO.getLastMa();
		int index = Integer.parseInt(ma.substring(2, ma.length()));
		String newmamh = "PN";
		index++;
		for(int i = 0; i < 8 - String.valueOf(index).length(); i++)
			newmamh += '0';
		newmamh += String.valueOf(index);
		return newmamh;
	}
	
	public ImportOrder convert(PhieuNhap var) {
		ImportOrder res = new ImportOrder();
		res.setMaDonHang(var.getMaPN());
		res.setThoiGian(var.getThoiGian());
		PersonalInfo temp2 = piService.getByID(var.getNhanvien().getMaNV());
		res.setNhanVien(temp2);
		Supplier temp1 = supplierService.getByID(var.getNhacungcap().getMaNCC());
		res.setNhaCungCap(temp1);
		List<ProductDetail> temp3 = new ArrayList<ProductDetail>();
		ProductDetail temp4;
		List<CtPhieuNhap> temp5 = ctPhieuNhapDAO.getbyMaPN(var.getMaPN());
		for(CtPhieuNhap i: temp5) {
			temp4 = new ProductDetail();
			temp4.setMaMatHang(i.getMathang().getMaMH());
			temp4.setSoLuong(i.getSoLuong());
			temp4.setGia(i.getGia().longValue());
			temp4.setGiamGia(i.getGiamgia());
			temp3.add(temp4);
		}
		res.setChiTiets(temp3);
		return res;
	}
	
	public PhieuNhap convert(ImportOrder var) {
		PhieuNhap res = phieuNhapDAO.getByID(var.getMaDonHang());
		if(res == null)
			res = new PhieuNhap();
		NhaCungCap temp1 = nhaCungCapDAO.getByID(var.getNhaCungCap().getMaNhaCungCap());
		res.setNhacungcap(temp1);
		NhanVien temp2 = nhanVienDAO.getByID(var.getNhanVien().getMa());
		res.setNhanvien(temp2);
		res.setThoiGian(var.getThoiGian());
		return res;
	}
	
	//chưa cập nhập số lượng của mặt hàng
	public boolean add(ImportOrder var) {
		PhieuNhap temp1 = this.convert(var);
		temp1.setMaPN(this.theNextMa());
		if(phieuNhapDAO.add(temp1))
			return true;
		return false;
	}
	
	public boolean update(ImportOrder var) {
		PhieuNhap temp1 = this.convert(var);
		if(phieuNhapDAO.update(temp1))
			return true;
		return false;
	}
	
	public boolean delete(String ma) {
		if(phieuNhapDAO.delete(ma))
			return true;
		return false;
	}
	
	public ImportOrder getByID(String ma) {
		PhieuNhap temp = phieuNhapDAO.getByID(ma);
		if(temp == null)
			return null;
		ImportOrder res = convert(temp);
		return res;
	}
	
	public List<ImportOrder> getAll(){
		List<ImportOrder> res = new ArrayList<ImportOrder>();
		List<PhieuNhap> phieuNhaps = phieuNhapDAO.getAll();
		for(PhieuNhap i: phieuNhaps) {
			res.add(convert(i));
		}
		return res;
	}
}
