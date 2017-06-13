package com.ksyche.tools.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListHandler<T> implements ResultSetHandler<List<T>> {

	@Override
	public List<T> handle(ResultSet rs) throws SQLException {
		List<T> list = new ArrayList<T>();
		while (rs.next()) {
			list.add(this.handleRow(rs));
		}
		return list;
	}

	protected abstract T handleRow(ResultSet rs) throws SQLException;
}
