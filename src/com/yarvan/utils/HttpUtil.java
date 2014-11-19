package com.yarvan.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class HttpUtil {
	/**
	 * post方法请求
	 * @param method 请求方法
	 * @param modelName model名字
	 * @param array 对应jsonarray
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws JSONException 
	 * @throws IllegalArgumentException 
	 */
	public static String doPost(String method, String modelName, 
			List<Map<String, String>>modelMaps) throws 
	ClientProtocolException, IOException, IllegalArgumentException, JSONException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException{
		//构建JSONArray
		JSONArray array = MyJSONUtils.toJSONArray(modelMaps, modelName);
		//返回结果
		String result = null;
		//发起请求的全路径
		String URLpath = ""+method;
		//新建一个Httppost对象
		//TODO
		HttpPost httpPost = new HttpPost(URLpath);
//		HttpPost httpPost = new HttpPost("http://192.168.200.138:8080/ServerForDate/login");
		//配置参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(modelName,array.toString()));
		//设置字符集
		HttpEntity entity = new UrlEncodedFormEntity( params, HTTP.UTF_8);
		//设置参数实体
		httpPost.setEntity(entity);
		//获取httpclient对象及httpResponse实例
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = httpClient.execute(httpPost);
		//判断请求是否成功
		if(httpResponse.getStatusLine().getStatusCode() == 200){
			result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		}else {
			Log.i("HTTP_POST", "HTTPPOST方法请求失败");
		}
		return result;
	}
}
