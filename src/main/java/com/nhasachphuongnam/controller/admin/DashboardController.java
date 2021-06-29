package com.nhasachphuongnam.controller.admin;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.ImportOrderService;

@Controller
@RequestMapping("admin/dashboard")
public class DashboardController {
	private LocalDate end = LocalDate.now();
	//private LocalDate start = LocalDate.of(this.end.getYear(), this.end.getMonthValue(), 1);
	private LocalDate start = LocalDate.of(end.getYear(), 1, 1);
	private int type = 2; // type = 0: giữa các năm, type = 1: giữa các tháng, type = 2: giữa các ngày trong tháng
	//private List<String> danhSachThang = new ArrayList<String> (Arrays.asList("0", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
	//private String[] danhSachThang = new String[] {"0", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private Map<String, Integer> danhSachMatHangXuat;		// map < mã mặt hàng, tổng tiền>
	private long[] donXuat, donNhap, doanhThu;
	private long chart1LabelTongThu, chart1LabelTongChi, chart1LabelDoanhThu;
	private int soDonNhap, soDonXuat;
	
	@Autowired
	ExportOrderService eoService;
	
	@Autowired
	ImportOrderService ioService;
	
	private long[] doanhThuTheoThang(){
		this.doanhThu = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.donXuat = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.chart1LabelTongChi = 0;
		this.chart1LabelTongThu = 0;
		this.soDonNhap = 0;
		this.soDonXuat = 0;
			//Đơn hàng xuất - khách hàng mua
		List<ExportOrder> temp = eoService.getAllBetweenDate(start, end);
		this.danhSachMatHangXuat = new HashMap<String, Integer>();
		for(ExportOrder i: temp) {
			this.soDonXuat++;
			for(ProductDetail j: i.getChiTiets()) {
				this.donXuat[i.getThoiGian().getMonthValue() - 1] += j.getSoLuong() * j.getGia();
				this.chart1LabelTongThu += j.getSoLuong() * j.getGia();
				var prev = this.danhSachMatHangXuat.get(j.getMaMatHang());
			    if (prev == null) {
			        this.danhSachMatHangXuat.put(j.getMaMatHang(), Integer.valueOf(j.getSoLuong() * (int)j.getGia()));
			    } else {
			        this.danhSachMatHangXuat.put(j.getMaMatHang(), prev + Integer.valueOf(j.getSoLuong() * (int)j.getGia()));
			    }
			}
		}
		this.donNhap = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			//Đơn hàng nhập - mua từ nhà cung cấp
		List<ImportOrder> temp2 = ioService.getAllBetweenDate(start, end);
		for(ImportOrder i: temp2) {
			this.soDonNhap++;
			for(ProductDetail j: i.getChiTiets()) {
				this.donNhap[i.getThoiGian().getMonthValue() - 1] += j.getSoLuong() * j.getGia() * j.getGiamGia();
				this.chart1LabelTongChi += j.getSoLuong() * j.getGia() * j.getGiamGia();
			}
		}
			//Tính doanh thu
		for(int i = 0; i < 12; i++) {
			this.doanhThu[i] = this.donXuat[i] - this.donNhap[i];
		}
		this.chart1LabelDoanhThu = this.chart1LabelTongThu - this.chart1LabelTongChi;
		return donXuat;
	}
	
	public long[] doanhThuTheoNgay() {
		this.doanhThu = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.donXuat = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.chart1LabelTongChi = 0;
		this.chart1LabelTongThu = 0;
		this.soDonNhap = 0;
		this.soDonXuat = 0;
			//Đơn hàng xuất - khách hàng mua
		List<ExportOrder> temp = eoService.getAllBetweenDate(start, end);
		this.danhSachMatHangXuat = new HashMap<String, Integer>();
		for(ExportOrder i: temp) {
			this.soDonXuat++;
			for(ProductDetail j: i.getChiTiets()) {
				this.donXuat[i.getThoiGian().getDayOfMonth() - 1] += j.getSoLuong() * j.getGia();
				this.chart1LabelTongThu += j.getSoLuong() * j.getGia();
				var prev = this.danhSachMatHangXuat.get(j.getMaMatHang());
			    if (prev == null) {
			        this.danhSachMatHangXuat.put(j.getMaMatHang(), Integer.valueOf(j.getSoLuong() * (int)j.getGia()));
			    } else {
			        this.danhSachMatHangXuat.put(j.getMaMatHang(), prev + Integer.valueOf(j.getSoLuong() * (int)j.getGia()));
			    }
			}
		}
		this.donNhap = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			//Đơn hàng nhập - mua từ nhà cung cấp
		List<ImportOrder> temp2 = ioService.getAllBetweenDate(start, end);
		for(ImportOrder i: temp2) {
			this.soDonNhap++;
			for(ProductDetail j: i.getChiTiets()) {
				this.donNhap[i.getThoiGian().getDayOfMonth() - 1] += j.getSoLuong() * j.getGia() * j.getGiamGia();
				this.chart1LabelTongChi += j.getSoLuong() * j.getGia() * j.getGiamGia();
			}
		}
			//Tính doanh thu
		for(int i = 0; i < 31; i++) {
			this.doanhThu[i] = this.donXuat[i] - this.donNhap[i];
		}
		this.chart1LabelDoanhThu = this.chart1LabelTongThu - this.chart1LabelTongChi;
		return donXuat;
	}
	
	@ModelAttribute("doanhThu")
	public int chart1(ModelMap model) {
		int doanhThu = 0;
		List <String> chart1Label = new ArrayList<String>();
		if(this.type == 0) {
			
		} else if(type == 1) {
			LocalDate date1 = this.start;
			while(date1.isBefore(this.end)){
			    chart1Label.add(date1.getMonth().toString().substring(0, 3));
			    //chart1Label.add(this.danhSachThang[i]);
			    date1 = date1.plus(Period.ofMonths(1));
			}
			if(!chart1Label.contains(this.end.getMonth().toString().substring(0, 3))) {
				chart1Label.add(this.end.getMonth().toString().substring(0, 3));
			}
			/* chart1Label.add(this.end.getMonth().toString().substring(0, 3)); */
			this.doanhThuTheoThang();
				//top row
			model.addAttribute("tongDon", this.soDonNhap + this.soDonXuat);
			model.addAttribute("donNhap", this.soDonNhap);
			model.addAttribute("donXuat", this.soDonXuat);
				//chart1
			StringBuilder json = new StringBuilder(new Gson().toJson(chart1Label ));
			model.addAttribute("chart1Label", json);
			json = new StringBuilder(new Gson().toJson(this.donXuat));
			model.addAttribute("chart1TongThu", json);
			json = new StringBuilder(new Gson().toJson(this.donNhap));
			model.addAttribute("chart1TongChi", json);
			json = new StringBuilder(new Gson().toJson(this.doanhThu));
			model.addAttribute("chart1DoanhThu", json);
			model.addAttribute("chart1LabelTongThu", this.chart1LabelTongThu);
			model.addAttribute("chart1LabelTongChi", this.chart1LabelTongChi);
			model.addAttribute("chart1LabelDoanhThu", this.chart1LabelDoanhThu);
				//chart2
			LinkedHashMap<String, Integer> sortedDanhSachMatHang = new LinkedHashMap<>();
			this.danhSachMatHangXuat.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
				.forEachOrdered(x -> sortedDanhSachMatHang.put(x.getKey(), x.getValue()));
			if(sortedDanhSachMatHang.size() > 4) {
				this.danhSachMatHangXuat = new TreeMap<String, Integer>();
				int m = 0;
				for(String k: sortedDanhSachMatHang.keySet()) {
					m++;
					if(m > 4) {
						break;
					}
					this.danhSachMatHangXuat.put(k, sortedDanhSachMatHang.get(k));
				}
				json = new StringBuilder(new Gson().toJson(this.danhSachMatHangXuat.keySet()));
				model.addAttribute("chart2Label", json);
				model.addAttribute("chart2Data", this.danhSachMatHangXuat.values());
				model.addAttribute("chart2Map", this.danhSachMatHangXuat);
			} else {
				json = new StringBuilder(new Gson().toJson(sortedDanhSachMatHang.keySet()));
				model.addAttribute("chart2Label", json);
				model.addAttribute("chart2Data", sortedDanhSachMatHang.values());
				model.addAttribute("chart2Map", sortedDanhSachMatHang);
			}
		} else {
			LocalDate date1 = this.start;
			while(date1.isBefore(this.end)){
			    chart1Label.add(String.valueOf(date1.getDayOfMonth()));
			    //chart1Label.add(this.danhSachThang[i]);
			    date1 = date1.plus(Period.ofDays(1));
			}
			if(!chart1Label.contains(String.valueOf(this.end.getDayOfMonth()))) {
				chart1Label.add(String.valueOf(this.end.getDayOfMonth()));
			}
			/* chart1Label.add(this.end.getMonth().toString().substring(0, 3)); */
			this.doanhThuTheoNgay();
				//top row
			model.addAttribute("tongDon", this.soDonNhap + this.soDonXuat);
			model.addAttribute("donNhap", this.soDonNhap);
			model.addAttribute("donXuat", this.soDonXuat);
				//chart1
			StringBuilder json = new StringBuilder(new Gson().toJson(chart1Label ));
			model.addAttribute("chart1Label", json);
			json = new StringBuilder(new Gson().toJson(this.donXuat));
			model.addAttribute("chart1TongThu", json);
			json = new StringBuilder(new Gson().toJson(this.donNhap));
			model.addAttribute("chart1TongChi", json);
			json = new StringBuilder(new Gson().toJson(this.doanhThu));
			model.addAttribute("chart1DoanhThu", json);
			model.addAttribute("chart1LabelTongThu", this.chart1LabelTongThu);
			model.addAttribute("chart1LabelTongChi", this.chart1LabelTongChi);
			model.addAttribute("chart1LabelDoanhThu", this.chart1LabelDoanhThu);
				//chart2
			LinkedHashMap<String, Integer> sortedDanhSachMatHang = new LinkedHashMap<>();
			this.danhSachMatHangXuat.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
				.forEachOrdered(x -> sortedDanhSachMatHang.put(x.getKey(), x.getValue()));
			if(sortedDanhSachMatHang.size() > 4) {
				this.danhSachMatHangXuat = new TreeMap<String, Integer>();
				int m = 0;
				for(String k: sortedDanhSachMatHang.keySet()) {
					m++;
					if(m > 4) {
						break;
					}
					this.danhSachMatHangXuat.put(k, sortedDanhSachMatHang.get(k));
				}
				json = new StringBuilder(new Gson().toJson(this.danhSachMatHangXuat.keySet()));
				model.addAttribute("chart2Label", json);
				model.addAttribute("chart2Data", this.danhSachMatHangXuat.values());
				model.addAttribute("chart2Map", this.danhSachMatHangXuat);
			} else {
				json = new StringBuilder(new Gson().toJson(sortedDanhSachMatHang.keySet()));
				model.addAttribute("chart2Label", json);
				model.addAttribute("chart2Data", sortedDanhSachMatHang.values());
				model.addAttribute("chart2Map", sortedDanhSachMatHang);
			}
		}
		
		return doanhThu;
	}
	
	
	@GetMapping(value="")
	public String index(ModelMap model) {
		this.start = LocalDate.of(end.getYear(), 1, 1);
		this.type = 1;
		model.addAttribute("doanhThu", this.chart1(model));
		return "admin/dashboard/index";
	}
	
	@GetMapping(value="", params="day")
	public String day(ModelMap model) {
		this.start = LocalDate.of(this.end.getYear(), this.end.getMonthValue(), 1);
		this.type = 2;
		model.addAttribute("doanhThu", this.chart1(model));
		return "admin/dashboard/index";
	}
	
	@GetMapping(value="", params="month")
	public String month(ModelMap model) {
		this.start = LocalDate.of(end.getYear(), 1, 1);
		this.type = 1;
		model.addAttribute("doanhThu", this.chart1(model));
		return "admin/dashboard/index";
	}
	
}
