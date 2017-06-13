package com.ksyche.web.spider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {
	static{
		System.setProperty("dao.root.path", "D:\\mywork\\ksyweb\\conf\\");
	}
	private static Log log = LogFactory.getLog(Main.class);
	public static void main(String[] args) {
//		YixiucheSpider ys = new YixiucheSpider();
		try {
//			ys.spider();
			new BaiduMapSpider().spider();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		System.exit(0);
	}
}
