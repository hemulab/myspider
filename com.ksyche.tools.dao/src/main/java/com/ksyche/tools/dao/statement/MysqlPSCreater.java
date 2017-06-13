package com.ksyche.tools.dao.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ksyche.tools.dao.ClassHelper;
import com.ksyche.tools.dao.OutSQL;
import com.ksyche.tools.dao.Query;

public class MysqlPSCreater extends PSCreaterBase {

	@Override
	public PreparedStatement createGetByPage(Class<?> clazz, 
			Connection conn,
			Map<String, Object> condition, 
			String columns, 
			int page,
			int pageSize, 
			String orderBy, 
			OutSQL sql) throws Exception {
		int offset = pageSize * (page - 1);
		StringBuffer sbSql = new StringBuffer("SELECT ");
		if (columns == null || columns.trim().equalsIgnoreCase("")) {
			sbSql.append("*");
		} else {
			sbSql.append(columns);
		}
		sbSql.append(" FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));

		int index = 0;
		Set<String> keys = null;
		if(condition != null && condition.size()>0) {
			sbSql.append(" WHERE ");
			keys = condition.keySet();
			for(String key : keys) {
				if(index != 0) {
					sbSql.append(" AND ");
				}
				sbSql.append('`');
				sbSql.append(key);
				sbSql.append('`');
				sbSql.append("=?");
				index++;
			}
		}
		
		if(orderBy != null && !orderBy.equalsIgnoreCase("")) {
			sbSql.append(" ORDER BY ");
			sbSql.append(orderBy);
		}
		sbSql.append(" LIMIT ?,?");
//		sbSql.append(offset);
//		sbSql.append(",");
//		sbSql.append(pageSize);

		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		
		index = 1;
		if(condition != null && condition.size()>0) {
			for(String key : keys) {
				ClassHelper.setPara(ps, condition.get(key), index);
				index++;
			}
		}
		
		ClassHelper.setPara(ps, offset, index);
		index++;
		ClassHelper.setPara(ps, pageSize, index);
		
		return ps;
	}

	@Override
	public PreparedStatement createGetByQuery(Class<?> clazz,
			Connection conn,
			Query query,
			String columns,
			int page,
			int pageSize,
			String orderBy,
			OutSQL sql) throws Exception {
		int offset = pageSize * (page - 1);
		StringBuffer sbSql = new StringBuffer("SELECT ");
		if (columns == null || columns.trim().equalsIgnoreCase("")) {
			sbSql.append("*");
		} else {
			sbSql.append(columns);
		}
		sbSql.append(" FROM ");
		sbSql.append(ClassHelper.getTableName(clazz));
		if(query!=null && !query.isEmpty()) {
			sbSql.append(" WHERE ");
			sbSql.append(query.toSql());
		}

		if(orderBy != null && !orderBy.equalsIgnoreCase("")) {
			sbSql.append(" ORDER BY ");
			sbSql.append(orderBy);
		}
		sbSql.append(" LIMIT ?,?");

		sql.setSql(sbSql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.getSql());
		
		int index = 1;
		if(query != null) {
			List<Object> values = query.values();
			for(int i=0; i<values.size(); i++) {
				ClassHelper.setPara(ps, values.get(i), index);
				index++;
			}
		}
		ClassHelper.setPara(ps, offset, index);
		index++;
		ClassHelper.setPara(ps, pageSize, index);
		
		return ps;
	}
	
}