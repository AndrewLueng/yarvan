package com.yarvan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import com.yarvan.config.DD;
import com.yarvan.utils.BaseUtils;
import com.yarvan.utils.HttpUtil;
import com.yarvan.utils.MyJSONUtils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ApplyService extends Service implements Runnable {
	
	//接受来自activity的信息
	private Map<String, String> map;
	//发送广播的intent
	private Intent mIntent;
	//请求的参数
	private List<Map<String, String>> modelMaps;
	//请求方式
	private String method;
	//服务器返回的结果
	private String result;
	//接收服务的信息的map
	private Map<String, String> mapFromServer;
	
	
	@Override
	public void run() {
		try {
			//发送请求并处理结果
			result = HttpUtil.doPost(method, DD.ModelName.REGISTRATION, modelMaps);
		} catch (Exception e) {
			result = null;
			e.printStackTrace();
		}finally{
			if(result == null){
				mIntent.putExtra("status", "false");
			}else{
				try {
					mapFromServer = MyJSONUtils.parseJSON2Map(result, DD.ModelName.REGISTRATION);
					mIntent.putExtra("status", mapFromServer.get("status"));
					mIntent.putExtra("id", mapFromServer.get("id"));
					mIntent.putExtra("password", mapFromServer.get("password"));
					mIntent.putExtra("item_id", mapFromServer.get("item_id"));
					mIntent.putExtra("is_doctor", "false");
				} catch (JSONException e) {
					mIntent.putExtra("status", "false");
					e.printStackTrace();
				}
			}
			//发送广播
			sendBroadcast(mIntent);
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//获取activity的信息
		map = BaseUtils.Bundle2Map(intent.getExtras());
		//设置广播动作
		mIntent = new Intent(map.get("BCType"));
		//封装请求的参数
		Map<String, String>param = new HashMap<String, String>();
		param.put("age", map.get("age"));
		param.put("item_id", map.get("item_id"));
		param.put("name", map.get("name"));
		param.put("password", map.get("password"));
		param.put("phone", map.get("phone"));
		param.put("sex", map.get("sex"));
		param.put("BCType", map.get("BCType"));
		modelMaps.add(param);
		/**
		 * 异步请求
		 */
		return super.onStartCommand(intent, flags, startId);
	}
}
