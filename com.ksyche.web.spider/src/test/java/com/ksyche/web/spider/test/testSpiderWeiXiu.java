package com.ksyche.web.spider.test;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ksyche.web.spider.SpiderDianping;
import com.ksyche.web.spider.SpiderItem;
import com.ksyche.web.spider.SpiderMaintenance;
import com.ksyche.web.spider.SpiderWeiXiu;

public class testSpiderWeiXiu {
	private String city = "http://m.aibang.com/locate.d?m=city_index"; 

	@BeforeClass
	public static void befor(){
		System.setProperty("dao.root.path", "D:\\mywork\\ksyweb\\conf\\");
	}
	@Test
	public void testSpidCity() throws IOException{
		new SpiderWeiXiu().spiderCity(city);
	}
	
	@Test
	public void testCarIDTem(){
		SpiderItem.main(null);
	}
	
	@Test
	public void testSpiderdian() throws Exception{
		new SpiderDianping().start();
	}
	
	@Test
	public void testSPider() throws Exception{
		new SpiderWeiXiu().parseMWeixiu("http://m.aibang.com/beijing/weixiubaoyang/p1/" ,"beijing");
	}
	
	@Test
	public void char2int(){
		char c = '5';
		int a = (int)c-48;
		System.out.println(a);
	}
	
}
