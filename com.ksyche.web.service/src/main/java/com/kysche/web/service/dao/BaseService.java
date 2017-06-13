package com.kysche.web.service.dao;

import java.util.List;
import java.util.Map;

import com.ksyche.tools.dao.Query;

/**
 * 对一些公用的dao方法进行了封�?，只�?��自己去写特殊的方法就�?
 * @author Administrator
 *
 * @param <T> 对应的实�?
 */
public interface BaseService<T> {

	public long add(T t) throws Exception;
	
	public long add(List<T> list) throws Exception;
	
	public int update(T t) throws Exception;
	
	public int update(Map<String,Object> kv ,long id) throws Exception;
	
	public int update(Map<String,Object> kv,List<Long> ids) throws Exception;
	
	public int update(Map<String,Object>kv ,Map<String,Object>condtition) throws Exception;
	
	public T get(long id) throws Exception;
	
	public List<T> get(List<Long> ids) throws Exception;
	
	public List<T> get(Map<String,Object> condition,String orderBy) throws Exception;
	
	public T getSingle(Map<String,Object> condition,String orderBy) throws Exception;

	
	public List<T> get(Map<String,Object> condition,int page,int size,String orderBy ) throws Exception;
	
	public List<T> get(Query query,int page,int size ,String roderBy) throws Exception;
	
	public List<T> get(String sql ,Object ...params) throws Exception;
	
	public int countByQuery(Query query) throws Exception ;
	
	public int countBySql(String sql, Object ...params) throws Exception;
	
	public int deleteById(long id) throws Exception;
	
	public int delete(Map<String,Object> condition ) throws Exception;

	int update(Map<String, Object> kv, Query query) throws Exception;
	
}
