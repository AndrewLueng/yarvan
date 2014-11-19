package com.yarvan.broadcastreceiver;

import java.util.Map;

import com.yarvan.utils.BaseUtils;
import com.yarvan.utils.SharePreferenceUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ApplyBC extends BroadcastReceiver{

	//接收来自service的信息
	private Map<String, String> map;
	
	private String status;
	private String id;
	private String password;
	private String item_id;
	private String is_doctor;
	
	/*
	 * 通过构造函数传参
	 */
	//TODO
	public ApplyBC(){
		
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		map = BaseUtils.Bundle2Map(intent.getExtras());
		
		status = map.get("status");
		if(status.equals("false")) whenFalse(context);
		else whenTrue(context);
	}
	private void whenFalse(Context context){
		//通知ui TODO
	}
	private void whenTrue(Context context){
		//获取service中的信息
		id = map.get("id");
		password = map.get("password");
		item_id = map.get("item_id");
		is_doctor = map.get("isdoctor");
		//更新sharedPreference
		SharePreferenceUtils.setApplyInfo(context, id, password, item_id, is_doctor);
		//TODO 更新ui
	}

}
