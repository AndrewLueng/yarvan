package com.yarvan.model;

/**
 * 兼职预约表
 * @author Administrator
 *
 */
public class Parttime_appointment {
	private String id;//id号
	private String user_id;//用户id号
	private String parttime_appointment_info_id;//兼职预约信息id
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
	public String getParttime_appointment_info_id() {
		return parttime_appointment_info_id;
	}
	public void setParttime_appointment_info_id(String parttime_appointment_info_id) {
		this.parttime_appointment_info_id = parttime_appointment_info_id;
	}
	
	
}
