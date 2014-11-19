package com.yarvan.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MyJSONUtils {
	/**
	 * 传入对象list集合返回带其JSONObject的JSONArray
	 * @param <T>
	 * @param models
	 * @return
	 * @throws IllegalArgumentException
	 * @throws JSONException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static <T> JSONArray toJSONArray(List<Map<String, String>> modelMaps, String modelName) throws IllegalArgumentException,
	JSONException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, 
	ClassNotFoundException, InstantiationException{
		JSONArray jArray = new JSONArray();
		for(int i = 0; i<modelMaps.size(); i++){
			jArray.put(i, toJSONObject(modelMaps.get(i),modelName));
		}
		return jArray;
	}
	/**
	 * 传入对象和method（操作模式）构成JSON
	 * @param model
	 * @param method
	 * @return
	 * @throws JSONException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static JSONObject toJSONObject(Map<String, String> modelMap, String modelName) 
			throws JSONException, NoSuchMethodException, IllegalArgumentException, 
			IllegalAccessException, InvocationTargetException, ClassNotFoundException, 
			InstantiationException{
		Object model = ModelUtils.toModel(modelMap, modelName);
		JSONObject jObject = new JSONObject();
		Class clazz = model.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields){
			String methodName = BaseUtils.getMethodName(f.getName());
//			System.out.println(f.getName());
			Method m = clazz.getDeclaredMethod(methodName, null);
			jObject.put(f.getName(), m.invoke(model, null));
		}
		return jObject;
	}
	
	/**
	 * 处理服务器端传送回来的信息
	 * @param jsonStr
	 * @param modelName
	 * @return
	 * @throws JSONException
	 */
	public static Map<String , String> parseJSON2Map(String jsonStr, String modelName) throws JSONException{
		Map<String, String> map = new HashMap<String, String>();
		JSONObject object = new JSONObject(jsonStr);
		//处理[{mdel}]
		JSONArray modelArray = object.getJSONArray(modelName);
		List<JSONObject> list = array2Object(modelArray);
		JSONObject object2 = list.get(0);
		map.put("info", object.getString("info"));
		map.put("status", object.getString("status"));
		Iterator<String> it = object2.keys();
		while (it.hasNext()) {
			String key = it.next().toString();
			map.put(key, object2.getString(key));
		}
		
		return map;
	}
	/**
	 * 将JSONArray转换成JSONObject的list
	 * @param array [{model}]
	 * @return
	 * @throws JSONException
	 */
	public static List<JSONObject> array2Object(JSONArray array) throws JSONException{
		List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			list.add(object);
		}
		return list;
	}
	
}
