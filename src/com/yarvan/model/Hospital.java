package com.yarvan.model;

/**
 * 医院信息表
 * @author Administrator
 *
 */
public class Hospital {
	private String id;//医院id号
	private String name;//医院名
	private String address;//医院地址
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
