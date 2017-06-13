package com.ksyche.tools.dao.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import com.ksyche.tools.dao.OutSQL;
import com.ksyche.tools.dao.Query;


public interface IStatementCreater {
	
	public <I> PreparedStatement createDeleteByID(Class<?> clazz, Connection conn, OutSQL sql, List<I> ids) throws Exception;
	
	public PreparedStatement createDeleteByCustom(Class<?> clazz, Connection conn, Map<String, Object> condition, OutSQL sql) throws Exception;

	
	public <I> PreparedStatement createGetByID(Class<?> clazz, Connection conn, OutSQL sql, List<I> ids, String columns) throws Exception;
	
	public PreparedStatement createGetByPage(Class<?> clazz, Connection conn, Map<String, Object> condition, String columns, int page, int pageSize, String orderBy, OutSQL sql) throws Exception;
	
	public PreparedStatement createGetByCustom(Class<?> clazz, Connection conn, String columns, Map<String, Object> condition, String orderBy, OutSQL sql) throws Exception;
	
	public PreparedStatement createGetByQuery(Class<?> clazz, Connection conn, Query query, String columns, int page, int pageSize, String orderBy, OutSQL sql) throws Exception;
	
	public PreparedStatement createGetCount(Class<?> clazz, Connection conn, Map<String, Object> condition, OutSQL sql) throws Exception;
	
	public PreparedStatement createGetCountByQuery(Class<?> clazz, Connection conn, Query query, OutSQL sql) throws Exception;
	
	
	public <I> PreparedStatement createUpdateByID(Class<?> clazz, Connection conn, Map<String, Object> updateStatement, OutSQL sql, List<I> ids) throws Exception;
	
	public PreparedStatement createUpdateByCustom(Class<?> clazz, Connection conn, Map<String, Object> updateStatement, Map<String, Object> condition, OutSQL sql) throws Exception;
	
	public <T> PreparedStatement createUpdateEntity(T bean, Connection conn, OutSQL sql) throws Exception;
	
	
	public <T> PreparedStatement createInsert(T bean, Connection conn, OutSQL sql) throws Exception;

	public <T> PreparedStatement createInsert(List<T> beans, Connection conn, OutSQL sql) throws Exception;

	public  PreparedStatement createUpdateByCustom(Class<?> clazz, Connection conn,
			Map<String, Object> kv, Query query, OutSQL sql) throws Exception;

	
}