package com.nhasachphuongnam.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.model.ProductType;
import com.nhasachphuongnam.service.ProductService;
import com.nhasachphuongnam.service.ProductTypeService;

@Controller
@RequestMapping("/mat-hang/") 
public class ProductController {
	
	@Autowired(required=true)
	ProductService productService;
	
	@Autowired(required=true)
	ProductTypeService productTypeService;
	
	@Autowired
	ServletContext context;
	
	//===============================================Model-Attribute===================================
	
	@ModelAttribute("danhSachMatHang")
	public List<Product> danhSachMatHang(){
		List<Product> matHangs = productService.getAll();
		return matHangs;
	}
	
	@ModelAttribute("matHangMoi")
	public Product matHangMoi(){
		return new Product();
	}
	
	@ModelAttribute("matHangChinhSua")
	public Product matHangChinhSua(){
		return new Product();
	}
	
	@ModelAttribute("danhSachLoaiMatHang")
	public List<ProductType> danhSachLoaiMatHang(){
		List<ProductType> loaiMatHangs = productTypeService.getAll();
		return loaiMatHangs;
	}
	
	@ModelAttribute("loaiMatHangMoi")
	public ProductType loaiMatHangMoi() {
		return new ProductType();
	}
	
	@ModelAttribute("loaiMatHangChinhSua")
	public ProductType loaiMatHangChinhSua(ProductType var) {
		return var;
	}
	
	//===============================================Controller========================================
	@RequestMapping("index")
	public String list(ModelMap model) {
		return "admin/product/list";
	}
	
	@RequestMapping(value="tao-mat-hang-moi", method=RequestMethod.GET)
	public String createGet(ModelMap model) {
		return "admin/product/createProduct";
	}
	
	@RequestMapping(value="tao-mat-hang-moi", method=RequestMethod.POST)
	public String createPost(ModelMap model,
			@ModelAttribute("matHangMoi") Product product,
			BindingResult errors) {
			//check input value
		//tenMatHang
		if (product.getTenMatHang().trim().length() == 0) {
			errors.rejectValue("tenMatHang", "matHangMoi", "Vui lòng nhập tên mặt hàng!");
		} else if(product.getTenMatHang().trim().length() > 50) {
			errors.rejectValue("tenMatHang", "matHangMoi", "Tên mặt hàng quá dài");
		}
		//gia
		if (product.getGia() <= 0) {
			errors.rejectValue("Gia", "matHangMoi", "Giá tiền nhập vào không hợp lệ!");
		}
		//soLuong
		if (product.getSoLuong() != (int)product.getSoLuong()) {
			errors.rejectValue("soLuong", "matHangMoi", "Vui lòng nhập số lượng đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("soLuong", "matHangMoi", "Số lượng không hợp lệ!");
		}
		//Loai Mat Hang
		if (product.getMaLoai() == null) {
			errors.rejectValue("maLoai", "matHangMoi", "Vui lòng chọn một loại mặt hàng!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
			
		} else {
			if(productService.add(product)) {
				model.addAttribute("message", "Tạo mặt hàng mới thành công");
			} else {
				model.addAttribute("message", "Tạo mặt hàng mới không thành công!");
			}
		}
		model.addAttribute("danhSachMatHang", productService.getAll());
		return "admin/product/createProduct";
	}
	
	@RequestMapping(value="chinh-sua-mat-hang/{id}", method=RequestMethod.GET)
	public String updateGet(ModelMap model,
			@PathVariable("id") String maMatHang) {
		Product product = productService.getByID(maMatHang);
		model.addAttribute("matHangChinhSua", product); 
		return "admin/product/update";
	}
	
	@RequestMapping(value="chinh-sua-mat-hang", method=RequestMethod.POST)
	public String updatePost(ModelMap model,
			@ModelAttribute("matHangChinhSua") Product product,
			BindingResult errors) {
			// check input value
		// tenMatHang
		if (product.getTenMatHang().trim().length() == 0) {
			errors.rejectValue("tenMatHang", "matHangChinhSua", "Vui lòng nhập tên mặt hàng!");
		} else if (product.getTenMatHang().trim().length() > 50) {
			errors.rejectValue("tenMatHang", "matHangChinhSua", "Tên mặt hàng quá dài");
		}
		// gia
		if (product.getGia() <= 0) {
			errors.rejectValue("Gia", "matHangChinhSua", "Giá tiền nhập vào không hợp lệ!");
		}
		// soLuong
		if (product.getSoLuong() != (int) product.getSoLuong()) {
			errors.rejectValue("soLuong", "matHangChinhSua", "Vui lòng nhập số lượng đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("soLuong", "matHangChinhSua", "Số lượng không hợp lệ!");
		}
		// Loai Mat Hang
		if (product.getMaLoai() == null) {
			errors.rejectValue("maLoai", "matHangChinhSua", "Vui lòng chọn một loại mặt hàng!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");

		} else {
			if (productService.update(product))
				model.addAttribute("message", "Cập nhật mặt hàng thành công");
			else
				model.addAttribute("message", "Cập nhật mặt hàng không thành công!");
		}
		return "admin/product/update";
	}
	
	@RequestMapping(value="xoa-mat-hang/{id}", method=RequestMethod.GET)
	public String deleteGet(ModelMap model,
			@PathVariable("id") String maMatHang) {
		if(productService.delete(maMatHang))
			model.addAttribute("message", "Xóa mặt hàng " + maMatHang + " thành công!");
		else
			model.addAttribute("message", "Xóa mặt hàng " + maMatHang + " không thành công!");
		
		model.addAttribute("danhSachMatHang", productService.getAll());
		return "admin/product/list";
	}
	
	@RequestMapping(value="cap-nhap-hinh-anh/{id}", method=RequestMethod.GET)
	public String uploadPhotoGET(ModelMap model,
			@PathVariable("id") String id) {
		model.addAttribute("ma", id);
		return "admin/product/uploadPhoto";
	}
	
	@RequestMapping(value="cap-nhap-hinh-anh/{id}", method=RequestMethod.POST)
	public String uploadPhotoPOST(ModelMap model,
			@PathVariable("id") String id,
			@RequestParam("photo") MultipartFile file) {
		byte[] image = null;
		try {
			image = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product product = productService.getByID(id);
		product.setHinhAnh(image);
		if (productService.update(product))
			model.addAttribute("message", "Cập nhật hình ảnh thành công");
		else
			model.addAttribute("message", "Cập nhật hình ảnh không thành công");
		
		model.addAttribute("danhSachMatHang", productService.getAll());
		return "admin/product/list";
	}
}