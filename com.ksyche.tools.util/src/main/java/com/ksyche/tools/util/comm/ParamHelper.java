package com.ksyche.tools.util.comm;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bj58.wf.mvc.BeatContext;

public class ParamHelper {

	public static int getInt(BeatContext beat, String key, int def) {
		String value = beat.getRequest().getParameter(key);
		if (value == null || value.equals("")) {
			return def;
		}

		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			return def;
		}
	}

	public static Integer[] getIntArray(BeatContext beat, String key) {
		// String value = beat.getRequest().getParameter(key);
		String[] value = beat.getRequest().getParameterValues(key);
		if (value == null || value.length == 0) {
			return null;
		}

		// if(value.length==0){
		// String[] split = value[0].split(",");
		// if(split.length>0){
		// Integer [] arry = new Integer[split.length];
		// for(int i=0;i<split.length;i++){
		// try{
		// arry[i] = Integer.parseInt(value[i]);
		// }catch(Exception e){
		//
		// }
		// }
		// return arry;
		// }
		// }

		Integer[] arry = new Integer[value.length];
		for (int i = 0; i < value.length; i++) {
			try {
				arry[i] = Integer.parseInt(value[i]);
			} catch (Exception e) {

			}
		}

		return arry;
	}

	public static String getString(BeatContext beat, String key, String def) {
		String value = beat.getRequest().getParameter(key);
		if (value == null || value.equals("")) {
			return def;
		}

		try {
			return URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return def;
		}
	}

	public static long getLong(BeatContext beat, String key, long def) {
		String value = beat.getRequest().getParameter(key);
		if (value == null || value.equals("")) {
			return def;
		}

		try {
			return Long.parseLong(value.trim());
		} catch (Exception e) {
			return def;
		}
	}

	public static double getDouble(BeatContext beat, String key, double def) {
		String value = beat.getRequest().getParameter(key);
		if (value == null || value.equals("")) {
			return def;
		}

		try {
			return Double.parseDouble(URLDecoder.decode(value.trim(), "utf-8"));
		} catch (Exception e) {
			return def;
		}
	}

	/**
	 * 简析一个参数为可请求的url
	 * @param key
	 * @param array
	 * @return
	 */
	public static String parseParam(String key, Integer[] array) {
		if (array != null && array.length > 0) {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < array.length; i++) {
				if (array[i] != null)
					sb.append("&").append(key).append("=").append(array[i]);
			}
			return sb.toString();
		}
		return "";
	}
	
	public static String parseParam(String key, Long[] array) {
		if (array != null && array.length > 0) {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < array.length; i++) {
				if (array[i] != null)
					sb.append("&").append(key).append("=").append(array[i]);
			}
			return sb.toString();
		}
		return "";
	}

	public static String parseParam(String key, String[] array) {
		if (array != null && array.length > 0) {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < array.length; i++) {
				if (array[i] != null)
					sb.append("&").append(key).append("=").append(array[i]);
			}
			return sb.toString();
		}
		return "";
	}

	public static Long[] getLongArray(BeatContext beat, String key) {
		String[] value = beat.getRequest().getParameterValues(key);
		if (value == null || value.length == 0) {
			return null;
		}

		Long[] arry = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			try {
				arry[i] = Long.parseLong(value[i]);
			} catch (Exception e) {

			}
		}

		return arry;
	}
	
	/**
	 * 获取用户的查询字符串
	 * **/
	public static String getQueryString(BeatContext beat){
		return beat.getRequest().getQueryString();
	}
	
	/**
	 * 返回服务器请求地址
	 * **/
	public static String getServletPath(BeatContext beat){
		return beat.getRequest().getServletPath();
	}
	
	
	public static String[] getStringArr(BeatContext beat, String key){
		return beat.getRequest().getParameterValues(key);
	}
	
	/**
	 * 懒惰的解析请求的方法
	 * 	主要针对有大量重复的对象表单提交，可以转换成对应的实体机会
	 * 	<b>注意：</b>实体的字段名称必须和表单的提交名称一致 
	 * 			如： name字段对应请求 name0...  相同数字对应请求数据将被封装在同一实体中 
	 * @param beat
	 * @param t 要实例化的实体class
 	 * @param maxNum 最多的实体数目
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> List<T> fromBeat(BeatContext beat,Class<T> t,int maxNum) throws IllegalArgumentException,Exception{
		Field[] fields = t.getDeclaredFields();
		Map<String, String[]> parameterMap = beat.getRequest().getParameterMap();
		int num = 0;
		List<T> list = new ArrayList<T>();
		while(true){
			T vo = t.newInstance();
			for(Field f : fields){
				f.setAccessible(true);
				String paramName = f.getName();
				if(num != 0){
					paramName = paramName + num;
				}
				String[] strings = parameterMap.get(paramName);
				if(strings==null){
					continue;
				}else{
					//parameterMap.remove(paramName);
				}
				
				if(f.getType().isArray()){
					Long[] longArray = ParamHelper.getLongArray(beat,paramName );
					f.set(vo, longArray);
				}else if(f.getType() == Integer.TYPE){
					f.setInt(vo, ParamHelper.getInt(beat, paramName, 0));
				}else if(f.getType() == Double.TYPE){
					f.setDouble(vo, ParamHelper.getDouble(beat, paramName, 0));
				} else if(f.getType()==Long.TYPE){
					f.setLong(vo, ParamHelper.getLong(beat, paramName, 0));
				} else{//TODO测试简析string
					f.set(vo, ParamHelper.getString(beat, paramName, ""));
				}
			}
			num++;
			
			
			list.add(vo);
			
			if(num>maxNum){
				break;
			}
			
		}
		return list;
	}
	
	/**
	 * 懒惰的解析请求的方法
	 * 解析vo中所有字段数据从请求中提取
	 * @param beat
	 * @param t 要实例化的实体class
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> T fromBeat(BeatContext beat,Class<T> t) throws IllegalArgumentException,Exception{
		Field[] fields = t.getDeclaredFields();
		Map<String, String[]> parameterMap = beat.getRequest().getParameterMap();
		int num = 0;
			T vo = t.newInstance();
			for(Field f : fields){
				f.setAccessible(true);
				String paramName = f.getName();
				if(num != 0){
					paramName = paramName + num;
				}
				String[] strings = parameterMap.get(paramName);
				if(strings==null){
					continue;
				}else{
					//parameterMap.remove(paramName);
				}
				
				if(f.getType().isArray()){
					Long[] longArray = ParamHelper.getLongArray(beat,paramName );
					f.set(vo, longArray);
				}else if(f.getType() == Integer.TYPE){
					f.setInt(vo, ParamHelper.getInt(beat, paramName, 0));
				}else if(f.getType() == Double.TYPE){
					f.setDouble(vo, ParamHelper.getDouble(beat, paramName, 0));
				} else if(f.getType()==Long.TYPE){
					f.setLong(vo, ParamHelper.getLong(beat, paramName, 0));
				} else{//TODO测试简析string
					f.set(vo, ParamHelper.getString(beat, paramName, ""));
				}
			}
			num++;
		return vo;
	}
	
	public static Double[] getDoubleArray(BeatContext beat, String key) {
		// String value = beat.getRequest().getParameter(key);
		String[] value = beat.getRequest().getParameterValues(key);
		if (value == null || value.length == 0) {
			return null;
		}

		// if(value.length==0){
		// String[] split = value[0].split(",");
		// if(split.length>0){
		// Integer [] arry = new Integer[split.length];
		// for(int i=0;i<split.length;i++){
		// try{
		// arry[i] = Integer.parseInt(value[i]);
		// }catch(Exception e){
		//
		// }
		// }
		// return arry;
		// }
		// }

		Double[] arry = new Double[value.length];
		for (int i = 0; i < value.length; i++) {
			try {
				arry[i] = Double.parseDouble(value[i]);
			} catch (Exception e) {

			}
		}

		return arry;
	}
}
