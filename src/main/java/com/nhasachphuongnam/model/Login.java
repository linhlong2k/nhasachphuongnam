package com.nhasachphuongnam.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	@NotEmpty(message = "Tên đăng nhập không được để trống")
	@NotNull(message = "Tên đăng nhập không được để trống")
	@Size(max = 25, message = "Tên đăng nhập không được quá dài")
	private String username;
	@NotEmpty(message = "Mật khẩu không được để trống")
	@NotNull(message = "Mật khẩu không được để trống")
	@Size(max = 50, message = "Mật khẩu không được quá dài")
	private String password;
	private RoleDTO role;

	public Login() {
		super();
	}

	public Login(String username, String password, RoleDTO role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}
	
}
