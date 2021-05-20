/*
 * package com.nhasachphuongnam.controller.admin;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import com.nhasachphuongnam.bean.Order;
 * 
 * @Controller
 * 
 * @RequestMapping("/order/") public class OrderController {
 * 
 * @RequestMapping(value="index", method=RequestMethod.GET) public String
 * index() { return "orders/index"; }
 * 
 * @RequestMapping(value="create", method=RequestMethod.GET) public String
 * createGET(ModelMap model) { model.addAttribute("order", new Order()); return
 * "orders/createAndUpdate"; }
 * 
 * @RequestMapping(value="create", method=RequestMethod.POST) public String
 * createPost(ModelMap model,
 * 
 * @ModelAttribute("order") Order order) { //create order lên datebase //thành
 * công //thêm message thông báo kết quả //trả về views index //thất bại //thông
 * báo không thành công //trả về views createAndUpdate return "orders/index"; }
 * 
 * @RequestMapping(value="update/{id}", method=RequestMethod.GET) public String
 * updateGET(ModelMap model,
 * 
 * @PathVariable("id") String maDonHang) { Order order = new Order();//get order
 * by ma Don hang model.addAttribute("order", order); return
 * "orders/createAndUpdate"; }
 * 
 * @RequestMapping(value="update", method=RequestMethod.POST) public String
 * updatePost(ModelMap model,
 * 
 * @ModelAttribute("order") Order order) { //update order lên datebase //thành
 * công //thêm message thông báo kết quả //trả về views index //thất bại //thông
 * báo không thành công //trả về views createAndUpdate return "order/index"; }
 * 
 * @RequestMapping(value="delete/{id}", method=RequestMethod.GET) public String
 * delete(ModelMap model,
 * 
 * @PathVariable("id") String maDonHang) { //lấy thông tin đơn hàng theo mã đơn
 * hàng //xóa đơn hàng //trả về thông báo return "order/index"; } }
 */