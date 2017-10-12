package com.gx.car.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Json字符串与bean转换工具�?
 * @author gaojian
 * @date 2013-9-11
 */
public class JsonUtils {
	private static class LazyHolder {
		private static final Gson INSTANCE = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}
	/**
	 * MD5加密
	 * @param orgString
	 * @return
	 * @throws java.security.NoSuchAlgorithmException
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static String md5Encrypt(String orgString) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(orgString.getBytes());
			byte[] b = md.digest();
			return byte2hex(b);
		} catch (java.security.NoSuchAlgorithmException ne) {
			throw new IllegalStateException("System doesn't support your  Algorithm.");
		}
	}

	/**
	 * 将字节数组转换成16进制字符�?
	 * @param b
	 * @return
	 */
	private static String byte2hex(byte[] b) // 二行制转字符�?

	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs;
	}
	/**
	 * 把Bean转换成字符串
	 * EdiUtil.bean2Json()<BR>
	 * <P>Author :gj </P>  
	 * <P>Date : Jan 5, 2013 </P>
	 * @param bean
	 * @return
	 */
	public static String bean2Json(Object bean){
		Gson gson = getGson();
		try{
		return gson.toJson(bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *初始化Gson对象，确保Gson对象唯一
	 * EdiUtil.getGson()<BR>
	 * <P>Author :gj </P>  
	 * <P>Date : Jan 5, 2013 </P>
	 * @return 返回�?个Gson对象
	 */
	public static Gson getGson() {
		return LazyHolder.INSTANCE;
	}
	
	/**
	 * 把Bean转换成字符串
	 * EdiUtil.List<Bean>2Json()<BR>
	 * <P>Author :gj </P>  
	 * <P>Date : Jan 5, 2013 </P>
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("unused")
	public static <T> String List2Json(List<T> list){
		Gson gson = getGson();
		Type type = new TypeToken<List<T>>(){}.getType(); 
		return gson.toJson(list);
	}
	
	
	/**
	 * 把字符串转换成Bean
	 * EdiUtil.Json2List<Bean>()<BR>
	 * <P>Author :gj </P>  
	 * <P>Date : Jan 5, 2013 </P>
	 * @param bean
	 * @return
	 */
	public static <T> List<T> Json2List(String json,Class<T> clazz){
		Gson gson = getGson();
		Type type = new TypeToken<List<T>>(){}.getType(); 
		return gson.fromJson(json, type);
	}
	
	/**
	 * 将map集合转换成String类型的JSON数据格式
	 * 
	 * @param map
	 * @return
	 */
	public static String map2json(@SuppressWarnings("rawtypes") Map map){
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
		
	}
	

	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(String jsonStr){
        Map<String, Object> map = new HashMap<String, Object>();
        //�?��层解�?
        JSONObject json = JSONObject.fromObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k); 
            //如果内层还是数组的话，继续解�?
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> JsonToList(String json,Class<T> clazz){
		List<T> list = new ArrayList<T>();
		if (json==null || "".equals(json)) {
			return list;
		}
		if (clazz == null) {
			return list;
		}
		try {
			JSONArray jsonArray = JSONArray.fromObject(json);
			if (jsonArray == null) {
				return list;
			}
			list = (List<T>) JSONArray.toCollection(jsonArray, clazz);
			return list;
		} catch (Exception e) {
			return list;
		}
	}
}