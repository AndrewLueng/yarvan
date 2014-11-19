package com.yarvan.model;
/**
 * 用户表
 * @author Administrator
 *
 */
public class User {
	private String id;//用户id号
	private String password;//用户密码
	private String phone;//用户电话
	private String identity_card;//身份证号
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentity_card() {
		return identity_card;
	}
	public void setIdentity_card(String identity_card) {
		this.identity_card = identity_card;
	}
	
	
	
}
