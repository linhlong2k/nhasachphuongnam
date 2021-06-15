package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhasachphuongnam.model.Product;
import com.nhasachphuongnam.service.ProductService;

@Controller
@RequestMapping("admin/mat-hang") 
public class ProductController {
	
	@Autowired
	ProductService productService;

	//===============================================Model-Attribute===================================
	

	@ModelAttribute("danhSachMatHang")
	public List<Product> danhSachMatHang(){
		List<Product> matHangs = productService.getAll();
		return matHangs;
	}
	
	//===============================================Controller========================================
	@GetMapping(value="")
	public String list(ModelMap model) {
		return "admin/product/list";
	}
	
	@PostMapping(value="", params="btnDetailId")
	public String productDetail(ModelMap model,
			@RequestParam(value = "btnDetailId", required = false) String id) {
		return "redirect:chi-tiet-mat-hang.htm?id="+id;		//không hiểu sao phải bỏ chữ admin mới chạy đúng được
	}
	
	@PostMapping(value="", params="btnDiscountId")
	public String productDiscount(ModelMap model,
			@RequestParam(value="btnDiscountId", required = false) String id,
			@RequestParam(value="giamGia", required = false) Float giamGia) {
		if(id.isEmpty()) {
			model.addAttribute("message", "Mã mặt hàng không xác định");
			return "admin/product/list";
		}
		if(giamGia.isNaN()) {
			model.addAttribute("message", "Mã giảm giá không đúng định dạng!");
			return "admin/product/list";
		}
		if(productService.updateGiamGia(id, giamGia)){
			model.addAttribute("message", "Mặt hàng " + id + " có giảm giá mới là " + giamGia * 100 + "%");
			model.addAttribute("danhSachMatHang", this.danhSachMatHang());
			return "admin/product/list";
		}
		model.addAttribute("message", "Cập nhập giảm giá cho mặt hàng " + id + " không thành công!");
		return "admin/product/list";
	}
	
	@PostMapping(value="", params="btnDeleteId")
	public String productDelete(ModelMap model,
			@RequestParam(value="btnDeleteId", required=false) String id) {
		if(id.isEmpty()) {
			model.addAttribute("message", "Mã mặt hàng không xác định!");
			return "admin/product/list";
		}
		if(productService.getByID(id) == null) {
			model.addAttribute("message", "Không tìm thấy mặt hàng " + id + "!");
		} else if (productService.delete(id)) {
			model.addAttribute("message", "Xóa mặt hàng " + id + " thành công!");	
		} else {
			model.addAttribute("message", "Xóa mặt hàng " + id + " không thành công!");
		}
		
		model.addAttribute("danhSachMatHang", this.danhSachMatHang());
		return "admin/product/list";
	}
	
	//====================================================================================
	
	/*
	 * @RequestMapping(value="tao-mat-hang-moi", method=RequestMethod.GET) public
	 * String createGet(ModelMap model) { return "admin/product/createProduct"; }
	 * 
	 * @RequestMapping(value="tao-mat-hang-moi", method=RequestMethod.POST) public
	 * String createPost(ModelMap model,
	 * 
	 * @ModelAttribute("matHangMoi") Product product, BindingResult errors) {
	 * //check input value //tenMatHang if (product.getTenMatHang().trim().length()
	 * == 0) { errors.rejectValue("tenMatHang", "matHangMoi",
	 * "Vui lòng nhập tên mặt hàng!"); } else
	 * if(product.getTenMatHang().trim().length() > 50) {
	 * errors.rejectValue("tenMatHang", "matHangMoi", "Tên mặt hàng quá dài"); }
	 * //gia if (product.getGia() <= 0) { errors.rejectValue("Gia", "matHangMoi",
	 * "Giá tiền nhập vào không hợp lệ!"); } //soLuong if (product.getSoLuong() !=
	 * (int)product.getSoLuong()) { errors.rejectValue("soLuong", "matHangMoi",
	 * "Vui lòng nhập số lượng đúng định dạng!"); } else if (product.getSoLuong() <
	 * 0) { errors.rejectValue("soLuong", "matHangMoi", "Số lượng không hợp lệ!"); }
	 * //Loai Mat Hang if (product.getMaLoai() == null) {
	 * errors.rejectValue("maLoai", "matHangMoi",
	 * "Vui lòng chọn một loại mặt hàng!"); }
	 * 
	 * if (errors.hasErrors()) { model.addAttribute("message",
	 * "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
	 * 
	 * } else { if(productService.add(product)) { model.addAttribute("message",
	 * "Tạo mặt hàng mới thành công"); } else { model.addAttribute("message",
	 * "Tạo mặt hàng mới không thành công!"); } }
	 * model.addAttribute("danhSachMatHang", productService.getAll()); return
	 * "admin/product/createProduct"; }
	 * 
	 * @RequestMapping(value="chinh-sua-mat-hang/{id}", method=RequestMethod.GET)
	 * public String updateGet(ModelMap model,
	 * 
	 * @PathVariable("id") String maMatHang) { Product product =
	 * productService.getByID(maMatHang); model.addAttribute("matHangChinhSua",
	 * product); return "admin/product/update"; }
	 * 
	 * @RequestMapping(value="chinh-sua-mat-hang", method=RequestMethod.POST) public
	 * String updatePost(ModelMap model,
	 * 
	 * @ModelAttribute("matHangChinhSua") Product product, BindingResult errors) {
	 * // check input value // tenMatHang if
	 * (product.getTenMatHang().trim().length() == 0) {
	 * errors.rejectValue("tenMatHang", "matHangChinhSua",
	 * "Vui lòng nhập tên mặt hàng!"); } else if
	 * (product.getTenMatHang().trim().length() > 50) {
	 * errors.rejectValue("tenMatHang", "matHangChinhSua", "Tên mặt hàng quá dài");
	 * } // gia if (product.getGia() <= 0) { errors.rejectValue("Gia",
	 * "matHangChinhSua", "Giá tiền nhập vào không hợp lệ!"); } // soLuong if
	 * (product.getSoLuong() != (int) product.getSoLuong()) {
	 * errors.rejectValue("soLuong", "matHangChinhSua",
	 * "Vui lòng nhập số lượng đúng định dạng!"); } else if (product.getSoLuong() <
	 * 0) { errors.rejectValue("soLuong", "matHangChinhSua",
	 * "Số lượng không hợp lệ!"); } // Loai Mat Hang if (product.getMaLoai() ==
	 * null) { errors.rejectValue("maLoai", "matHangChinhSua",
	 * "Vui lòng chọn một loại mặt hàng!"); }
	 * 
	 * if (errors.hasErrors()) { model.addAttribute("message",
	 * "Thông tin bạn nhập không đúng định dạng vui lòng nhập lại");
	 * 
	 * } else { if (productService.update(product)) model.addAttribute("message",
	 * "Cập nhật mặt hàng thành công"); else model.addAttribute("message",
	 * "Cập nhật mặt hàng không thành công!"); } return "admin/product/update"; }
	 * 
	 * @RequestMapping(value="xoa-mat-hang/{id}", method=RequestMethod.GET) public
	 * String deleteGet(ModelMap model,
	 * 
	 * @PathVariable("id") String maMatHang) { if(productService.getByID(maMatHang)
	 * == null) model.addAttribute("message", "Không tìm thấy mặt hàng " + maMatHang
	 * + "!"); else if(productService.delete(maMatHang))
	 * model.addAttribute("message", "Xóa mặt hàng " + maMatHang + " thành công!");
	 * else model.addAttribute("message", "Xóa mặt hàng " + maMatHang +
	 * " không thành công!");
	 * 
	 * model.addAttribute("danhSachMatHang", productService.getAll()); return
	 * "admin/product/list"; }
	 * 
	 * @RequestMapping(value="cap-nhat-hinh-anh/{id}", method=RequestMethod.GET)
	 * public String uploadPhotoGET(ModelMap model,
	 * 
	 * @PathVariable("id") String id) { model.addAttribute("ma", id); return
	 * "admin/product/uploadPhoto"; }
	 * 
	 * @RequestMapping(value="cap-nhat-hinh-anh/{id}", method=RequestMethod.POST)
	 * public String uploadPhotoPOST(ModelMap model,
	 * 
	 * @PathVariable("id") String id,
	 * 
	 * @RequestParam("photo") MultipartFile file) { byte[] image = null; try { image
	 * = file.getBytes(); } catch (IOException e) { e.printStackTrace(); } Product
	 * product = productService.getByID(id); product.setHinhAnh(image); if
	 * (productService.update(product)) model.addAttribute("message",
	 * "Cập nhật hình ảnh thành công"); else model.addAttribute("message",
	 * "Cập nhật hình ảnh không thành công");
	 * 
	 * model.addAttribute("danhSachMatHang", productService.getAll()); return
	 * "admin/product/list"; }
	 */
}