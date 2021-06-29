package com.nhasachphuongnam.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("admin/them-nhan-vien")
public class StaffCreateController {

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
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String insertGET(ModelMap model) {
		return "admin/staff/create";
	}
	
	@PostMapping(value = "")	//nhận uri
	public String insertPOST(ModelMap model,
			@Validated @ModelAttribute("nhanVienMoi") PersonalInfo nhanVien,	//validation quét qua model NhanVien
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordconfirm", required = false) String passwordConfirm,
			BindingResult errors) {
		if(errors.hasErrors()) {	//Nếu validation có lỗi, thông báo và kết thúc chương trình
			model.addAttribute("message", "Thông tin nhập vào không hợp lệ, vui lòng nhập lại");
		} else {
				//Kiểm tra tên đăng nhập có tồn tại
			if (loginService.getByID(nhanVien.getUsername()) != null) {
				model.addAttribute("message", "Tên đăng nhập đã tồn tại");
			} 
				//Kiểm tra mật khẩu có để trống
			else if(password.trim().length() == 0) {
				model.addAttribute("message", "Mật khẩu không được để trống!");
			} 
				//Kiểm tra mật khẩu xác nhận có giống mật khẩu
			else if(!password.equals(passwordConfirm)) {
				model.addAttribute("message", "Mật khẩu xác nhận không trùng khớp!");
			} else {
					//Tạo thông tin đăng nhập mới cho nhân viên
				Login login = new Login();
				login.setUsername(nhanVien.getUsername());	//set username cho login
				login.setPassword(password);	//set password cho login
					//Tìm role thích hợp cho nhân viên
				RoleDTO role = roleService.getByID("1");	
				login.setRole(role);	//set role có login
				nhanVien.setMaRole("1");	//set role cho nhân viên
				if(piService.add(nhanVien, login)) {	//Tiến hành thêm nhân viên
					model.addAttribute("message", "Thêm nhân viên mới thành công!");
				} else {
					model.addAttribute("message", "Thêm nhân viên mới không thành công!");
				}
			}
		}
		return "admin/staff/create"; //trả về View thêm nhân viên
	}

}
