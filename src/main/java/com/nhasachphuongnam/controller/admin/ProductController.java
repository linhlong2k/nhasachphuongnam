package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	
	//===============================================Model-Attribute===================================
	@ModelAttribute("searchbar")
	public String searchBar() {
		return "product";
	}
	
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
	public Product matHangChinhSua(Product var){
		return var;
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
			errors.rejectValue("tenMatHang", "product", "Vui lòng nhập tên mặt hàng!");
		} else if(product.getTenMatHang().trim().length() > 50) {
			errors.rejectValue("tenMatHang", "product", "Tên mặt hàng quá dài");
		}
		//gia
		if (product.getGia() != (int)product.getGia()) {
			errors.rejectValue("Gia", "product", "Vui lòng nhập gía tiền đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("Gia", "product", "Giá tiền nhập vào không hợp lệ!");
		}
		//soLuong
		if (product.getSoLuong() != (int)product.getSoLuong()) {
			errors.rejectValue("soLuong", "product", "Vui lòng nhập số lượng đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("soLuong", "product", "Số lượng không hợp lệ!");
		}
		//Loai Mat Hang
		if (product.getMaLoai() == null) {
			errors.rejectValue("maLoai", "product", "Vui lòng chọn một loại mặt hàng!");
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
		List<ProductType> types = productTypeService.getAll();
		model.addAttribute("type", types);
		return "admin/product/createProduct";
	}
	
	@RequestMapping(value="chinh-sua-mat-hang/{id}", method=RequestMethod.GET)
	public String updateGet(ModelMap model,
			@PathVariable("id") String maMatHang) {
		Product product = productService.getByID(maMatHang);
		this.matHangChinhSua(product);
		return "admin/product/update";
	}
	
	@RequestMapping(value="chinh-sua-mat-hang", method=RequestMethod.POST)
	public String updatePost(ModelMap model,
			@ModelAttribute("product") Product product,
			BindingResult errors) {
			// check input value
		// tenMatHang
		if (product.getTenMatHang().trim().length() == 0) {
			errors.rejectValue("tenMatHang", "product", "Vui lòng nhập tên mặt hàng!");
		} else if (product.getTenMatHang().trim().length() > 50) {
			errors.rejectValue("tenMatHang", "product", "Tên mặt hàng quá dài");
		}
		// gia
		if (product.getGia() != (int) product.getGia()) {
			errors.rejectValue("Gia", "product", "Vui lòng nhập gía tiền đúng định dạng!");
		} else if (product.getGia() < 0) {
			errors.rejectValue("Gia", "product", "Giá tiền nhập vào không hợp lệ!");
		}
		// soLuong
		if (product.getSoLuong() != (int) product.getSoLuong()) {
			errors.rejectValue("soLuong", "product", "Vui lòng nhập số lượng đúng định dạng!");
		} else if (product.getSoLuong() < 0) {
			errors.rejectValue("soLuong", "product", "Số lượng không hợp lệ!");
		}
		// Loai Mat Hang
		if (product.getMaLoai() == null) {
			errors.rejectValue("maLoai", "product", "Vui lòng chọn một loại mặt hàng!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");

		} else {
			if (productService.update(product)) {
				model.addAttribute("message", "Cập nhật mặt hàng thành công");
			} else {
				model.addAttribute("message", "Cập nhật mặt hàng không thành công!");
			}
		}
		List<ProductType> types = productTypeService.getAll();
		model.addAttribute("type", types);
		return "admin/product/update";
	}
	
	@RequestMapping(value="xoa-mat-hang/{id}", method=RequestMethod.GET)
	public String deleteGet(ModelMap model,
			@PathVariable("id") String maMatHang) {
		if(productService.delete(maMatHang))
			model.addAttribute("mesage", "Xóa đơn hàng " + maMatHang + " thành công!");
		else
			model.addAttribute("mesage", "Xóa đơn hàng " + maMatHang + " không thành công!");
		
		this.danhSachMatHang();
		return "admin/product/list";
	}
	
	//===============================================loai-mat-hang=====================================
	
	@RequestMapping(value="loai-mat-hang/index", method=RequestMethod.GET)
	public String typeIndex(ModelMap model,
			@ModelAttribute("ProductType") ProductType type) {
		return "admin/product/productType";
	}
	
	@RequestMapping(value="loai-mat-hang/chinh-sua-loai-mat-hang/{id}", method=RequestMethod.POST)
	public String updateType(ModelMap model,
			@ModelAttribute("ProductType") ProductType type,
			@PathVariable("id") String typeID,
			BindingResult errors) {
		if (type.getTenLoai().trim().length() == 0) {
			errors.rejectValue("tenLoai", "ProductType", "Vui lòng nhập tên loại!");
		} else if (type.getTenLoai().trim().length() > 50) {
			errors.rejectValue("tenLoai", "ProductType", "Tên loại không được dài quá 50 kí tự!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
		} else {
			if (productTypeService.update(type)) {
				model.addAttribute("message", "Cập nhật loại mặt hàng thành công");
			} else {
				model.addAttribute("message", "Cập nhật loại mặt hàng không thành công!");
			}
		}
		
		List<ProductType> typeList = productTypeService.getAll();
		model.addAttribute("types", typeList);
		model.addAttribute("newType", new ProductType());
		return "admin/product/productType";
	}
	
	@RequestMapping(value="loai-mat-hang/xoa-loai-mat-hang/{id}", method=RequestMethod.POST)
	public String deleteType(ModelMap model,
			@ModelAttribute("ProductType") ProductType type,
			@PathVariable("id") String typeID) {
		if(productTypeService.delete(typeID)) {
			model.addAttribute("message", "Xóa loại mặt hàng " + typeID + " thành công!");
		} else {
			model.addAttribute("message", "Xóa loại mặt hàng " + typeID + " không thành công!");
		}
		
		List<ProductType> typeList = productTypeService.getAll();
		model.addAttribute("types", typeList);
		model.addAttribute("newType", new ProductType());
		return "admin/product/productType";
	}
	
	@RequestMapping(value="loai-mat-hang/chi-tiet-loai-mat-hang/{id}", method=RequestMethod.POST)
	public String detailType(ModelMap model,
			@ModelAttribute("ProductType") ProductType type,
			@PathVariable("id") String typeID) {
		List<ProductType> typeList = productTypeService.getAll();
		
		model.addAttribute("products", productService.getProductListByType(typeID));
		model.addAttribute("types", typeList);
		model.addAttribute("newType", new ProductType());
		return "admin/product/productType";
	}
	
	@RequestMapping(value="loai-mat-hang/tao-loai-mat-hang-moi", method=RequestMethod.POST)
	public String createType(ModelMap model,
			@ModelAttribute("ProductType") ProductType type,
			@ModelAttribute("newType") ProductType newType,
			BindingResult errors) {
		if (newType.getTenLoai().trim().length() == 0) {
			errors.rejectValue("tenLoai", "newType", "Vui lòng nhập tên loại!");
		} else if (newType.getTenLoai().trim().length() > 50) {
			errors.rejectValue("tenLoai", "newType", "Tên loại không được dài quá 50 kí tự!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
		} else {
			if (productTypeService.add(type)) {
				model.addAttribute("message", "Thêm loại mặt hàng thành công");
			} else {
				model.addAttribute("message", "Thêm loại mặt hàng không thành công!");
			}
		}
		
		List<ProductType> typeList = productTypeService.getAll();
		model.addAttribute("types", typeList);
		model.addAttribute("newType", new ProductType());
		return "admin/product/productType";
	}
}