package com.yarvan.broadcastreceiver;

import java.util.Map;

import com.yarvan.sqlite.DatabaseHelper;
import com.yarvan.utils.BaseUtils;
import com.yarvan.utils.SQLiteUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RegCancelBC extends BroadcastReceiver{
	
	//接收来自Service的信息
	private Map<String, String> map;
	
	private String id;
	private String status;
	
	//TODO
	public RegCancelBC(){
		
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		//获取信息
		map = BaseUtils.Bundle2Map(intent.getExtras());
		id = map.get("id");
		status = map.get("status");
		
		//如果请求失败
		if(status.equals("false")) whenFalse(context);
		else whenTrue(context);
	}
	private void whenFalse(Context context){
		//TODO 通知ui
	}
	private void whenTrue(Context context){
		//删除
		SQLiteUtil.deleteFromRegistration(new DatabaseHelper(context), id);
		//TODO 通知ui
	}

}
