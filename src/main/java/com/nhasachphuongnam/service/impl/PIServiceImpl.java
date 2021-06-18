package com.nhasachphuongnam.service.impl;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.KhachHangDAO;
import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.dao.TaiKhoanDAO;
import com.nhasachphuongnam.entity.KhachHang;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.entity.TaiKhoan;
import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.service.PIService;

@Repository
@Transactional
public class PIServiceImpl implements PIService{
	/*
	 * phần service này không xử lý các thông tin liên quan đến username, passord, role
	 */
	
	@Autowired(required = true)
	KhachHangDAO khachHangDAO;
	
	@Autowired(required = true)
	NhanVienDAO nhanVienDAO;
	
	@Autowired(required = true)
	TaiKhoanDAO taiKhoanDAO;
	
	public PersonalInfo convert(KhachHang khachHang) {
		PersonalInfo pi = new PersonalInfo(khachHang.getMaKH(), khachHang.getTenKH(), khachHang.getHinhAnh(), khachHang.getDiaChi(), khachHang.getNgaySinh(), khachHang.getSdt(), khachHang.getTaikhoan().getUsername(), khachHang.getTaikhoan().getRole().getMaRole());
		return pi;
	}
	
	public PersonalInfo convert(NhanVien nhanVien) {
		PersonalInfo pi = new PersonalInfo(nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.getHinhAnh(), nhanVien.getDiaChi(), nhanVien.getNgaySinh(), nhanVien.getSdt(), nhanVien.getTaikhoan().getUsername(), nhanVien.getTaikhoan().getRole().getMaRole());
		return pi;
	}
	
	//không chỉnh các thông tin như username, role của người dùng
	public KhachHang convert2KhachHang(PersonalInfo pi) {
		KhachHang khachHang = khachHangDAO.getByID(pi.getMa());
		if(khachHang == null) {
			khachHang = new KhachHang();
			khachHang.setMaKH(pi.getMa());
		}
		khachHang.setTenKH(pi.getTen());
		if(pi.getHinhAnh() != null)
			khachHang.setHinhAnh(pi.getHinhAnh());
		if(pi.getSoDienThoai() != null)
			khachHang.setSdt(pi.getSoDienThoai());
		if(pi.getDiaChi() != null)
			khachHang.setDiaChi(pi.getDiaChi());
		if(pi.getNgaySinh() != null)
			khachHang.setNgaySinh(Date.from(pi.getNgaySinh().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		khachHang.setTaikhoan(taiKhoanDAO.getByID(pi.getUsername()));
		return khachHang;
	}
	
	public NhanVien convert2NhanVien(PersonalInfo pi) {
		NhanVien nhanVien =  nhanVienDAO.getByID(pi.getMa());
		if(nhanVien == null) {
			nhanVien = new NhanVien();
			nhanVien.setMaNV(pi.getMa());
		}
		nhanVien.setTenNV(pi.getTen());
		if(pi.getHinhAnh() != null)
			nhanVien.setHinhAnh(pi.getHinhAnh());
		if(pi.getSoDienThoai() != null)
			nhanVien.setSdt(pi.getSoDienThoai());
		if(pi.getDiaChi() != null)
			nhanVien.setDiaChi(pi.getDiaChi());
		if(pi.getNgaySinh() != null)
			nhanVien.setNgaySinh(Date.from(pi.getNgaySinh().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		nhanVien.setTaikhoan(taiKhoanDAO.getByID(pi.getUsername()));
		return nhanVien;
	}
	
	public String theNextMaKH() {
		String ma = khachHangDAO.getLastMa();
		int index = Integer.parseInt(ma.substring(2, ma.length()));
		String newma = "KH";
		index++;
		for(int i = 0; i < 8 - String.valueOf(index).length(); i++)
			newma += '0';
		newma += String.valueOf(index);
		return newma;
	}
	
	public String theNextMaNV() {
		String ma = nhanVienDAO.getLastMa();
		int index = Integer.parseInt(ma.substring(2, ma.length()));
		String newma = "NV";
		index++;
		for(int i = 0; i < 8 - String.valueOf(index).length(); i++)
			newma += '0';
		newma += String.valueOf(index);
		return newma;
	}
	
	public boolean add(PersonalInfo pi, Login login) {
		if(pi.getMaRole().equals("2")) {
			KhachHang khachHang = new KhachHang();
			khachHang.setMaKH(this.theNextMaKH());
			khachHang.setTenKH(pi.getTen());
			khachHang.setHinhAnh(pi.getHinhAnh());
			khachHang.setDiaChi(pi.getDiaChi());
			khachHang.setNgaySinh(Date.from(pi.getNgaySinh().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			khachHang.setSdt(pi.getSoDienThoai());
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setUsername(login.getUsername());
			taiKhoan.setPassword(login.getPassword());
			taiKhoan.setRole(login.getRole().toRole());
			khachHang.setTaikhoan(taiKhoan);
			if(khachHangDAO.add(khachHang)) {
				return true;
			}
			return false;
		} else {
			NhanVien nhanVien = new NhanVien();
			nhanVien.setMaNV(this.theNextMaNV());
			nhanVien.setDiaChi(pi.getDiaChi());
			nhanVien.setHinhAnh(pi.getHinhAnh());
			nhanVien.setNgaySinh(Date.from(pi.getNgaySinh().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			nhanVien.setSdt(pi.getSoDienThoai());
			nhanVien.setTenNV(pi.getTen());
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setUsername(login.getUsername());
			taiKhoan.setPassword(login.getPassword());
			taiKhoan.setRole(login.getRole().toRole());
			nhanVien.setTaikhoan(taiKhoan);
			if(nhanVienDAO.add(nhanVien)) {
				return true;
			}
			return false;
		}
	}
	
	public boolean update(PersonalInfo pi) {
		if(pi.getMaRole().equals("2")) {
			KhachHang khachHang = convert2KhachHang(pi);
			if(khachHangDAO.update(khachHang))
				return true;
			return false;
			
		} else {
			NhanVien nhanVien = convert2NhanVien(pi);
			if(nhanVienDAO.update(nhanVien))
				return true;
			return false;
		}
	}
	
	//delete this ProductType and setAllow(false) for product producttype items
	public boolean delete(String ma) {
		if(ma.substring(0, 2).equals("KH")) {
			if(khachHangDAO.delete(ma))
				return true;
			return false;
		} else {
			if(nhanVienDAO.delete(ma))
				return true;
			return false;
		}
	}
	
	public PersonalInfo getByID(String ma) {
		if(ma.substring(0, 2).equals("KH")) {
			KhachHang khachHang = khachHangDAO.getByID(ma);
			if(khachHang == null)
				return null;
			return convert(khachHang);
		} else {
			NhanVien nhanVien = nhanVienDAO.getByID(ma);
			if(nhanVien == null)
				return null;
			return convert(nhanVien);
		}
	}
	
	public List<PersonalInfo> getAllKhachHang(){
		List<KhachHang> khachHangs = khachHangDAO.getAll();
		List<PersonalInfo> pis = new ArrayList<PersonalInfo>();
		for(KhachHang i: khachHangs)
			pis.add(convert(i));
		return pis;
	}
	
	public List<PersonalInfo> getAllNhanVien(){
		List<NhanVien> nhanViens = nhanVienDAO.getAll();
		List<PersonalInfo> pis = new ArrayList<PersonalInfo>();
		for(NhanVien i: nhanViens)
			pis.add(convert(i));
		return pis;
	}
	
	public boolean capNhapAnh(String id, byte[] photo) {
		if(id.substring(0, 2).equals("KH")) {
			KhachHang khachHang = khachHangDAO.getByID(id);
			if(khachHang == null) {
				return false;
			}
			khachHang.setHinhAnh(photo);
			if(khachHangDAO.update(khachHang)) {
				return true;
			}
		} else {
			NhanVien nhanVien = nhanVienDAO.getByID(id);
			if(nhanVien == null) {
				return false;
			}
			nhanVien.setHinhAnh(photo);
			if(nhanVienDAO.update(nhanVien)) {
				return true;
			}
		}
		return false;
	}
}
