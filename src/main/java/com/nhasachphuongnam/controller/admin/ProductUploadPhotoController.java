/*
 * package com.nhasachphuongnam.controller.admin;
 * 
 * import java.io.IOException;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.nhasachphuongnam.model.Product;
 * 
 * @Controller
 * 
 * @RequestMapping("admin/cap-nhap-hinh-anh") public class
 * ProductUploadPhotoController {
 * 
 * @GetMapping(value="{id}") public String uploadPhotoGET(ModelMap model,
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
 * "admin/product/list"; } }
 */