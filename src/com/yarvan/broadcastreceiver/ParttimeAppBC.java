package com.yarvan.broadcastreceiver;

import java.util.Map;

import com.yarvan.sqlite.DatabaseHelper;
import com.yarvan.utils.BaseUtils;
import com.yarvan.utils.SQLiteUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ParttimeAppBC extends BroadcastReceiver{
	
	//用于接收Service发来的intent中的信息
	private Map<String, String>map;
	private String status;
	private String is_app;
	private String count;

	//用于改变ui的参数（在构造函数里获取）
	
	/**
	 * 构造函数，传参
	 */
	//TODO
	public ParttimeAppBC(){
		
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		//获取Service发过来的信息
		map = BaseUtils.Bundle2Map(intent.getExtras());
		status = map.get("status");
		is_app = map.get("is_app");
		if("false".equals(status)){
			whenFalse(context);
		}else{
			//成功预约把余量置0
			count = "true".equals(is_app)? 0+"" : map.get("count");
			whenTrue(context);
		}
	}
	/**
	 * 当请求失败时
	 */
	private void whenFalse(Context context){
		//TODO  告诉ui失败了
	}
	/**
	 * 当请求成功时
	 */
	private void whenTrue(Context context){
		//更新sqlite
		map.put("count", count);
		SQLiteUtil.updateParttimeInfo(new DatabaseHelper(context), map);
		//更新ui TODO
	}

}

