package com.nhasachphuongnam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.CtHoaDonDAO;
import com.nhasachphuongnam.dao.HoaDonDAO;
import com.nhasachphuongnam.dao.KhachHangDAO;
import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.dao.PhieuNhapDAO;
import com.nhasachphuongnam.entity.CtHoaDon;
import com.nhasachphuongnam.entity.CtPhieuNhap;
import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.entity.KhachHang;
import com.nhasachphuongnam.entity.LoaiMatHang;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.model.ProductType;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.PIService;

@Repository
@Transactional
public class ExportOrderServiceImpl implements ExportOrderService{
	@Autowired
	HoaDonDAO hoaDonDAO;
	
	@Autowired
	PhieuNhapDAO phieuNhapDAO;
	
	@Autowired
	KhachHangDAO khachHangDAO;
	
	@Autowired
	NhanVienDAO nhanVienDAO;
	
	@Autowired
	CtHoaDonDAO ctHoaDonDAO;
	
	@Autowired
	PIService piService;
	
	public String theNextMa() {
		String ma = hoaDonDAO.getLastMa();
		int index = Integer.parseInt(ma.substring(2, ma.length()));
		String newmamh = "HD";
		index++;
		for(int i = 0; i < 8 - String.valueOf(index).length(); i++)
			newmamh += '0';
		newmamh += String.valueOf(index);
		return newmamh;
	}
	
	public ExportOrder convert(HoaDon var) {
		PersonalInfo temp1 = piService.getByID(var.getKhachhang().getMaKH());
		ExportOrder res = new ExportOrder();
		res.setKhachHang(temp1);
		res.setDiaChi(var.getDiaChi());
		res.setSdt(var.getSdt());
		res.setMaDonHang(var.getMaHD());
		res.setThoiGian(var.getThoiGian());
		temp1 = piService.getByID(var.getNhanvien().getMaNV());
		res.setNhanVien(temp1);
		List<ProductDetail> temp2 = new ArrayList<ProductDetail>();
		ProductDetail temp3;
		List<CtHoaDon> temp4 = ctHoaDonDAO.getbyMaHD(var.getMaHD());
		for(CtHoaDon i: temp4) {
			temp3 = new ProductDetail();
			temp3.setMaMatHang(i.getMathang().getMaMH());
			temp3.setSoLuong(i.getSoLuong());
			temp3.setGia(i.getGia().longValue());
			temp3.setGiamGia(i.getGiamgia());
			temp2.add(temp3);
		}
		res.setChiTiets(temp2);
		return res;
	}
	
	public HoaDon convert(ExportOrder var) {
		HoaDon temp1 = hoaDonDAO.getByID(var.getMaDonHang());
		if(temp1 == null)
			temp1 = new HoaDon();
		temp1.setDiaChi(var.getDiaChi());
		KhachHang temp2 = khachHangDAO.getByID(var.getKhachHang().getMa());
		temp1.setKhachhang(temp2);
		NhanVien temp3 = nhanVienDAO.getByID(var.getNhanVien().getMa());
		temp1.setNhanvien(temp3);
		temp1.setSdt(var.getSdt());
		temp1.setThoiGian(var.getThoiGian());
		return temp1;
	}
	
	public boolean add(ExportOrder var) {
		HoaDon temp1 = this.convert(var);
		temp1.setMaHD(this.theNextMa());
		if(hoaDonDAO.add(temp1))
			return true;
		return false;
	}
	
	public boolean update(ExportOrder var) {
		HoaDon temp1 = this.convert(var);
		if(hoaDonDAO.update(temp1))
			return true;
		return false;
	}
	
	public boolean delete(String ma) {
		if(hoaDonDAO.delete(ma))
			return true;
		return false;
	}
	
	public ExportOrder getByID(String ma) {
		HoaDon temp = hoaDonDAO.getByID(ma);
		if(temp == null)
			return null;
		ExportOrder res = convert(temp);
		return res;
	}
	
	public List<ExportOrder> getAll(){
		List<ExportOrder> res = new ArrayList<ExportOrder>();
		List<HoaDon> hoaDons = hoaDonDAO.getAll();
		for(HoaDon i: hoaDons) {
			res.add(convert(i));
		}
		return res;
	}
}
