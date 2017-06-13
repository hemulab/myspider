package com.ksyche.tools.dao.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ksyche.tools.dao.ResultSetHandler;

public class ScalarHandler<T> implements ResultSetHandler<T> {

	// 结果集中的列索引
	private final int columnIndex;

	// 结果集中的列名
	private final String columnName;

	public ScalarHandler() {
		this(1, null);
	}

	public ScalarHandler(int columnIndex) {
		this(columnIndex, null);
	}

	public ScalarHandler(String columnName) {
		this(1, columnName);
	}

	private ScalarHandler(int columnIndex, String columnName) {
		this.columnIndex = columnIndex;
		this.columnName = columnName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T handle(ResultSet rs) throws SQLException {
		if (rs.next()) {
			if (this.columnName == null) {
				return (T) rs.getObject(this.columnIndex);
			} else {
				return (T) rs.getObject(this.columnName);
			}
		} else {
			return null;
		}
	}

}
