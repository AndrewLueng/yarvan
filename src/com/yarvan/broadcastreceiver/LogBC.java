package com.yarvan.broadcastreceiver;

import java.util.Map;

import com.yarvan.utils.BaseUtils;
import com.yarvan.utils.SharePreferenceUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LogBC extends BroadcastReceiver{
	
	//接收Service的信息
	private Map<String, String> map;
	
	private String id;
	private String phone;
	private String password;
	private String status;
	
	//需要更新ui的参数（构造函数中获取）

	/*
	 * 构造函数
	 */
	//TODO
	public LogBC( ){
		
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		//获取Service中来得信息
		map = BaseUtils.Bundle2Map(intent.getExtras());
		id = map.get("id");
		phone = map.get("phone");
		password = map.get("password");
		status = map.get("status");
		//如果请求失败
		if("false".equals(status)) whenFalse(context) ;
		//设置登录信息
		else whenTrue(context);
		
	}
	
	private void whenFalse(Context context){
		//TODO 告诉ui失败了
	}
	private void whenTrue(Context context){
		SharePreferenceUtils.setLoginInfo(context, id, phone, password);
		//TODO 告诉ui成功了
	}

}
