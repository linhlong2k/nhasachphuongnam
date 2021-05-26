package com.nhasachphuongnam.controller.admin;

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

import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.RoleDTO;
import com.nhasachphuongnam.service.LoginService;
import com.nhasachphuongnam.service.PIService;
import com.nhasachphuongnam.service.RoleService;

@Controller
@RequestMapping("admin/nhan-vien/")
public class StaffController {
	
	@Autowired(required=true)
	PIService piService;
	
	@Autowired(required = true)
	LoginService loginService;
	
	@Autowired(required = true)
	RoleService roleService;
	
	@Autowired
	ServletContext context;
	
	//===============================================Model-Attribute===================================
	
	@ModelAttribute("danhSachNhanVien")
	public List<PersonalInfo> danhSachNhanVien(){
		List<PersonalInfo> pis = piService.getAllNhanVien();
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
			model.addAttribute("danhSachNhanVien", piService.getAllNhanVien());
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
			model.addAttribute("danhSachNhanVien", piService.getAllNhanVien());
		} else
			model.addAttribute("message", "Thêm quyền Admin không thành công!");
		return "admin/staff/index";
	}
	
	@RequestMapping(value = "them-nhan-vien-moi", method = RequestMethod.GET)
	public String insertGET(ModelMap model) {
		return "admin/staff/create";
	}
	
	@RequestMapping(value = "them-nhan-vien-moi", method = RequestMethod.POST)
	public String insertPOST(ModelMap model,
			@ModelAttribute("nhanVienMoi") PersonalInfo info,
			@RequestParam("password") String password,
			@RequestParam("passwordconfirm") String passwordConfirm,
			BindingResult errors) {
		if(info.getTen().trim().length() == 0)
			errors.rejectValue("ten", "nhanVienMoi", "Vui lòng nhập tên của nhân viên");
		if(info.getUsername().trim().length() == 0)
			errors.rejectValue("username", "nhanVienMoi", "Vui lòng nhập username");
		if(errors.hasErrors())
			model.addAttribute("message", "Thông tin nhập vào không hợp lệ, vui lòng nhập lại");
		else {
			if (loginService.getByID(info.getUsername()) != null) {
				model.addAttribute("message", "Tên đăng nhập đã tồn tại");
			} else if(password.trim().length() == 0)
				model.addAttribute("message", "Mật khẩu không được để trống!");
			else if(!password.equals(passwordConfirm))
				model.addAttribute("message", "Mật khẩu xác nhận không chính xác!");
			else {
				RoleDTO temp = roleService.getByID("1");
				if(temp == null)
					model.addAttribute("message", "Không tìm thấy mã role nhân viên!");
				else {
					Login login = new Login(info.getUsername(), password, temp);
					info.setMaRole("1");
					if(loginService.add(login))
						if(piService.add(info))
							model.addAttribute("message", "Thêm nhân viên mới thành công!");
						else
							model.addAttribute("message", "Thêm nhân viên mới không thành công!");
					else
						model.addAttribute("message", "Có lỗi xảy ra khi tạo thông tin đăng nhập cho nhân viên với,<br>Thêm nhân viên mới không thành công");
				}
				
			}
		}
		return "admin/staff/create";
	}
	
	@RequestMapping("xoa-nhan-vien/{id}")
	public String deleteGET(ModelMap model,
			@PathVariable("id") String ma) {
		if(piService.getByID(ma) == null)
			model.addAttribute("message", "Không tìm thấy mã nhân viên " + ma + " để xóa!");
		else if(piService.delete(ma)) {
			model.addAttribute("message", "Xóa nhân viên thành công!");
			model.addAttribute("danhSachNhanVien", piService.getAllNhanVien());
		} else
			model.addAttribute("message", "Xóa nhân viên không thành công!");
		return "admin/staff/index";
	}
}
