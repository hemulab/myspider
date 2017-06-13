package com.ksyche.tools.dao.statement;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ksyche.tools.dao.ClassHelper;
import com.ksyche.tools.dao.OutSQL;
import com.ksyche.tools.dao.Query;


public abstract class PSCreaterBase implements IStatementCreater {

	@Override
	public <I> PreparedStatement createGetByID(Class<?> clazz, Connection conn, OutSQL sql, List<I> ids, String columns) throws Exception {
		StringBuffer sbSql = new StringBuffer("SELECT ");
		if(columns!=null && !columns.equals("")) {
			sbSql.append(columns);
		} else {
			sbSql.append('*');
		}
		sbSql.append(" FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append(" WHERE ");
		
		List<Field> fieldList = ClassHelper.getIdFields(clazz);
		if (fieldList.size() != 1) {
			throw new Exception("无法根据主键ID获取数据：主键不存在 或 有两个以上的主键");
		} else {
			sbSql.append(ClassHelper.getDBCloumnName(clazz, fieldList.get(0)));
		}
		
		sbSql.append(" IN (");
		for(int i=0; i<ids.size(); i++) {
			if(i > 0) {
				sbSql.append(",");
			}
			sbSql.append("?");
		}
		sbSql.append(")");
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		int index = 1;
		for(I id : ids) {
			ClassHelper.setPara(ps, id, index);
			index++;
		}
		
		return ps;
	}

	@Override
	public PreparedStatement createGetByCustom(Class<?> clazz, 
			Connection conn, 
			String columns, 
			Map<String, Object> condition, 
			String orderBy, 
			OutSQL sql) throws Exception {
		
		StringBuffer sbSql = new StringBuffer("SELECT ");
		if (columns == null || columns.trim().equals("")) {
			sbSql.append("*");
		} else {
			sbSql.append(columns);
		}
		sbSql.append(" FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));
		
		int index = 0;
		Set<String> keys = null;
		if(condition != null) {
			sbSql.append(" WHERE ");
			keys = condition.keySet();
			for(String key : keys) {
				if(index != 0) {
					sbSql.append(" AND ");
				}
				sbSql.append(key);
				sbSql.append("=?");
				index++;
			}
		}
		
		if(orderBy != null && !orderBy.trim().equals("")) {
			sbSql.append(" ORDER BY ");
			sbSql.append(orderBy);
		}
		
		sql.setSql(sbSql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		if(condition != null) {
			index = 1;
			for(String key : keys) {
				ClassHelper.setPara(ps, condition.get(key), index);
				index++;
			}
		}
		return ps;
	}
	
	
	@Override
	public PreparedStatement createGetCount(Class<?> clazz, 
			Connection conn,
			Map<String, Object> condition,
			OutSQL sql) throws Exception {
		StringBuffer sbSql = new StringBuffer("SELECT COUNT(0) FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));
		
		if(condition!=null && condition.size()>0) {
			sbSql.append(" WHERE ");
			Set<String> keys = condition.keySet();
			int index = 0;
			for(String key : keys) {
				if(index != 0) {
					sbSql.append(" AND ");
				}
				sbSql.append(key);
				sbSql.append("=?");
				index++;
			}
			
			sql.setSql(sbSql.toString());
			PreparedStatement ps = conn.prepareStatement(sql.getSql());
			index = 1;
			for(String key : keys) {
				ClassHelper.setPara(ps, condition.get(key), index);
				index++;
			}
			return ps;
		} else {
			sql.setSql(sbSql.toString());
			PreparedStatement ps = conn.prepareStatement(sql.getSql());
			return ps;
		}
	}
	
	public PreparedStatement createGetCountByQuery(Class<?> clazz, Connection conn, Query query, OutSQL sql) throws Exception {
		StringBuffer sbSql = new StringBuffer("SELECT COUNT(0) FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));
		
		if(query!=null && !query.isEmpty()) {
			sbSql.append(" WHERE ");
			sbSql.append(query.toSql());
		}
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		
		if(query != null) {
			List<Object> values = query.values();
			for(int i=0; i<values.size(); i++) {
				ClassHelper.setPara(ps, values.get(i), i+1);
			}
		}
		
		return ps;
	}
	
	@Override
	public <I> PreparedStatement createDeleteByID(Class<?> clazz,
			Connection conn, 
			OutSQL sql,
			List<I> ids) throws Exception {
		StringBuffer sbSql = new StringBuffer("DELETE FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append(" WHERE ");
		
		List<Field> fieldList = ClassHelper.getIdFields(clazz);
		if (fieldList.size() != 1) {
			throw new Exception("无法根据主键ID删除数据：主键不存在 或 有两个以上的主键");
		} else {
			sbSql.append(ClassHelper.getDBCloumnName(clazz, fieldList.get(0)));
		}
		sbSql.append(" IN (");
		for(int i=0; i<ids.size(); i++) {
			if(i > 0) {
				sbSql.append(",");
			}
			sbSql.append("?");
		}
		sbSql.append(")");
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		int index = 1;
		for(I id : ids) {
			ClassHelper.setPara(ps, id, index);
			index++;
		}
		
		return ps;
	}
	
	@Override
	public PreparedStatement createDeleteByCustom(Class<?> clazz, 
			Connection conn, 
			Map<String, Object> condition, 
			OutSQL sql) throws Exception {
	
		if(condition == null || condition.size() <=0) {
			throw new Exception("delete必须带条件");
		}
		
		StringBuffer sbSql = new StringBuffer("DELETE FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append(" WHERE ");
		Set<String> keys = condition.keySet();
		int index = 0;
		for(String key : keys) {
			if(index != 0) {
				sbSql.append(" AND ");
			}
			sbSql.append(key);
			sbSql.append("=?");
			index++;
		}
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		index = 1;
		for(String key : keys) {
			ClassHelper.setPara(ps, condition.get(key), index);
			index++;
		}
		
		return ps;
	}

	
	@Override
	public PreparedStatement createUpdateEntity(Object bean, Connection conn, OutSQL sql)
			throws Exception {
		
		Class<?> clazz = bean.getClass();
		List<Field> idFields = ClassHelper.getIdFields(clazz);
		if (idFields.size() == 0) {
			throw new Exception("无法根据实体更新：主键不存在 ");
		}

		List<Field> listField = ClassHelper.getUpdatableFields(clazz);
		if (listField.size() > 0) {
			StringBuffer sbSql = new StringBuffer("UPDATE ");
			sbSql.append(ClassHelper.getTableName(clazz));
			
			for (int i = 0; i < listField.size(); i++) {
				if (i==0) {
					sbSql.append(" SET ");
				} else {
					sbSql.append(", ");
				}
				sbSql.append(ClassHelper.getDBCloumnName(clazz, listField.get(i)));
				sbSql.append("=?");
			}

			sbSql.append(" WHERE ");
			for (int i = 0; i < idFields.size(); i++) {
				if (i != 0) {
					sbSql.append(" AND ");
				}
				sbSql.append(ClassHelper.getDBCloumnName(clazz, idFields.get(i)));
				sbSql.append("=?");
			}
			
			sql.setSql(sbSql.toString());
			PreparedStatement ps = conn.prepareStatement(sql.getSql());
			
			int index = 1;
			for (int i = 0; i < listField.size(); i++) {
				Method m = ClassHelper.getGetterMethod(clazz, listField.get(i));
				Object value = m.invoke(bean, new Object[] {});
				ClassHelper.setPara(ps, value, index);
				index++;
			}
			
			for (int i = 0; i < idFields.size(); i++) {
				Method m = ClassHelper.getGetterMethod(clazz, idFields.get(i));
				Object value = m.invoke(bean, new Object[] {});
				ClassHelper.setPara(ps, value, index);
				index++;
			}
			
			return ps;
			
		} else {
			throw new Exception("表实体没有字段");
		}
	}
	
	@Override
	public <I> PreparedStatement createUpdateByID(Class<?> clazz,
			Connection conn, 
			Map<String, Object> kv, 
			OutSQL sql,
			List<I> ids) throws Exception {
		List<Field> fieldList = ClassHelper.getIdFields(clazz);
		if (fieldList.size() != 1) {
			throw new Exception("无法根据主键ID获取数据：主键不存在 或 有两个以上的主键");
		}
		
		StringBuffer sbSql = new StringBuffer("UPDATE ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append(" SET ");
		
		boolean isFirst = true;
		Set<String> kvKeySet = kv.keySet();
		for(String key : kvKeySet) {
			if(!isFirst) {
				sbSql.append(',');
			}
			sbSql.append(key);
			sbSql.append("=?");
			isFirst = false;
		}

		sbSql.append(" WHERE ");
		sbSql.append(ClassHelper.getDBCloumnName(clazz, fieldList.get(0)));
		if(ids.size() > 1) {
			sbSql.append(" IN (");
			for(int i=0; i<ids.size(); i++) {
				if(i > 0) {
					sbSql.append(",");
				}
				sbSql.append("?");
			}
			sbSql.append(")");
		} else {
			sbSql.append("=?");
		}
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		
		int index = 1;
		Collection<Object> kvValues = kv.values();
		for (Object obj : kvValues) {
			ClassHelper.setPara(ps, obj, index);
			index++;
		}
		
		for (I id : ids) {
			ClassHelper.setPara(ps, id, index);
			index++;
		}
		
		return ps;
	}
	
	@Override
	public PreparedStatement createInsert(Object bean, Connection conn, OutSQL sql)
			throws Exception {

		Class<?> clazz = bean.getClass();
		StringBuffer sbSql = new StringBuffer("INSERT INTO ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append("(");
		List<Field> listField = ClassHelper.getInsertableFields(clazz);
		
		StringBuilder sbColumn = new StringBuilder();
		StringBuilder sbValue = new StringBuilder();
		for (int i = 0; i < listField.size(); i++) {
			if (i != 0) {
				sbColumn.append(", ");
				sbValue.append(", ");
			}
			sbColumn.append('`');
			sbColumn.append(ClassHelper.getDBCloumnName(clazz, listField.get(i)));
			sbColumn.append('`');
			
			sbValue.append("?");
		}
		
		sbSql.append(sbColumn);
		sbSql.append(") VALUES (");
		sbSql.append(sbValue);
		sbSql.append(")");
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql(), Statement.RETURN_GENERATED_KEYS);
		
		for (int i = 0; i < listField.size(); i++) {
			Method m = ClassHelper.getGetterMethod(clazz, (listField.get(i)));
			Object value = m.invoke(bean, new Object[] {});
			ClassHelper.setPara(ps, value, i+1);
		}
		
		return ps;
	}
	
	@Override
	public PreparedStatement createUpdateByCustom(Class<?> clazz, 
			Connection conn, 
			Map<String, Object> kv, 
			Map<String, Object> condition, 
			OutSQL sql) throws Exception {
		if(condition == null || condition.size() <=0) {
			throw new Exception("upate必须带条件");
		}
		
		StringBuffer sbSql = new StringBuffer("UPDATE ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append(" SET ");
		
		boolean isFirst = true;
		Set<String> kvKeySet = kv.keySet();
		for(String key : kvKeySet) {
			if(!isFirst) {
				sbSql.append(',');
			}
			sbSql.append('`');
			sbSql.append(key);
			sbSql.append('`');
			sbSql.append("=?");
			isFirst = false;
		}

		sbSql.append(" WHERE ");
		isFirst = true;
		Set<String> condKeySet = condition.keySet();
		for (String key : condKeySet) {
			if (!isFirst) {
				sbSql.append(" AND ");
			}
			sbSql.append('`');
			sbSql.append(key);
			sbSql.append('`');
			sbSql.append("=?");
			isFirst = false;
		}
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		
		int index = 1;
		Collection<Object> kvValues = kv.values();
		for (Object obj : kvValues) {
			ClassHelper.setPara(ps, obj, index);
			index++;
		}
		
		Collection<Object> condValues = condition.values();
		for (Object obj : condValues) {
			ClassHelper.setPara(ps, obj, index);
			index++;
		}
		
		return ps;
	}
	
	@Override
	public PreparedStatement createUpdateByCustom(Class<?> clazz, 
			Connection conn, 
			Map<String, Object> kv, 
			Query query, 
			OutSQL sql) throws Exception {
		if(query == null || query.isEmpty()) {
			throw new Exception("upate必须带条件");
		}
		
		StringBuffer sbSql = new StringBuffer("UPDATE ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append(" SET ");
		
		boolean isFirst = true;
		Set<String> kvKeySet = kv.keySet();
		for(String key : kvKeySet) {
			if(!isFirst) {
				sbSql.append(',');
			}
			sbSql.append('`');
			sbSql.append(key);
			sbSql.append('`');
			sbSql.append("=?");
			isFirst = false;
		}

		sbSql.append(" WHERE ");
		isFirst = true;
		if (query!=null&&!query.isEmpty()) {
			sbSql.append(query.toSql());
		}
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		
		int index = 1;
		Collection<Object> kvValues = kv.values();
		for (Object obj : kvValues) {
			ClassHelper.setPara(ps, obj, index);
			index++;
		}
		
		Collection<Object> condValues = query.values();
		for (Object obj : condValues) {
			ClassHelper.setPara(ps, obj, index);
			index++;
		}
		
		return ps;
	}
	
	
	@Override
	public PreparedStatement createInsert(List list, Connection conn, OutSQL sql)
			throws Exception {

		if(list==null ||list.isEmpty()){
			return null;
		}
		Object bean =  list.get(0);
		Class<?> clazz = bean.getClass();
		StringBuffer sbSql = new StringBuffer("INSERT INTO ");
		sbSql.append(ClassHelper.getTableName(clazz));
		sbSql.append("(");
		List<Field> listField = ClassHelper.getInsertableFields(clazz);
		
		StringBuilder sbColumn = new StringBuilder();
		StringBuilder sbValue = new StringBuilder();
		for (int i = 0; i < listField.size(); i++) {
			if (i != 0) {
				sbColumn.append(", ");
				sbValue.append(", ");
			}
			sbColumn.append('`');
			sbColumn.append(ClassHelper.getDBCloumnName(clazz, listField.get(i)));
			sbColumn.append('`');
			
			sbValue.append("?");
		}
		
		sbSql.append(sbColumn);
		sbSql.append(") VALUES (");
		sbSql.append(sbValue);
		sbSql.append(")");
		
		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql(), Statement.RETURN_GENERATED_KEYS);
		for(Object o : list){
			for (int i = 0; i < listField.size(); i++) {
				Method m = ClassHelper.getGetterMethod(clazz, (listField.get(i)));
				Object value = m.invoke(o, new Object[] {});
				ClassHelper.setPara(ps, value, i+1);
			}
			ps.addBatch();
		}
		
		
		return ps;
	}
	
}
