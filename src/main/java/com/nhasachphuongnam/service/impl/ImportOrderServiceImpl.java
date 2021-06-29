package com.nhasachphuongnam.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.CtPhieuNhapDAO;
import com.nhasachphuongnam.dao.KhachHangDAO;
import com.nhasachphuongnam.dao.MatHangDAO;
import com.nhasachphuongnam.dao.NhaCungCapDAO;
import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.dao.PhieuNhapDAO;
import com.nhasachphuongnam.entity.CtPhieuNhap;
import com.nhasachphuongnam.entity.CtPhieuNhapPK;
import com.nhasachphuongnam.entity.MatHang;
import com.nhasachphuongnam.entity.NhaCungCap;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.entity.PhieuNhap;
import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.model.ProductDetail;
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
	MatHangDAO matHangDAO;
	
	@Autowired
	PIService piService;
	
	@Autowired
	SupplierService supplierService;
	
	public String theNextID() {
		String ma = phieuNhapDAO.getLastMa();
		if(ma == null) {
			return "PN00000001";
		}
		int index = Integer.parseInt(ma.substring(2, ma.length())) + 1;
		StringBuilder newMaPN = new StringBuilder("PN");
		for(int i = 0; i < 8 - String.valueOf(index).length(); i++) {
			newMaPN.append('0');
		}
		newMaPN.append(index);
		return newMaPN.toString();
	}
	
	public ImportOrder convert(PhieuNhap var) {
		ImportOrder res = new ImportOrder();
		res.setMaDonHang(var.getMaPN());
		res.setThoiGian(var.getThoiGian().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		if(var.getNhanVien() != null) {
			res.setMaNhanVien(var.getNhanVien().getMaNV());
		}
		if(var.getNhaCungCap() != null) {
			res.setMaNhaCungCap(var.getNhaCungCap().getMaNCC());
		}
		List<ProductDetail> productDetailList = new ArrayList<ProductDetail>();
		ProductDetail productDetail;
		List<CtPhieuNhap> ctPhieuNhapList = ctPhieuNhapDAO.getbyMaPN(var.getMaPN());
		for(CtPhieuNhap i: ctPhieuNhapList) {
			productDetail = new ProductDetail();
			productDetail.setMaMatHang(i.getMatHang().getMaMH());
			productDetail.setTenMatHang(i.getMatHang().getTenMH());
			productDetail.setSoLuong(i.getSoLuong());
			productDetail.setGia(i.getGia().longValue());
			productDetail.setGiamGia(i.getGiamGia());
			productDetailList.add(productDetail);
		}
		res.setChiTiets(productDetailList);
		return res;
	}
	
	public PhieuNhap convert(ImportOrder var) {
		PhieuNhap res = phieuNhapDAO.getByID(var.getMaDonHang());
		if(res == null) {
			return null;
		}
		if(var.getMaNhaCungCap() != null) {
			NhaCungCap temp1 = nhaCungCapDAO.getByID(var.getMaNhaCungCap());
			res.setNhaCungCap(temp1);
		}
		if(var.getMaNhanVien() != null) {
			NhanVien temp2 = nhanVienDAO.getByID(var.getMaNhanVien());
			res.setNhanVien(temp2);
		}
		//res.setThoiGian(Date.from(var.getThoiGian().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		return res;
	}
	
	public CtPhieuNhap convert(ProductDetail var) {
		CtPhieuNhap res = new CtPhieuNhap();
		MatHang temp = matHangDAO.getByID(var.getMaMatHang());
		res.setMatHang(temp);
		res.setSoLuong(var.getSoLuong());
		res.setGia(BigDecimal.valueOf(var.getGia()));
		res.setGiamGia(var.getGiamGia());
		return res;
	}
	
	//chưa cập nhập số lượng của mặt hàng
	public String add(ImportOrder var) {
		PhieuNhap res = new PhieuNhap();
		res.setMaPN(this.theNextID());
		res.setThoiGian(Date.from(var.getThoiGian().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		if(var.getMaNhanVien() != null) {
			NhanVien nhanVien = nhanVienDAO.getByID(var.getMaNhanVien());
			res.setNhanVien(nhanVien);
		}
		if(var.getMaNhaCungCap() != null) {
			NhaCungCap nhaCungCap = nhaCungCapDAO.getByID(var.getMaNhaCungCap());
			res.setNhaCungCap(nhaCungCap);
		}
		CtPhieuNhapPK ctPhieuNhapPK;
		CtPhieuNhap ctPhieuNhap;
		List<CtPhieuNhap> ctPhieuNhapList = new ArrayList<>();
		for(ProductDetail i: var.getChiTiets()) {
			ctPhieuNhapPK = new CtPhieuNhapPK();
			ctPhieuNhapPK.setMaPN(res.getMaPN());
			ctPhieuNhapPK.setMaMH(i.getMaMatHang());
			ctPhieuNhap = new CtPhieuNhap();
			ctPhieuNhap.setId(ctPhieuNhapPK);
			ctPhieuNhap.setGiamGia(i.getGiamGia());
			ctPhieuNhap.setGia(BigDecimal.valueOf(i.getGia()));
			ctPhieuNhap.setSoLuong(i.getSoLuong());
			matHangDAO.changeSoLuong(i.getMaMatHang(), i.getSoLuong());
			ctPhieuNhapList.add(ctPhieuNhap);
		}
		res.setCtPhieuNhaps(ctPhieuNhapList);
		if(phieuNhapDAO.add(res))
			return res.getMaPN();
		return null;
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
	
	public List<ImportOrder> getAllBetweenDate(LocalDate start, LocalDate end){
		List<ImportOrder>  res = new ArrayList<ImportOrder>();
		List<PhieuNhap> temp = phieuNhapDAO.getBetweenThoiGian(Date.from(start.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), Date.from(end.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		for(PhieuNhap i: temp) {
			res.add(convert(i));
		}
		return res;
	}
}
