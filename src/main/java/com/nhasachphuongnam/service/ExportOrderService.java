package com.nhasachphuongnam.service;

import java.time.LocalDate;
import java.util.List;

import com.nhasachphuongnam.entity.HoaDon;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.Product;

public interface ExportOrderService {
	//chuyển đổi giữa đối tượng HoaDon với ExportOrder (giữa entity với model)
	ExportOrder convert(HoaDon var);
	//Thêm đơn hàng mới và trả về mã đơn hàng của đơn hàng mới
	String add(ExportOrder var);
	//Cập nhật thông tin mới của đơn hàng
	boolean update(ExportOrder var);
	//Xóa đơn hàng thông qua mã đơn hàng
	boolean delete(String ma);
	//Tìm đơn hàng theo mã đơn hàng
	ExportOrder getByID(String ma);
	//Lấy danh sách toàn bộ đơn hàng trong database
	List<ExportOrder> getAll();
	//Lấy toàn bộ đơn hàng có mã khách hàng là id
	List<ExportOrder> GetAllByMaKH(String id);
	//Lấy toàn bộ đơn hàng phụ trách bởi nhân viên có mã nhân viên là id
	List<ExportOrder> getAllByMaNV(String id);
	//Lấy danh sách đơn hàng đã hoàn thành trong khoản thời gian
	List<ExportOrder> GetAllBetweenDate(LocalDate start, LocalDate end);
	//Lấy danh sách các đơn đặt hàng của khách hàng
	List<ExportOrder> getDanhSachDatHang();
	//Lấy danh sách các mặt hàng có trong hóa đơn có mã là ma
	List<Product> getDanhSachMatHangByMaHD(String ma);
	//Lấy danh sách đơn hàng đang ở trạng thái giao hàng
	List<ExportOrder> getDanhSachGiaoHang();
	//Xác nhận đặt hàng - đơn hàng chuyển sang trạng thái giao hàng
	String xacNhanDatHang(String ma, String maNhanVien);
	//Xác nhận nhận hàng - đơn hàng chuyển sang trạng thái hoàn thành
	String xacNhanNhanHang(String ma);
}
