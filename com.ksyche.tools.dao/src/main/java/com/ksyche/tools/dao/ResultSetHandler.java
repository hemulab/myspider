/**
 * 
 */
package com.ksyche.tools.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ResultSetHandler
 * 
 * @author Wang Lianbin
 * @date 2014-6-7 下午4:11:08
 */
public interface ResultSetHandler<T> {
	T handle(ResultSet rs) throws SQLException;
}
