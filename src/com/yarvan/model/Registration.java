package com.yarvan.model;
/**
 * 挂号联系表
 * @author Administrator
 *
 */
public class Registration {
	private String id;//id号
	private String user_id;//用户
	private String hosipital_id;//医院
	private String apply_time;//申请时间
	private String registration_time;//挂号时间
	private String phone;//联系号码
	private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getApply_time() {
		return apply_time;
	}
	public String getHosipital_id() {
		return hosipital_id;
	}
	public void setHosipital_id(String hosipital_id) {
		this.hosipital_id = hosipital_id;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getRegistration_time() {
		return registration_time;
	}
	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}
}
