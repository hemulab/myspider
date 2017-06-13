package com.ksyche.tools.util.bean;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("unchecked")
public abstract class BeanFactoryUtils {
	
	private static final ConcurrentMap<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();
	
	/**
	 *  @Description	: 根据类型获取bean，如果不存在创建一个单态bean并缓存
	 *  @return         : T
	 *  @Creation Date  : 2015-4-17 下午12:13:37 
	 *  @Author         : wangchao
	 */
	public static <T> T getBean(Class<T> clazz) throws Exception{
		if(clazz == null)
			throw new RuntimeException("bean class 不能为空！");
		
		String className = clazz.getSimpleName();
		T t = (T) singletonObjects.get(className);
		
		if(t == null)
			singletonObjects.putIfAbsent(className, BeanUtils.newInstance(clazz));

		return  (T) (t != null ? t : singletonObjects.get(className));
	}
	
	
}
