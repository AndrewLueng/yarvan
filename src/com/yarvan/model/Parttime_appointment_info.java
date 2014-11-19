package com.yarvan.model;
/**
 * 兼职预约信息表
 * @author Administrator
 *
 */
public class Parttime_appointment_info {
	private String id;//id号
	private String shop_id;//service_shop_id,与分中心表的联系
	private String item_id;//预约项目
	private String time_id;//时间段
	private String count;//剩余数量
	private String date;//预约日期
	
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
	public String getTime_id() {
		return time_id;
	}
	public void setTime_id(String time_id) {
		this.time_id = time_id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
