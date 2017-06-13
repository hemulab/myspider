package com.ksyche.tools.dao.connpool;

import javax.sql.DataSource;

import com.bj58.spat.core.dbms.AbstractDataSource;
import com.bj58.spat.core.dbms.DataSourceFactory;
import com.bj58.spat.core.dbms.config.ConfigUtil;
import com.bj58.spat.core.dbms.config.DataSourceConfig;

class ConnectionPoolFactory {
	
	/**
	 * 根据配置文件，得到对应的ConnectionPool，该ConnectionPool封装SWAP DataSource实现
	 * @param configPath
	 * @return
	 * @throws Exception
	 */
	public synchronized static ConnectionPool createPool(String configPath) throws Exception{

		DataSourceConfig dataSourceConfig = ConfigUtil.getDataSourceConfig(configPath);
		DataSourceFactory.setConfig(dataSourceConfig);
		DataSource datasource = DataSourceFactory.getDataSource("_DEFAULT");
		
		AbstractDataSource aDataSource = (AbstractDataSource) datasource;
		
		SwapConnectionPool dbConnectionPool = new SwapConnectionPool(aDataSource);
		
		return dbConnectionPool;
		
	}

	
	private ConnectionPoolFactory(){
		
	}
}
