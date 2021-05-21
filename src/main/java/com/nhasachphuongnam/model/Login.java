package com.nhasachphuongnam.model;

public class Login {
	private String username;
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
