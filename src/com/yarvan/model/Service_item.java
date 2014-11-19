package com.yarvan.model;
/**
 * 服务项目表
 * @author Administrator
 *
 */
public class Service_item {
	private String id;//项目id号
	private String item_name;//项目名称
	private String item_info;//项目的内容简介
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_info() {
		return item_info;
	}
	public void setItem_info(String item_info) {
		this.item_info = item_info;
	}
	
}
