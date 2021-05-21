package com.nhasachphuongnam.model;

public class RoleDTO {
	private String maRole;
	private String tenRole;

	public RoleDTO() {
		super();
	}

	public RoleDTO(String maRole, String tenRole) {
		super();
		this.maRole = maRole;
		this.tenRole = tenRole;
	}

	public String getMaRole() {
		return maRole;
	}

	public void setMaRole(String maRole) {
		this.maRole = maRole;
	}

	public String getTenRole() {
		return tenRole;
	}

	public void setTenRole(String tenRole) {
		this.tenRole = tenRole;
	}

}
