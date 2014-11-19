package com.yarvan.model;
/**
 * 分中心信息表
 * @author Administrator
 *
 */
public class Service_shop {
	private String id;//id号
	private String shop_name;//分中心名称
	private String address;//分中心地点
	private String contact_way;//联系方式（电话?）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_way() {
		return contact_way;
	}
	public void setContact_way(String contact_way) {
		this.contact_way = contact_way;
	}
	
}
