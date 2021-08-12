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

import com.nhasachphuongnam.dao.CtHoaDonDAO;
import com.nhasachphuongnam.dao.HoaDonDAO;
import com.nhasachphuongnam.dao.KhachHangDAO;
import com.nhasachphuongnam.dao.MatHangDAO;
import com.nhasachphuongnam.dao.NhanVienDAO;
import com.nhasachphuongnam.dao.PhieuNhapDAO;
import com.nhasachphuongnam.entity.CtHoaDon;
import com.nhasachphuongnam.entity.CtHoaDonPK;
import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.entity.KhachHang;
import com.nhasachphuongnam.entity.NhanVien;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.service.ExportOrderService;

@Repository
@Transactional
public class ExportOrderServiceImpl implements ExportOrderService{
	
	@Autowired
	MatHangDAO matHangDAO;

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
	
	public String theNextID() {
		String ma = hoaDonDAO.getLastMa();
		if(ma == null) {
			return "HD00000001";
		}
		int index = Integer.parseInt(ma.substring(2, ma.length())) + 1;
		StringBuilder newmaMH = new StringBuilder("HD");
		for(int i = 0; i < 8 - String.valueOf(index).length(); i++) {
			newmaMH.append('0');
		}
		newmaMH.append(index);
		return newmaMH.toString();
	}
	
	public ExportOrder convert(HoaDon var) {
		ExportOrder res = new ExportOrder();
		if(var.getKhachHang() != null) {
			res.setMaKhachHang(var.getKhachHang().getMaKH());
		}
		if(var.getNhanVien() != null) {
			res.setMaNhanVien(var.getNhanVien().getMaNV());
		}
		res.setDiaChi(var.getDiaChi());
		res.setSdt(var.getSdt());
		res.setMaDonHang(var.getMaHD());
		res.setThoiGian(var.getThoiGian().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		res.setTinhTrang(var.getTinhTrang());
		res.setGiamGia(var.getGiamGia());
		List<ProductDetail> temp2 = new ArrayList<ProductDetail>();
		ProductDetail temp3;
		List<CtHoaDon> temp4 = ctHoaDonDAO.getbyMaHD(var.getMaHD());
		for(CtHoaDon i: temp4) {
			temp3 = new ProductDetail();
			temp3.setMaMatHang(i.getMatHang().getMaMH());
			temp3.setTenMatHang(i.getMatHang().getTenMH());
			temp3.setSoLuong(i.getSoLuong());
			temp3.setGia(i.getGia().longValue());
			/* temp3.setGiamGia(i.getGiamgia()); */
			temp2.add(temp3);
		}
		res.setChiTiets(temp2);
		return res;
	}
	

	public HoaDon convert(ExportOrder var) {
		HoaDon temp1 = hoaDonDAO.getByID(var.getMaDonHang());
		if (temp1 == null)
			temp1 = new HoaDon();
		temp1.setDiaChi(var.getDiaChi());
		if(var.getMaKhachHang() != null) {
			KhachHang temp2 = khachHangDAO.getByID(var.getMaKhachHang());
			temp1.setKhachHang(temp2);
		}
		if(var.getMaNhanVien() != null) {
			NhanVien temp3 = nhanVienDAO.getByID(var.getMaNhanVien());
			temp1.setNhanVien(temp3);
		}
		temp1.setSdt(var.getSdt());
		temp1.setThoiGian(Date.from(var.getThoiGian().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		temp1.setGiamGia(var.getGiamGia());
		temp1.setTinhTrang(var.getTinhTrang());
		return temp1;
	}

	public String add(ExportOrder var) {
		HoaDon temp1 = new HoaDon();	//tọa HoaDon mới
		temp1.setMaHD(this.theNextID());	//Thêm mã đơn hàng cho hóa đơn vừa tạo
		if(var.getMaKhachHang() == null) {
			temp1.setKhachHang(null);
		} else {
			try {
				//cập nhật mã khách hàng cho đơn hàng
				temp1.setKhachHang(khachHangDAO.getByID(var.getMaKhachHang()));	
			} catch (Exception e) {	//kiểm tra null
				e.printStackTrace();
				return null;
			}
		}
		if(var.getMaNhanVien() == null) {
			temp1.setNhanVien(null);
		} else {
			try {
				temp1.setNhanVien(nhanVienDAO.getByID(var.getMaNhanVien()));
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		temp1.setSdt(var.getSdt());		//thêm số điện thoại cho đơn hàng
		//thêm thông tin thời gian cho đơn hàng và convert thời gian từ LocalDate sang Date để phù hợp với jpa hibernate 4
		temp1.setThoiGian(Date.from(var.getThoiGian().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		temp1.setGiamGia(var.getGiamGia());		//thêm thông tin giảm giá cho đơn hàng
		temp1.setTinhTrang(var.getTinhTrang());	//Chuyển đơn hàng sang trạng thái đặt hàng
		temp1.setDiaChi(var.getDiaChi());	//thêm thông tin địa chỉ nhận hàng
		List<CtHoaDon> CTHoaDons = new ArrayList<CtHoaDon>();
		CtHoaDon temp2;
		//thêm CtHoaDon vào trong đơn hàng
		for(ProductDetail i: var.getChiTiets()) {
			CtHoaDonPK pk = new CtHoaDonPK();	//khóa chính của CtHoaDon
			pk.setMaHD(temp1.getMaHD());
			pk.setMaMH(i.getMaMatHang());
			temp2 = new CtHoaDon();	//CtHoaDon
			temp2.setId(pk);	//set khóa chính cho CtHoaDon
			temp2.setSoLuong(i.getSoLuong());	//set số lượng cho CtHoaDon
			temp2.setGia(BigDecimal.valueOf(i.getGia()));	//set giá tiền cho CtHoaDon
			//thay đổi số lượng của mặt hàng
			matHangDAO.changeSoLuong(i.getMaMatHang(), 0 - i.getSoLuong());
			CTHoaDons.add(temp2);	//Thêm CtHoaDon vào trong đơn hàng
		}
		temp1.setCtHoaDons(CTHoaDons);	//Thêm CtHoaDon vào trong đơn hàng
		if(hoaDonDAO.add(temp1))	//Thêm đơn hàng
			return temp1.getMaHD();		//trả về mã đơn hàng của đơn hàng vừa tạo
		return null;
	}
	
	public boolean update(ExportOrder var) {
		HoaDon temp1 = this.convert(var);
		if(hoaDonDAO.update(temp1))
			return true;
		return false;
	}
	
	public boolean delete(String ma) {
		List<CtHoaDon> ctHoaDons = ctHoaDonDAO.getbyMaHD(ma);
		if(hoaDonDAO.delete(ma)) {
			for(CtHoaDon i: ctHoaDons) {
				matHangDAO.changeSoLuong(i.getMatHang().getMaMH(), i.getSoLuong());
			}
			return true;
		}
		return false;
	}
	
	public ExportOrder getByID(String ma) {
		HoaDon temp = hoaDonDAO.getByID(ma);
		if(temp == null) {
			return null;
		}
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
	
	public List<ExportOrder> getAllByCustomerID(String id){
		List<ExportOrder> res = new ArrayList<ExportOrder>();
		List<HoaDon> temp = hoaDonDAO.getHoaDonByMaKhachHang(id);
		for(HoaDon i: temp) {
			res.add(convert(i));
		}
		return res;
	}
	
	public List<ExportOrder> getAllByStaffID(String id){
		List<ExportOrder> res = new ArrayList<ExportOrder>();
		List<HoaDon> temp = hoaDonDAO.getHoaDonByMaNhanVien(id);
		for(HoaDon i: temp) {
			res.add(convert(i));
		}
		return res;
	}
	
	public List<ExportOrder> getAllBetweenDate(LocalDate start, LocalDate end) {
		List<ExportOrder>  res = new ArrayList<ExportOrder>();	//tạo danh sách đơn hàng
		//Lấy danh sách các đơn hàng có trong khoảng thời gian cho nhập vào đồng thời chuyển đổi kiểu dữ liệu từ LocalDate sang Date cho phù hợp
		List<HoaDon> temp = hoaDonDAO.getBetweenThoiGian(Date.from(start.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), Date.from(end.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		for(HoaDon i: temp) {
			res.add(convert(i));	//thêm các đơn hàng vừa lấy được vào danh sách các đơn hàng trả về
		}
		return res;	//trả về danh sách cách đơn hàng vừa lấy được
	}


	public List<ExportOrder> getDanhSachUserOrder(){
		List<ExportOrder> res = new ArrayList<ExportOrder>();
		List<HoaDon> hoaDons = hoaDonDAO.getAll();
		for(HoaDon i: hoaDons) {
			if(i.getTinhTrang().equals("1")) {
				res.add(convert(i));
			}
		}
		return res;
	}
	
	public List<ExportOrder> getDanhSachUserDeliveryOrder(){
		List<ExportOrder> res = new ArrayList<ExportOrder>();
		List<HoaDon> hoaDons = hoaDonDAO.getAll();
		for(HoaDon i: hoaDons) {
			if(i.getTinhTrang().equals("2")) {
				res.add(convert(i));
			}
		}
		return res;
	}
	
	public List<Product> getDanhSachMatHangByExportOrderID(String ma){
		List<Product> res = new ArrayList<>();
		List<CtHoaDon> temp = ctHoaDonDAO.getbyMaHD(ma);
		Product temp2;
		if(temp != null) {
			for(CtHoaDon i: temp) {
				temp2 = new Product(i.getMatHang().getMaMH(), i.getMatHang().getTenMH(), i.getMatHang().getHinhAnh(), i.getSoLuong(), "", "", i.getMatHang().getAllow(), i.getGia().longValue(), Float.valueOf(0), i.getMatHang().getLoaiMatHang().getMaLoai());
				res.add(temp2);
			}
		}
		return res;
	}
	
	public String confirmUserOrder(String ma, String maNhanVien) {
		HoaDon temp = hoaDonDAO.getByID(ma);
		NhanVien temp2 = nhanVienDAO.getByID(maNhanVien);
		if(temp == null || temp2 == null) {
			return null;
		}
		temp.setNhanVien(temp2);
		temp.setTinhTrang("2");
		if(hoaDonDAO.update(temp)) {
			return ma;
		}
		return null;
	}
	
	public String comfirmUserDeliveryOrder(String ma) {
		HoaDon temp = hoaDonDAO.getByID(ma);
		if(temp == null) {
			return null;	
		}
		temp.setTinhTrang("3");
		if(hoaDonDAO.update(temp)) {
			return ma;
		}
		return null;
	}
}
