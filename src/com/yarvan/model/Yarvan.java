package com.yarvan.model;
/**
 * 公司信息表
 * @author Administrator
 *
 */
public class Yarvan {
	private String id;//id号(uuid)
	private String varvan_info;//公司介绍
	private String business_info;//业务简介
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVarvan_info() {
		return varvan_info;
	}
	public void setVarvan_info(String varvan_info) {
		this.varvan_info = varvan_info;
	}
	public String getBusiness_info() {
		return business_info;
	}
	public void setBusiness_info(String business_info) {
		this.business_info = business_info;
	}
	
}
