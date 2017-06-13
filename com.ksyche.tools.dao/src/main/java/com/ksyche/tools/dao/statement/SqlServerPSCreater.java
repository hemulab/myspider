package com.ksyche.tools.dao.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import com.ksyche.tools.dao.OutSQL;
import com.ksyche.tools.dao.Query;

public class SqlServerPSCreater extends PSCreaterBase {

	@Override
	public PreparedStatement createGetByPage(Class<?> clazz, Connection conn,
			Map<String, Object> condition, String columns, int page,
			int pageSize, String orderBy, OutSQL sql) throws Exception {
		return null;
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
		return null;
	}
}