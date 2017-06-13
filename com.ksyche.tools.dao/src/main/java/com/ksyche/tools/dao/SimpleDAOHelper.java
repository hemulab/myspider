package com.ksyche.tools.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ksyche.tools.dao.handler.ColumnListHandler;
import com.ksyche.tools.dao.handler.ScalarHandler;

class SimpleDAOHelper extends DAOHelper {

	@Override
	public <I, T> I insert(T t) throws Exception {
		Class<?> beanCls = t.getClass();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.get();
			ps = psCreater.createInsert(t, conn, sql);
			ps.setQueryTimeout(INSERT_TIMEOUT);
			ps.executeUpdate();

			List<Field> identityFields = ClassHelper.getIdentityFields(beanCls);
			List<Field> idFields = ClassHelper.getIdFields(beanCls);
			if (identityFields.size() == 1) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					return (I) rs.getObject(1);
				}
			} else if (identityFields.size() == 0 && idFields != null && idFields.size() > 0) {
				Method m = ClassHelper.getGetterMethod(beanCls, (idFields.get(0)));
				return (I) m.invoke(t, new Object[] {});
			}
		} catch (Exception e) {
			logger.error("insert error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}

		return null;
	}

	@Override
	public <T> int update(T t) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.get();
			ps = psCreater.createUpdateEntity(t, conn, sql);
			ps.setQueryTimeout(INSERT_TIMEOUT);
			return ps.executeUpdate();
		} catch (Exception e) {
			logger.error("update error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <I, T> int updateByID(Class<T> cls, Map<String, Object> kv, I id) throws Exception {
		List<I> ids = new ArrayList<I>();
		ids.add(id);
		return updateByID(cls, kv, ids);
	}

	@Override
	public <I, T> int updateByID(Class<T> cls, Map<String, Object> kv, List<I> ids) throws Exception {
		if (ids == null || ids.size() == 0) {
			return 0;
		}

		String cn = checkColumn(cls, kv);
		if (cn != null) {
			throw new Exception("列名：" + cn + " 不合法");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.get();
			ps = psCreater.createUpdateByID(cls, conn, kv, sql, ids);
			ps.setQueryTimeout(INSERT_TIMEOUT);
			return ps.executeUpdate();
		} catch (Exception e) {
			logger.error("update error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> int update(Class<T> cls, Map<String, Object> kv, Map<String, Object> condition) throws Exception {
		String cn = checkColumn(cls, kv, condition);
		if (cn != null) {
			throw new Exception("列名：" + cn + " 不合法");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.get();
			ps = psCreater.createUpdateByCustom(cls, conn, kv, condition, sql);
			ps.setQueryTimeout(INSERT_TIMEOUT);
			return ps.executeUpdate();
		} catch (Exception e) {
			logger.error("update error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}
	
	@Override
	public <T> int update(Class<T> cls, Map<String, Object> kv, Query query) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.get();
			ps = psCreater.createUpdateByCustom(cls, conn, kv, query, sql);
			ps.setQueryTimeout(INSERT_TIMEOUT);
			return ps.executeUpdate();
		} catch (Exception e) {
			logger.error("update error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <I, T> int deleteByID(Class<T> cls, I id) throws Exception {
		List<I> ids = new ArrayList<I>();
		ids.add(id);
		return deleteByID(cls, ids);
	}

	@Override
	public <I, T> int deleteByID(Class<T> cls, List<I> ids) throws Exception {
		if (ids == null || ids.size() == 0) {
			return 0;
		}

		Connection conn = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.get();
			ps = psCreater.createDeleteByID(cls, conn, sql, ids);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			return ps.executeUpdate();
		} catch (Exception e) {
			logger.error("delete error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> int delete(Class<T> cls, Map<String, Object> condition) throws Exception {
		String cn = checkColumn(cls, condition);
		if (cn != null) {
			throw new Exception("列名：" + cn + " 不合法");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.get();
			ps = psCreater.createDeleteByCustom(cls, conn, condition, sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			return ps.executeUpdate();
		} catch (Exception e) {
			logger.error("delete error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T, I> T get(Class<T> cls, I id) throws Exception {
		return get(cls, id, null);
	}

	@Override
	public <T, I> T get(Class<T> cls, I id, String columns) throws Exception {
		List<I> ids = new ArrayList<I>();
		ids.add(id);
		List<T> list = getsByID(cls, ids, columns);
		return (list == null | list.size() == 0) ? null : list.get(0);
	}

	@Override
	public <T, I> List<T> getsByID(Class<T> cls, List<I> ids) throws Exception {
		return getsByID(cls, ids, null);
	}

	@Override
	public <T, I> List<T> getsByID(Class<T> cls, List<I> ids, String columns) throws Exception {
		if (ids == null || ids.size() == 0) {
			return null;
		}

		String cn = checkColumn(cls, columns);
		if (cn != null) {
			throw new Exception("列名：" + cn + " 不合法");
		}

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.getReadConnection();
			ps = psCreater.createGetByID(cls, conn, sql, ids, columns);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			rs = ps.executeQuery();
			return populateData(rs, cls);
		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> List<T> gets(Class<T> cls, String columns, Map<String, Object> condition, String orderBy)
			throws Exception {
		String cn = checkColumn(cls, condition);
		if (cn != null) {
			throw new Exception("列名：" + cn + " 不合法");
		}

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.getReadConnection();

			ps = psCreater.createGetByCustom(cls, conn, columns, condition, orderBy, sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			rs = ps.executeQuery();
			return populateData(rs, cls);
		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> List<T> gets(Class<T> cls, String columns, Map<String, Object> condition, int page, int pageSize,
			String orderBy) throws Exception {
		String cn = checkColumn(cls, condition);
		if (cn != null) {
			throw new Exception("列名：" + cn + " 不合法");
		}
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.getReadConnection();
			ps = psCreater.createGetByPage(cls, conn, condition, columns, page, pageSize, orderBy, sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			rs = ps.executeQuery();
			return populateData(rs, cls);
		} catch (Exception e) {
			logger.error("getListByPage error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> List<T> getByQuery(Class<T> cls, String columns, Query query, int page, int pageSize, String orderBy)
			throws Exception {
		// String cn = checkColumn(cls, columns);
		// if(cn != null) {
		// throw new Exception("列名：" + cn + " 不合法");
		// }
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.getReadConnection();
			ps = psCreater.createGetByQuery(cls, conn, query, columns, page, pageSize, orderBy, sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			rs = ps.executeQuery();
			return populateData(rs, cls);
		} catch (Exception e) {
			logger.error("getListByPage error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> List<T> getBySQL(Class<T> clazz, String sql, Object... param) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<T> dataList = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}

			rs = ps.executeQuery();
			dataList = populateData(rs, clazz);
		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
		return dataList;
	}

	@Override
	public int execBySQL(String sql, Object... param) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(INSERT_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public int countBySQL(String sql, Object... param) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}

			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}

		return 0;
	}

	@Override
	public int count(Class<?> cls, Map<String, Object> condition) throws Exception {
		String cn = checkColumn(cls, condition);
		if (cn != null) {
			throw new Exception("列名：" + cn + " 不合法");
		}

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.getReadConnection();
			ps = psCreater.createGetCount(cls, conn, condition, sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			logger.error("getCount error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
		return 0;
	}

	public int countByQuery(Class<?> cls, Query query) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		try {
			conn = connHelper.getReadConnection();
			ps = psCreater.createGetCountByQuery(cls, conn, query, sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			logger.error("getCount error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
		return 0;
	}

	@Override
	public Map<String, Object> getMap(String sql, Object... param) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}

			rs = ps.executeQuery();
			Map<String, Object> map = new HashMap<String, Object>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsCount = rsmd.getColumnCount();
			if (rs.next()) {
				for (int i = 0; i < columnsCount; i++) {
					String colName = rsmd.getColumnLabel(i + 1);
					map.put(colName, rs.getObject(colName));
				}
			}
			return map;
		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public List<Map<String, Object>> getMaps(String sql, Object... param) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}

			rs = ps.executeQuery();

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsCount = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < columnsCount; i++) {
					String colName = rsmd.getColumnLabel(i + 1);
					map.put(colName, rs.getObject(colName));
				}
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> T getSingleColumnResult(String sql, ScalarHandler<T> handler, Object... param) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}

			rs = ps.executeQuery();

			return handler.handle(rs);

		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> List<T> getListColumnResult(String sql, ColumnListHandler<T> handler, Object... param) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}

			rs = ps.executeQuery();

			return handler.handle(rs);

		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <T> T getCustomerResultBySQL(String sql, ResultSetHandler<T> handler, Object... param) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = connHelper.getReadConnection();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ClassHelper.setPara(ps, param[i], i + 1);
				}
			}

			rs = ps.executeQuery();

			return handler.handle(rs);

		} catch (SQLException e) {
			logger.error("getListByCustom error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	@Override
	public <I, T> I insert(List<T> list) throws Exception {
		if(list==null || list.isEmpty()){
			return null;
		}
		Object t = list.get(0);
		Class<?> beanCls = t.getClass();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		OutSQL sql = new OutSQL();
		int timeBuff = list.size()/10;
		try {
			conn = connHelper.get();
			ps = psCreater.createInsert(list, conn, sql);
			ps.setQueryTimeout(INSERT_TIMEOUT*timeBuff);
//			ps.executeUpdate();
			ps.executeBatch();

			List<Field> identityFields = ClassHelper.getIdentityFields(beanCls);
			List<Field> idFields = ClassHelper.getIdFields(beanCls);
			if (identityFields.size() == 1) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					return (I) rs.getObject(1);
				}
			} else if (identityFields.size() == 0 && idFields != null && idFields.size() > 0) {
				Method m = ClassHelper.getGetterMethod(beanCls, (idFields.get(0)));
				return (I) m.invoke(t, new Object[] {});
			}
		} catch (Exception e) {
			logger.error("insert error sql:" + sql.getSql(), e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}

		return null;
	}

	@Override
	public <T> T getOneBySQL(Class<T> clazz, String sql, Object... param)throws Exception {
		List<T> list = getBySQL(clazz, sql, param);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public <T> T getOneByQuery(Class<T> cls, String columns, Query query,
			int page, int pageSize, String orderBy) throws Exception {
		List<T> list = getByQuery(cls, columns, query, page, pageSize, orderBy);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
