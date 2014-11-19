package com.yarvan.broadcastreceiver;

import java.util.HashMap;
import java.util.Map;

import com.yarvan.config.DD;
import com.yarvan.sqlite.DatabaseHelper;
import com.yarvan.utils.BaseUtils;
import com.yarvan.utils.ModelUtils;
import com.yarvan.utils.SQLiteUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

public class RegBC extends BroadcastReceiver {

	//接收来自Service的信息
	private Map<String, String> map;
	
	private String department;
	private String registration_time;
	private String hospital_id;
	private String id;
	private String status;

	@Override
	public void onReceive(Context context, Intent intent) {
		//获取信息
		map = BaseUtils.Bundle2Map(intent.getExtras());
		department = map.get("department");
		registration_time = map.get("registration_time");
		hospital_id = map.get("hospital_id");
		id = map.get("id");
		status = map.get("status");
		
		//如果请求失败
		if(status.equals("false")) whenFalse(context);
		else whenTrue(context);
	}
	private void whenFalse(Context context){
		//通知ui TODO
	}
	private void whenTrue(Context context){
		//构建SQLite中所需要的信息map
		Map<String, String> RegMap = new HashMap<String, String>();
		RegMap.put("department", department);
		RegMap.put("id", id);
		RegMap.put("registration_time", registration_time);
		Cursor cursor = SQLiteUtil.queryHospitalById(new DatabaseHelper(context), hospital_id);
		if(cursor != null){
			String address = cursor.getString(cursor.getColumnIndex("address"));
			String hospital_name = cursor.getString(cursor.getColumnIndex("name"));
			RegMap.put("address", address);
			RegMap.put("hospital_name", hospital_name);
		}
		//To model
		Object model;
		try {
			model = ModelUtils.toModel(RegMap, DD.ModelName.SQL_REG);
			//插入SQLite
			SQLiteUtil.insertRegistration(new DatabaseHelper(context), model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO 更新ui
	}
	
}
