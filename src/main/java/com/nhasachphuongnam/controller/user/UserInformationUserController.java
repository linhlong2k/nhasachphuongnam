package com.nhasachphuongnam.controller.user;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nhasachphuongnam.model.PersonalInfo;
import com.nhasachphuongnam.model.RoleDTO;
import com.nhasachphuongnam.service.PIService;
import com.nhasachphuongnam.service.RoleService;

@Controller
@RequestMapping("thong-tin-ca-nhan")
public class UserInformationUserController {
	
	@Autowired
	PIService piService;
	
	@Autowired
	RoleService roleService;

	@ModelAttribute("roles")
	public List<RoleDTO> getAll() {
		List<RoleDTO> res = roleService.getAll();
		return res;
	}
	
	@GetMapping(value="")
	public String index() {
		return "user/info";
	}
	
	@PostMapping(value="", params="uploadPhotoId")
	public String updatePhoto(ModelMap model,
			@RequestParam(value="uploadPhotoId", required = false) String id,
			@RequestParam(value="photo", required = false) MultipartFile file) {
		if(file.isEmpty()) {
			model.addAttribute("messagePhoto", "Vui lòng chọn ảnh trước khi cập nhập");
			return "user/info";
		}
		byte[] image = null;
		try {
			image = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(piService.updatePhoto(id, image)) {
			model.addAttribute("notification", "Cập nhập ảnh thành công!");
			model.addAttribute("user", piService.getByID(id));
		} else {
			model.addAttribute("message", "Cập nhập ảnh không thành công!");
		}
		return "user/info";
	}
	
	@PostMapping(value="", params = "editInfo")
	public String updateInfomation(ModelMap model,
			@Validated @ModelAttribute(value = "user") PersonalInfo user,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("message", "Thông tin mới không hợp lệ");
		} else {
			if(piService.update(user)) {
				model.addAttribute("notification", "Cập nhật thông tin cá nhân mới thành công!");
			} else {
				model.addAttribute("message", "Cập nhật thông tin cá nhân mới không thành công!");
			}
		}
		return "user/info";
	}

}
