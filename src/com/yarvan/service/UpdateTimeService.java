package com.yarvan.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class UpdateTimeService extends Service implements Runnable {

	private Context globalContext;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		//获取全局的context
		globalContext = this.getApplicationContext();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	private PendingIntent getPendingIntent(Context context){
		Intent intent = new Intent(context, UpdateTimeService.class);
		
	}

}
