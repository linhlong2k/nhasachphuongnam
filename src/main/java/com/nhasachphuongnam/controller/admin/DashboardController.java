package com.nhasachphuongnam.controller.admin;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.nhasachphuongnam.model.ExportOrder;
import com.nhasachphuongnam.model.ImportOrder;
import com.nhasachphuongnam.model.ProductDetail;
import com.nhasachphuongnam.service.ExportOrderService;
import com.nhasachphuongnam.service.ImportOrderService;

@Controller
@RequestMapping("admin/dashboard/")
public class DashboardController {
	private LocalDate end = LocalDate.now();
	private LocalDate start = LocalDate.of(end.getYear()-1, 12, 31);
	private int type = 1; // type = 0: giữa các năm, type = 1: giữa các tháng, 
	//private List<String> danhSachThang = new ArrayList<String> (Arrays.asList("0", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
	private String[] danhSachThang = new String[] {"0", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
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
		List<ExportOrder> temp = eoService.GetAllBetweenDate(start, end);
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
		List<ImportOrder> temp2 = ioService.GetAllBetweenDate(start, end);
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
	
	@ModelAttribute("doanhThu")
	public int chart1(ModelMap model) {
		int doanhThu = 0;
		List <String> chart1Label = new ArrayList<String>();
		int i;
		if(type == 0) {
			
		} else if(type == 1) {
			for(i = (start.getMonthValue() + 1) % 12; i <= end.getMonthValue(); i++) {
				chart1Label.add(this.danhSachThang[i]);
			}
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
			
		}
		
		return doanhThu;
	}
	
	
	@RequestMapping("index")
	public String index() {
		return "admin/dashboard/index";
	}
}
