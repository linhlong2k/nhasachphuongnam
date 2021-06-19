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
import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.entity.MatHang;
import com.nhasachphuongnam.entity.NhaCungCap;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.entity.PhieuNhap;
import com.nhasachphuongnam.model.ExportOrder;
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
	
	public String theNextMa() {
		String ma = phieuNhapDAO.getLastMa();
		int index = Integer.parseInt(ma.substring(2, ma.length()));
		String newmaMH = "PN";
		index++;
		for(int i = 0; i < 8 - String.valueOf(index).length(); i++)
			newmaMH += '0';
		newmaMH += String.valueOf(index);
		return newmaMH;
	}
	
	public ImportOrder convert(PhieuNhap var) {
		ImportOrder res = new ImportOrder();
		res.setMaDonHang(var.getMaPN());
		res.setThoiGian(var.getThoiGian().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		res.setMaNhanVien(var.getNhanVien().getMaNV());
		res.setMaNhaCungCap(var.getNhaCungCap().getMaNCC());
		List<ProductDetail> temp3 = new ArrayList<ProductDetail>();
		ProductDetail temp4;
		List<CtPhieuNhap> temp5 = ctPhieuNhapDAO.getbyMaPN(var.getMaPN());
		for(CtPhieuNhap i: temp5) {
			temp4 = new ProductDetail();
			temp4.setMaMatHang(i.getMatHang().getMaMH());
			temp4.setSoLuong(i.getSoLuong());
			temp4.setGia(i.getGia().longValue());
			temp4.setGiamGia(i.getGiamGia());
			temp3.add(temp4);
		}
		res.setChiTiets(temp3);
		return res;
	}
	
	public PhieuNhap convert(ImportOrder var) {
		PhieuNhap res = phieuNhapDAO.getByID(var.getMaDonHang());
		if(res == null)
			res = new PhieuNhap();
		NhaCungCap temp1 = nhaCungCapDAO.getByID(var.getMaNhaCungCap());
		res.setNhaCungCap(temp1);
		NhanVien temp2 = nhanVienDAO.getByID(var.getMaNhanVien());
		res.setNhanVien(temp2);
		res.setThoiGian(Date.from(var.getThoiGian().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
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
		PhieuNhap temp1 = new PhieuNhap();
		temp1.setMaPN(this.theNextMa());
		temp1.setThoiGian(Date.from(var.getThoiGian().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		NhanVien temp2 = nhanVienDAO.getByID(var.getMaNhanVien());
		temp1.setNhanVien(temp2);
		NhaCungCap temp3 = nhaCungCapDAO.getByID(var.getMaNhaCungCap());
		temp1.setNhaCungCap(temp3);
		List<CtPhieuNhap> ctPhieuNhap = new ArrayList<>();
		for(ProductDetail i: var.getChiTiets()) {
			CtPhieuNhapPK pk = new CtPhieuNhapPK();
			pk.setMaPN(temp1.getMaPN());
			pk.setMaMH(i.getMaMatHang());
			CtPhieuNhap temp4 = new CtPhieuNhap();
			temp4.setId(pk);
			temp4.setGiamGia(i.getGiamGia());
			temp4.setGia(BigDecimal.valueOf(i.getGia()));
			temp4.setSoLuong(i.getSoLuong());
			matHangDAO.changeSoLuong(i.getMaMatHang(), i.getSoLuong());
			ctPhieuNhap.add(temp4);
		}
		temp1.setCtPhieuNhaps(ctPhieuNhap);
		if(phieuNhapDAO.add(temp1))
			return temp1.getMaPN();
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
	
	public List<ImportOrder> GetAllBetweenDate(LocalDate start, LocalDate end){
		List<ImportOrder>  res = new ArrayList<ImportOrder>();
		List<PhieuNhap> temp = phieuNhapDAO.getBetweenThoiGian(Date.from(start.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), Date.from(end.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		for(PhieuNhap i: temp) {
			res.add(convert(i));
		}
		return res;
	}
}
