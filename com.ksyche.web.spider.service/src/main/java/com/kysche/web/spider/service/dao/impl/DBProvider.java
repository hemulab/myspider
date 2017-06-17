package com.kysche.web.spider.service.dao.impl;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bj58.wf.core.WF;
import com.ksyche.tools.dao.DAOHelper;
/**
 * 请继�? BaseServiceImpl 这个�?
 * @author Administrator
 *
 */
public abstract class DBProvider {

	protected static Log log = LogFactory.getLog(DBProvider.class);

	protected static DAOHelper daoHelper;
	
	static {
		String path = System.getProperty("dao.root.path");
		if (path == null || path.equals("")) {
			path = WF.getConfigFolder() + WF.getNamespace() + "/";
		}

		initDAO(path);
	}

	private static void initDAO(String rootPath) {
		log.info("rootPath:" + rootPath);

		String carPath = rootPath + "db.properties";
		try {
			File carDB = new File(carPath);
			if (carDB.exists()) {
				log.info("creating mobileDAO(" + carPath);
				daoHelper = DAOHelper.createIntrance(carPath);
			}
		} catch (Exception e) {
			log.error("create mobile error(" + carPath, e);
		}
	}
	
}
