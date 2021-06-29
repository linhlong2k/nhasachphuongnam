package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.service.LoginService;
import com.nhasachphuongnam.service.PIService;
import com.nhasachphuongnam.service.RoleService;

@Controller
@RequestMapping("admin/nhan-vien/")
public class StaffController {
	
	@Autowired
	PIService piService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RoleService roleService;
	
	//===============================================Model-Attribute===================================
	
	@ModelAttribute("danhSachNhanVien")
	public List<PersonalInfo> danhSachNhanVien() {
		List<PersonalInfo> pis = piService.getAllStaff();
		return pis;
	} 
	
	@ModelAttribute("nhanVienMoi")
	public PersonalInfo nhanVienMoi(){
		return new PersonalInfo();
	}
	
	@ModelAttribute("nhanVienChinhSua")
	public PersonalInfo nhanVienChinhSua(){
		return new PersonalInfo();
	}
	
	
	
	//===============================================Controller========================================
	@RequestMapping("index")
	public String index(ModelMap model) {
		return "admin/staff/index";
	}
	
	@RequestMapping("xoa-quyen-admin/{id}")
	public String toNormal(ModelMap model,
			@PathVariable("id") String username) {
		if(loginService.getByID(username) == null)
			model.addAttribute("message", "Không tìm thấy tài khoản có username = "+ username + " để xóa quyền admin!");
		else if(loginService.toNormal(username)) {
			model.addAttribute("message", "Xóa quyền admin thành công");
			model.addAttribute("danhSachNhanVien", piService.getAllStaff());
		} else
			model.addAttribute("message", "Xóa quyền Admin không thành công!");
		return "admin/staff/index";
	}
	
	@RequestMapping("tro-thanh-admin/{id}")
	public String toAdmin(ModelMap model,
			@PathVariable("id") String username) {
		if(loginService.getByID(username) == null)
			model.addAttribute("message", "Không tìm thấy tài khoản có username = "+ username + " để thêm quyền admin!");
		else if(loginService.toAdmin(username)) {
			model.addAttribute("message", "Thêm quyền admin thành công");
			model.addAttribute("danhSachNhanVien", piService.getAllStaff());
		} else
			model.addAttribute("message", "Thêm quyền Admin không thành công!");
		return "admin/staff/index";
	}
	
	/*
	 * @RequestMapping(value = "them-nhan-vien-moi", method = RequestMethod.GET)
	 * public String insertGET(ModelMap model) { return "admin/staff/create"; }
	 * 
	 * @RequestMapping(value = "them-nhan-vien-moi", method = RequestMethod.POST)
	 * public String insertPOST(ModelMap model,
	 * 
	 * @Validated @ModelAttribute("nhanVienMoi") PersonalInfo nhanVien,
	 * 
	 * @RequestParam(value = "password", required = false) String password,
	 * 
	 * @RequestParam(value = "passwordconfirm", required = false) String
	 * passwordConfirm, BindingResult errors) { System.out.println("qắerqwrqwer");
	 * if(errors.hasErrors()) { model.addAttribute("message",
	 * "Thông tin nhập vào không hợp lệ, vui lòng nhập lại"); } else { if
	 * (loginService.getByID(nhanVien.getUsername()) != null) {
	 * model.addAttribute("message", "Tên đăng nhập đã tồn tại"); } else
	 * if(password.trim().length() == 0) { model.addAttribute("message",
	 * "Mật khẩu không được để trống!"); } else
	 * if(!password.equals(passwordConfirm)) { model.addAttribute("message",
	 * "Mật khẩu xác nhận không trùng khớp!"); } else { Login login = new Login();
	 * login.setUsername(nhanVien.getUsername()); login.setPassword(password);
	 * RoleDTO role = roleService.getByID("2"); login.setRole(role);
	 * nhanVien.setMaRole("1"); if(piService.add(nhanVien, login)) {
	 * model.addAttribute("message", "Thêm nhân viên mới thành công!"); } else {
	 * model.addAttribute("message", "Thêm nhân viên mới không thành công!"); } } }
	 * return "admin/staff/create"; }
	 */
	
	@RequestMapping("xoa-nhan-vien/{id}")
	public String deleteGET(ModelMap model,
			@PathVariable("id") String ma) {
		if(piService.getByID(ma) == null)
			model.addAttribute("message", "Không tìm thấy mã nhân viên " + ma + " để xóa!");
		else if(piService.delete(ma)) {
			model.addAttribute("message", "Xóa nhân viên thành công!");
			model.addAttribute("danhSachNhanVien", piService.getAllStaff());
		} else
			model.addAttribute("message", "Xóa nhân viên không thành công!");
		return "admin/staff/index";
	}
}
