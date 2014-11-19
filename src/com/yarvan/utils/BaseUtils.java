package com.yarvan.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import android.content.ContentValues;
import android.os.Bundle;

public class BaseUtils {
	/**
	 * 传入字符串，将首字母改成大写。
	 * @param str
	 * @return
	 */
	public static String initialToUpper(String str){
		if(str == null || "".equals(str))
			return null;
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		return  str;
	}
	/**
	 * 传入属性名返回其get方法名
	 * @param str
	 * @return
	 */
	public static String getMethodName(String str){
		return ("get"+initialToUpper(str)).trim();
	}
	/**
	 * 传入属性名返回其set方法名
	 * @param str
	 * @return
	 */
	public static String setMethodName(String str){
		return ("set"+initialToUpper(str)).trim();
	}
	/**
	 * 将map转换成contentvalues
	 * @param map
	 * @return
	 */
	public static ContentValues map2ContentValues(Map<String, String> map){
		ContentValues cv = new ContentValues();
		for(String key : map.keySet()){
			cv.put(key, map.get(key));
		}
		return cv;
	}
	/**
	 * 将model转换成contentValues
	 * @param model
	 * @return
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static ContentValues model2ContentValues(Object model) throws NoSuchMethodException, 
	IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ContentValues cv = new ContentValues();
		Class clazz = model.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields){
			String methodName = getMethodName(f.getName());
//			System.out.println(f.getName());
			Method m = clazz.getDeclaredMethod(methodName, null);
			cv.put(f.getName(), (String) m.invoke(model, null));
		}
		return cv;
	}
	/**
	 * 将bundle转化成Map<String, String>
	 * @param bundle
	 * @return
	 */
	public static Map<String, String> Bundle2Map(Bundle bundle){
		Map<String, String> map = new HashMap<String, String>();
		for(String key : bundle.keySet()){
			map.put(key, bundle.get(key)+"");
		}
		return map;
	}
	/**
	 * 将Map<String, String>转化成bundle
	 * @param map
	 * @return
	 */
	public static Bundle Map2Bundle(Map<String, String> map){
		Bundle bundle = new Bundle();
		for(String key : map.keySet()){
			bundle.putString(key, map.get(key));
		}
		return bundle;
	}
}
