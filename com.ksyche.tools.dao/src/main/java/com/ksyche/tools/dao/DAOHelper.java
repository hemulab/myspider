package com.ksyche.tools.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ksyche.tools.dao.connpool.ConnectionHelper;
import com.ksyche.tools.dao.handler.ColumnListHandler;
import com.ksyche.tools.dao.handler.ScalarHandler;
import com.ksyche.tools.dao.statement.IStatementCreater;

/**
 * 实现IDAO的抽象基类
 * 
 * @author Administrator
 * 
 */
public abstract class DAOHelper {

	/**
	 * log
	 */
	protected static final Log logger = LogFactory.getLog(DAOHelper.class);

	protected IStatementCreater psCreater;

	protected ConnectionHelper connHelper;

	/**
	 * 默认查询超时时间
	 */
	protected int QUERY_TIMEOUT = 2;

	/**
	 * 默认添加/修改超时时间
	 */
	protected int INSERT_TIMEOUT = 5;

	/**
	 * 默认数据库配置文件路径(jar包所在目录 / bin所在目录)
	 */
	private static final String DB_CONFIG_PATH = "db.properties";

	protected DAOHelper() {

	}

	/**
	 * 创建DAO实例 (默认读取jar所在目录下的db.properties文件)
	 * 
	 * <p>
	 * <b>*.properties格式:</b><br />
	 * ConnetionURL:jdbc:sqlserver://127.0.0.1:12345;DatabaseName=DBName<br />
	 * DriversClass:com.microsoft.sqlserver.jdbc.SQLServerDriver<br />
	 * UserName:un<br />
	 * PassWord:pw<br />
	 * MinPoolSize:5<br />
	 * MaxPoolSize:30<br />
	 * IdleTimeout:30<br />
	 * SqlCreaterClass:com.bj58.sfft.utility.dao.sqlcreate.SqlServerSQLCreater<br />
	 * ProcCreaterClass:com.bj58.sfft.utility.dao.sqlcreate.
	 * BJ58AutoCreateProcParaCreater<br />
	 * </p>
	 * 
	 * @return DAO实例
	 * @throws Exception
	 */
	public static DAOHelper createIntrance() throws Exception {
		return createDAO(DB_CONFIG_PATH);
	}

	/**
	 * 创建DAO实例
	 * 
	 * @param configPath
	 *            配置文件路径
	 *            <p>
	 *            <b>*.properties格式:</b><br />
	 *            ConnetionURL:jdbc:sqlserver://127.0.0.1:12345;DatabaseName=
	 *            DBName<br />
	 *            DriversClass:com.microsoft.sqlserver.jdbc.SQLServerDriver<br />
	 *            UserName:un<br />
	 *            PassWord:pw<br />
	 *            MinPoolSize:5<br />
	 *            MaxPoolSize:30<br />
	 *            IdleTimeout:30<br />
	 *            SqlCreaterClass:com.bj58.sfft.utility.dao.sqlcreate.
	 *            SqlServerSQLCreater<br />
	 *            ProcCreaterClass:com.bj58.sfft.utility.dao.sqlcreate.
	 *            BJ58AutoCreateProcParaCreater<br />
	 *            </p>
	 * @return DAO实例
	 * @throws Exception
	 */
	public static DAOHelper createIntrance(String configPath) throws Exception {
		return createDAO(configPath);
	}

	/**
	 * 创建DAO
	 * 
	 * @param configPath
	 * @return
	 * @throws Exception
	 */
	private static DAOHelper createDAO(String configPath) throws Exception {
		ConnectionHelper ch = new ConnectionHelper(configPath);
		PropertiesHelper ph = new PropertiesHelper(configPath);

		String sqlCreaterClass = ph.getString("SqlCreaterClass");
		logger.info("init SqlCreaterClass:" + sqlCreaterClass);
		IStatementCreater creater = (IStatementCreater) Class.forName(sqlCreaterClass).newInstance();
		DAOHelper daoHelper = new SimpleDAOHelper();
		daoHelper.connHelper = ch;
		daoHelper.QUERY_TIMEOUT = ph.getInt("QurryTimeOut");
		daoHelper.INSERT_TIMEOUT = ph.getInt("InsertUpdateTimeOut");
		daoHelper.psCreater = creater;

		logger.info("create DAOHelper success!");
		return daoHelper;
	}

	protected <T> List<T> populateData(ResultSet rs, Class<T> clazz) throws Exception {
		List<T> dataList = new ArrayList<T>();
		List<Field> fieldList = ClassHelper.getAllFields(clazz);

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsCount = rsmd.getColumnCount();
		List<String> columnNameList = new ArrayList<String>();
		for (int i = 0; i < columnsCount; i++) {
			columnNameList.add(rsmd.getColumnLabel(i + 1).toLowerCase());
		}

		while (rs.next()) {
			T bean = clazz.newInstance();
			for (Field f : fieldList) {
				String columnName = ClassHelper.getDBCloumnName(clazz, f).toLowerCase();
				if (columnNameList.contains(columnName)) {
					Object columnValueObj = null;
					Class<?> filedCls = f.getType();

					if (filedCls == int.class || filedCls == Integer.class) {
						columnValueObj = rs.getInt(columnName);
					} else if (filedCls == String.class) {
						columnValueObj = rs.getString(columnName);
					} else if (filedCls == boolean.class || filedCls == Boolean.class) {
						columnValueObj = rs.getBoolean(columnName);
					} else if (filedCls == byte.class || filedCls == Byte.class) {
						columnValueObj = rs.getByte(columnName);
					} else if (filedCls == short.class || filedCls == Short.class) {
						columnValueObj = rs.getShort(columnName);
					} else if (filedCls == long.class || filedCls == Long.class) {
						columnValueObj = rs.getLong(columnName);
					} else if (filedCls == float.class || filedCls == Float.class) {
						columnValueObj = rs.getFloat(columnName);
					} else if (filedCls == double.class || filedCls == Double.class) {
						columnValueObj = rs.getDouble(columnName);
					} else if (filedCls == BigDecimal.class) {
						columnValueObj = rs.getBigDecimal(columnName);
					} else {
						columnValueObj = rs.getObject(columnName);
					}

					if (columnValueObj != null) {
						Method setterMethod = ClassHelper.getSetterMethod(clazz, f);
						setterMethod.invoke(bean, new Object[] { columnValueObj });
					}
				}
			}
			dataList.add(bean);
		}
		return dataList;
	}

	/**
	 * 开启事务(默认级别TRANSACTION_READ_COMMITTED)
	 * 
	 * @throws Exception
	 */
	public void beginTransaction() throws Exception {
		beginTransaction(Connection.TRANSACTION_READ_COMMITTED);
	}

	/**
	 * 开启事务
	 * 
	 * @param level
	 *            事务级别
	 * @throws Exception
	 */
	public void beginTransaction(int level) throws Exception {
		Connection conn = connHelper.get();
		if (conn != null) {
			try {
				conn.setAutoCommit(false);
				conn.setTransactionIsolation(level);
				connHelper.lockConn(conn);
			} catch (Exception ex) {
				logger.error(ex);
			}
		} else {
			throw new Exception("conn is null when beginTransaction");
		}
	}

	/**
	 * 提交事务
	 * 
	 * @throws Exception
	 */
	public void commitTransaction() throws Exception {
		Connection conn = connHelper.get();
		if (conn != null) {
			conn.commit();
		} else {
			throw new Exception("conn is null when commitTransaction");
		}
	}

	/**
	 * 回滚事务
	 * 
	 * @throws Exception
	 */
	public void rollbackTransaction() throws Exception {
		Connection conn = connHelper.get();
		if (conn != null) {
			conn.rollback();
		} else {
			throw new Exception("conn is null when rollbackTransaction");
		}
	}

	/**
	 * 结束事务
	 * 
	 * @throws Exception
	 */
	public void endTransaction() throws Exception {
		Connection conn = connHelper.get();
		if (conn != null) {
			// 恢复默认
			conn.setAutoCommit(true);
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

			connHelper.unLockConn();
			connHelper.release(conn);
		} else {
			throw new Exception("conn is null when endTransaction");
		}
	}

	/**
	 * 执行自定义的语句
	 * 
	 * @param sql
	 * @param params
	 * @param handler
	 * @throws Exception
	 */
	public void exec(String sql, List<Object> params, IExecHandler handler) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = connHelper.get();
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(QUERY_TIMEOUT);

			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					ClassHelper.setPara(ps, params.get(i), i + 1);
				}
			}

			rs = ps.executeQuery();
			handler.exec(rs);
		} catch (Exception e) {
			logger.error("execQuery error sql:" + sql, e);
			throw e;
		} finally {
			JdbcUitl.closeResultSet(rs);
			JdbcUitl.closeStatement(ps);
			connHelper.release(conn);
		}
	}

	public String checkColumn(Class<?> cls, Map<String, Object>... maps) {
		if (maps == null || maps.length == 0) {
			return null;
		}

		Map<String, String> columnMap = ClassHelper.getAllIgnoreCaseCN(cls);
		for (Map<String, Object> map : maps) {
			if (map == null) {
				continue;
			}

			Set<String> keys = map.keySet();
			for (String key : keys) {
				if (!columnMap.containsKey(key.toLowerCase())) {
					return key;
				}
			}
		}
		return null;
	}

	protected String checkColumn(Class<?> cls, String columns) {
		if (columns == null || columns.equals("")) {
			return null;
		}

		Map<String, String> columnMap = ClassHelper.getAllIgnoreCaseCN(cls);

		String[] aryCol = columns.split(",");
		for (String col : aryCol) {
			if (!columnMap.containsKey(col.toLowerCase())) {
				return col;
			}
		}
		return null;
	}

	public ConnectionHelper getConnHelper() {
		return connHelper;
	}

	/**
	 * insert a entity
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public abstract <I, T> I insert(T t) throws Exception;

	/**
	 * 更新实体
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public abstract <T> int update(T t) throws Exception;

	/**
	 * 更新主键更新
	 * 
	 * @param <I>
	 * @param cls
	 * @param kv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract <I, T> int updateByID(Class<T> cls, Map<String, Object> kv, List<I> ids) throws Exception;

	/**
	 * 
	 * @param <I>
	 * @param <T>
	 * @param cls
	 * @param kv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract <I, T> int updateByID(Class<T> cls, Map<String, Object> kv, I id) throws Exception;

	/**
	 * 
	 * @param cls
	 * @param kv
	 * @param condition
	 * @throws Exception
	 */
	public abstract <T> int update(Class<T> cls, Map<String, Object> kv, Map<String, Object> condition)
			throws Exception;

	/**
	 * delete record by id array
	 * 
	 * @param <I>
	 * @param cls
	 * @param id
	 * @throws Exception
	 */
	public abstract <I, T> int deleteByID(Class<T> cls, List<I> ids) throws Exception;

	/**
	 * 
	 * @param <I>
	 * @param <T>
	 * @param cls
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract <I, T> int deleteByID(Class<T> cls, I id) throws Exception;

	/**
	 * delete by custom
	 * 
	 * @param cls
	 * @param condition
	 * @throws Exception
	 */
	public abstract <T> int delete(Class<T> cls, Map<String, Object> condition) throws Exception;

	/**
	 * 根据ID获取单个实体
	 * 
	 * @param <T>
	 * @param <I>
	 * @param cls
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public abstract <T, I> T get(Class<T> cls, I id) throws Exception;

	/**
	 * 根据ID获取单个实体
	 * 
	 * @param cls
	 * @param id
	 * @param columns
	 *            列名
	 * @return
	 * @throws Exception
	 */
	public abstract <T, I> T get(Class<T> cls, I id, String columns) throws Exception;

	/**
	 * get entity list by ids
	 * 
	 * @param <T>
	 * @param <I>
	 * @param cls
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public abstract <T, I> List<T> getsByID(Class<T> cls, List<I> ids) throws Exception;

	/**
	 * 
	 * @param cls
	 * @param ids
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public abstract <T, I> List<T> getsByID(Class<T> cls, List<I> ids, String columns) throws Exception;

	/**
	 * get entity list by custom
	 * 
	 * @param cls
	 * @param columns
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws Exception
	 */
	public abstract <T> List<T> gets(Class<T> cls, String columns, Map<String, Object> condition, String orderBy)
			throws Exception;

	/**
	 * get entity list by page
	 * 
	 * @param cls
	 * @param condition
	 * @param columns
	 * @param page
	 * @param pageSize
	 * @param orderBy
	 * @return
	 * @throws Exception
	 */
	public abstract <T> List<T> gets(Class<T> cls, String columns, Map<String, Object> condition, int page,
			int pageSize, String orderBy) throws Exception;

	/**
	 * 
	 * @param cls
	 * @param columns
	 * @param query
	 * @param page
	 * @param pageSize
	 * @param orderBy
	 * @return
	 * @throws Exception
	 */
	public abstract <T> List<T> getByQuery(Class<T> cls, String columns, Query query, int page, int pageSize,
			String orderBy) throws Exception;
	
	/**
	 * 
	 * @param cls
	 * @param columns
	 * @param query
	 * @param page
	 * @param pageSize
	 * @param orderBy
	 * @return
	 * @throws Exception
	 */
	public abstract <T> T getOneByQuery(Class<T> cls, String columns, Query query, int page, int pageSize,
			String orderBy) throws Exception;

	/**
	 * get record count
	 * 
	 * @param cls
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public abstract int count(Class<?> cls, Map<String, Object> condition) throws Exception;

	public abstract int countByQuery(Class<?> cls, Query query) throws Exception;

	public abstract <T> T getOneBySQL(Class<T> cls,String sql,Object... param) throws Exception;
	
	public abstract <T> List<T> getBySQL(Class<T> cls, String sql, Object... param) throws Exception;

	public abstract int execBySQL(String sql, Object... param) throws Exception;

	public abstract int countBySQL(String sql, Object... param) throws Exception;

	public abstract Map<String, Object> getMap(String sql, Object... param) throws Exception;

	public abstract List<Map<String, Object>> getMaps(String sql, Object... param) throws Exception;

	public abstract <T> T getSingleColumnResult(String sql, ScalarHandler<T> handler, Object... param) throws Exception;

	public abstract <T> List<T> getListColumnResult(String sql, ColumnListHandler<T> handler, Object... param)
			throws Exception;

	public abstract <T> T getCustomerResultBySQL(String sql, ResultSetHandler<T> handler, Object... params)
			throws Exception;
	
	
	/**
	 * insert a entity
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public abstract <I, T> I insert(List<T> list) throws Exception;

	public <T> int update(Class<T> cls, Map<String, Object> kv, Query query)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}