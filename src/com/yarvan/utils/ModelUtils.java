package com.yarvan.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


public class ModelUtils {
	/**
	 * 传入map和model名返回该model对象，map中key要和model中key对应。
	 * @param modelMap
	 * @param modelName
	 * @return 与modelName对应的对象，值为modelMap中的值
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object toModel(Map<String, String> modelMap, String modelName)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		Class clazz = Class.forName(modelName);
		Object object = clazz.newInstance();
		for(String key : modelMap.keySet()){
			String setMethodName = BaseUtils.setMethodName(key);
			Method method = clazz.getDeclaredMethod(setMethodName, String.class);
			method.setAccessible(true);
			method.invoke(object, modelMap.get(key));
		}
		return object;
	}
}
