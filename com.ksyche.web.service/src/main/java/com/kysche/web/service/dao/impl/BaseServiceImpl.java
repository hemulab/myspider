package com.kysche.web.service.dao.impl;

import java.util.List;
import java.util.Map;

import com.ksyche.tools.dao.Query;
import com.kysche.web.service.dao.BaseService;
/**
 * 对基本的dao方法进行封装 接口请继承BaseServie
 * @author Administrator
 *
 * @param <T> 实体
 */
public abstract class BaseServiceImpl<T> extends DBProvider implements BaseService<T>{
	
	/**
	 * 返回这个实体的Class
	 * @return
	 */
	protected abstract Class<T> getEntityClass ();
	
	@Override
	public long add(T t) throws Exception {
		if(t==null){
			return 0;
		}
		return daoHelper.insert(t);
	}

	@Override
	public long add(List<T> list) throws Exception {
		if(list==null || list.isEmpty()){
			return 0;
		}
		return daoHelper.insert(list);
	}

	@Override
	public int update(T t) throws Exception {
		return daoHelper.update(t);
	}

	@Override
	public int update(Map<String, Object> kv, long id) throws Exception {
		return daoHelper.updateByID(getEntityClass(), kv, id);
	}

	@Override
	public int update(Map<String, Object> kv, Map<String, Object> condition)
			throws Exception {
		return daoHelper.update(getEntityClass(), kv, condition);
	}

	@Override
	public T get(long id) throws Exception {
		return daoHelper.get(getEntityClass(), id);
	}

	@Override
	public List<T> get(List<Long> ids) throws Exception {
		return daoHelper.getsByID(getEntityClass(), ids);
	}

	@Override
	public List<T> get(Map<String, Object> condition, String orderBy)
			throws Exception {
		return daoHelper.gets(getEntityClass(), "*", condition, orderBy);
	}

	@Override
	public List<T> get(Map<String, Object> condition, int page, int size,
			String orderBy) throws Exception {
		return daoHelper.gets(getEntityClass(), "*", condition, page, size, orderBy);
	}

	@Override
	public List<T> get(Query query, int page, int size, String orderBy)
			throws Exception {
		return daoHelper.getByQuery(getEntityClass(), "*", query, page,size, orderBy);
	}

	@Override
	public List<T> get(String sql, Object... params) throws Exception {
		return daoHelper.getBySQL(getEntityClass(), sql, params);
	}

	@Override
	public int countByQuery(Query query) throws Exception {
		return daoHelper.countByQuery(getEntityClass(), query);
	}

	@Override
	public int countBySql(String sql, Object... params) throws Exception {
		return daoHelper.countBySQL(sql, params);
	}

	@Override
	public int update(Map<String, Object> kv, List<Long> ids) throws Exception {
		return daoHelper.updateByID(getEntityClass(), kv, ids);
	}

	@Override
	public int deleteById(long id) throws Exception {
		if(id<=0){
			return 0;
		}
		return daoHelper.deleteByID(getEntityClass(), id);
	}

	@Override
	public T getSingle(Map<String, Object> condition, String orderBy)
			throws Exception {
		List<T> list = get(condition, orderBy);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int delete(Map<String, Object> condition) throws Exception {
		return daoHelper.delete(getEntityClass(), condition);
		
	}

	@Override
	public int update(Map<String, Object> kv, Query query) throws Exception {
		return daoHelper.update(getEntityClass(), kv, query);
	}
	
}
