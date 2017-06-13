package com.ksyche.web.spider.test;

import org.junit.Test;

import com.ksyche.web.spider.util.CommUtil;

public class TestCommTool {

	@Test
	public void testComm(){
		double d = CommUtil.get("发动机机油（6.4升）");
		System.out.println(d);
	}
	
}
