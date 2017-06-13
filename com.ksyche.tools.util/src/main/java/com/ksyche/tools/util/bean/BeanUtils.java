package com.ksyche.tools.util.bean;

/**
 * @Project       : com.ksyche.tools.util
 * @Program Name  : com.ksyche.tools.util.bean.BeanUtils.java
 * @Description   : bean工具类
 * @Author        : wangchao
 * @Creation Date : 2015-4-16 下午4:24:42 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * wangchao     2015-4-16        create
 */
public abstract class BeanUtils extends org.springframework.beans.BeanUtils {
	
	public static <T> T newInstance(Class<T> clazz) throws Exception{
		return instantiate(clazz);
	}
	
	public static <T> T newInstance(Class<T> clazz,Object... args) throws Exception{
		return instantiateClass(clazz.getDeclaredConstructor(),args);
	}

}
