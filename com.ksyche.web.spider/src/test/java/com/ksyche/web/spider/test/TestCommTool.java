package com.ksyche.web.spider.test;

import org.junit.Before;
import org.junit.Test;

import com.ksyche.web.spider.util.CommUtil;
import com.kysche.web.spider.service.dao.IZxxkPaperService;
import com.kysche.web.spider.service.dao.impl.ZxxkPaperServiceImpl;
import com.kysche.web.spider.service.entity.ZxxkPaper;

public class TestCommTool {

    @Before
    public void init(){
      System.setProperty("dao.root.path", "E:\\opt\\wf\\spider\\");
    }
  
	@Test
	public void testComm(){
		double d = CommUtil.get("发动机机油（6.4升）");
		System.out.println(d);
	}
	
	@Test
	public void testDBIn() throws Exception{
	  IZxxkPaperService service = new ZxxkPaperServiceImpl();
	  ZxxkPaper t = new ZxxkPaper();
	  t.setName("aaa");
     service.add(t);
	}
	
}
