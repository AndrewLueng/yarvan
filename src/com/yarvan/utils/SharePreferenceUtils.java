package com.yarvan.utils;


import java.util.Map;

import com.yarvan.config.BaseConf;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtils {
	
	private final static String LASTEST_LOGIN = "lastest_login";
	/**
	 * 设置登录信息，登录后将信息保存至<userId>.xml文件中
	 * @param context
	 * @param phone
	 * @param password
	 */
	public static void setLoginInfo(Context context,String userId, String phone, String password){
		//获得SP
		SharedPreferences lastest = context.getSharedPreferences(LASTEST_LOGIN, Context.MODE_PRIVATE);
		SharedPreferences user = context.getSharedPreferences(userId, Context.MODE_APPEND);
		//将登陆信息保存至lastest_login.xml和<用户id>.xml文件中
		lastest.edit().putString("userId", userId).commit();
		user.edit().putString("userId", userId)
			.putString("phone", phone)
			.putString("password", password) 
			.commit();
	}
	/**
	 * 检查是否已经登录，已登录将登陆信息写入BaseConf，并放回true，未登录返回false
	 * @param context
	 * @return
	 */
	public static boolean IsLoggedIn(Context context){
		SharedPreferences lastest = context.getSharedPreferences(LASTEST_LOGIN, Context.MODE_PRIVATE);
		String userId = lastest.getString("userId", " ");
		//未登录返回false
		if(" ".equals(userId)) return false;
		SharedPreferences user = context.getSharedPreferences(userId, Context.MODE_PRIVATE);
		//写入baseconf
		BaseConf.USER_ID = user.getString("userId", null);
		BaseConf.PHONE = user.getString("phone", null);
		//已登录返回true
		return true;
	}
	/**
	 * 为医院添加可挂号科室
	 * @param context
	 * @param hospitalId
	 * @param department
	 */
	public static void addDepartment(Context context, String hospitalId, String department){
		SharedPreferences hospital = context.getSharedPreferences("hosptital"+hospitalId, Context.MODE_APPEND);
		hospital.edit().putString(department, department).commit();
	}
	/**
	 * 移出可挂号的科室
	 * @param context
	 * @param hospitalId
	 * @param department
	 */
	public static void removeDepartment(Context context, String hospitalId, String department){
		SharedPreferences hospital = context.getSharedPreferences("hosptital"+hospitalId, Context.MODE_APPEND);
		hospital.edit().remove(department).commit();
	}
	/**
	 * 根据医院名返回可挂号的科室
	 * @param context
	 * @param hospitalId
	 * @return
	 */
	public static Map<String, String> getDepartment(Context context, String hospitalId){
		Map<String, String> departmentMap;
		SharedPreferences hospital = context.getSharedPreferences("hosptital"+hospitalId, Context.MODE_PRIVATE);
		departmentMap = (Map<String, String>) hospital.getAll();
		return departmentMap;
	}
	/**
	 * 保存申请信息
	 * @param context
	 * @param id
	 * @param password
	 * @param item_id 服务项目
	 * @param is_doctor 是否通过
	 */
	public static void setApplyInfo(Context context, String id, String password,
			String item_id, String is_doctor){
		SharedPreferences apply = context.getSharedPreferences("apply", Context.MODE_PRIVATE);
		apply.edit().putString("id", "id")
			.putString("password", password)
			.putString("item_id", item_id)
			.putString("is_doctor", is_doctor)
			.commit();
		
	}
}
