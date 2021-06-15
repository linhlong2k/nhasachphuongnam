package com.nhasachphuongnam.controller.admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	private Map<String, Integer> danhSachMatHangXuat; // map < mã mặt hàng, tổng tiền>
	private long[] donXuat, donNhap, doanhThu;
	
	
	@Autowired
	ExportOrderService eoService;
	
	@Autowired
	ImportOrderService ioService;
	
	private long[] doanhThuTheoThang(){
		this.doanhThu = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.donXuat = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		List<ExportOrder> temp = eoService.GetAllBetweenDate(start, end);
		this.danhSachMatHangXuat = new HashMap<String, Integer>();
		for(ExportOrder i: temp) {
			for(ProductDetail j: i.getChiTiets()) {
				this.donXuat[i.getThoiGian().getMonthValue() - 1] += j.getSoLuong() * j.getGia();
				var prev = this.danhSachMatHangXuat.get(j.getMaMatHang());
			    if (prev == null) {
			        this.danhSachMatHangXuat.put(j.getMaMatHang(), Integer.valueOf(j.getSoLuong() * (int)j.getGia()));
			    } else {
			        this.danhSachMatHangXuat.put(j.getMaMatHang(), prev + Integer.valueOf(j.getSoLuong() * (int)j.getGia()));
			    }
			}
		}
		this.donNhap = new long [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		List<ImportOrder> temp2 = ioService.GetAllBetweenDate(start, end);
		for(ImportOrder i: temp2) {
			for(ProductDetail j: i.getChiTiets()) {
				this.donNhap[i.getThoiGian().getMonthValue() - 1] += j.getSoLuong() * j.getGia() * j.getGiamGia();
			}
		}
		for(int i = 0; i < 12; i++) {
			this.doanhThu[i] = this.donXuat[i] - this.donNhap[i];
		}
		return donXuat;
	}
	
	@ModelAttribute("doanhThu")
	public int chart1(ModelMap model) {
		int doanhThu = 0;
		List <String> chart1Label = new ArrayList<String>();
		int i, j;
		if(type == 0) {
			
		} else if(type == 1) {
			for(i = (start.getMonthValue() + 1) % 12; i <= end.getMonthValue(); i++) {
				chart1Label.add(this.danhSachThang[i]);
			}
				//chart1
			StringBuilder json = new StringBuilder(new Gson().toJson(chart1Label ));
			model.addAttribute("chart1Label", json);
			this.doanhThuTheoThang();
			json = new StringBuilder(new Gson().toJson(this.donXuat));
			model.addAttribute("chart1TongThu", json);
			json = new StringBuilder(new Gson().toJson(this.donNhap));
			model.addAttribute("chart1TongChi", json);
			json = new StringBuilder(new Gson().toJson(this.doanhThu));
			model.addAttribute("chart1DoanhThu", json);
				//chart2
			List<String> temp = this.danhSachMatHangXuat.keySet().stream().collect(Collectors.toList());
			json = new StringBuilder(new Gson().toJson(temp));
			model.addAttribute("chart2Label", json);
			List<Integer> temp2 = this.danhSachMatHangXuat.values().stream().collect(Collectors.toList());
			model.addAttribute("chart2Data", temp2);
		} else {
			
		}
		
		return doanhThu;
	}
	
	
	@RequestMapping("index")
	public String index() {
		return "admin/dashboard/index";
	}
}
