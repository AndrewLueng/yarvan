package com.yarvan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import com.yarvan.utils.BaseUtils;
import com.yarvan.utils.HttpUtil;
import com.yarvan.utils.MyJSONUtils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AppointmentService extends Service implements Runnable{

	//用于发送广播的intent
	private Intent mIntent;
	//接收activity中的数据
	private Map<String, String> map;
	private String modelName;
	//请求url
	private String method;
	//请求返回的结果
	private String result = null;
	//请求的参数
	private List<Map<String, String>>modelMaps;
	//接收服务器端信息的map
	private Map<String, String> mapFromServer;
	
	
	/*
	 * 异步处理 
	 */
	@Override
	public void run() {
		//发起请求
		try {
			result = HttpUtil.doPost(method, modelName, modelMaps);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//如果请求结果为空
			if(result == null){
				mIntent.putExtra("status", false);
			}else {
				//处理result
				try {
					mapFromServer = MyJSONUtils.parseJSON2Map(result, modelName);
					mIntent.putExtra("status", mapFromServer.get("status"));
					mIntent.putExtra("id", mapFromServer.get("id"));
					mIntent.putExtra("count", mapFromServer.get("count"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			//发送广播
			sendBroadcast(mIntent);
		}
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//将intent中的额外信息转化为map
		map = BaseUtils.Bundle2Map(intent.getExtras());
		//设置广播action
		mIntent = new Intent(map.get("BCType"));
		mIntent.putExtra("is_app", intent.getExtras().getString("is_app"));
		//获取method
		method = map.get("method");
		//获取modelName
		modelName = map.get("modelName");
		//封装好请求的参数
		modelMaps = new ArrayList<Map<String,String>>();
		Map<String, String> modelMap = new HashMap<String, String>();
		modelMap.put("id", map.get("id"));
		modelMaps.add(modelMap);
		/*
		 * 异步处理信息并发送广播
		 */
		new Thread(this).start();
		return super.onStartCommand(intent, flags, startId);
	}
}
