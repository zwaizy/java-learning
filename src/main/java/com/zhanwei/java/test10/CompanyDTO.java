package com.zhanwei.java.test10;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CompanyDTO {
	
	private int id;
	private String name;
	private String address;
	private String code;
	@JsonIgnore
	private String action; 
	
	public CompanyDTO() {
		super();
	}
	public CompanyDTO(int id, String name, String address, String code) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", address=" + address + ", code=" + code + ", action="
				+ action + "]";
	}
	

}
