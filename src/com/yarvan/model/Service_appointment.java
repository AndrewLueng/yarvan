package com.yarvan.model;
/**
 * 分中心服务预约表
 * @author Administrator
 *
 */
public class Service_appointment {
	private String id;//id号
	private String user_id;//用户id
	private String service_appointment_info_id;//预约信息id
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
	public String getService_appointment_info_id() {
		return service_appointment_info_id;
	}
	public void setService_appointment_info_id(String service_appointment_info_id) {
		this.service_appointment_info_id = service_appointment_info_id;
	}
	
}
