package com.ksyche.web.spider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.tools.util.net.http.HttpResponse;
import com.ksyche.web.spider.util.CommUtil;
import com.kysche.web.spider.service.dao.IWeiXiuFactoryService;
import com.kysche.web.spider.service.dao.impl.WeiXiuFactoryImpl;
import com.kysche.web.spider.service.entity.WeiXiuFactory;

public class SpiderDianping {
	
	private String url = "http://m.dianping.com/search/keyword/2/0_%E6%B1%BD%E4%BF%AE%E5%BA%97?reqType=ajax&page="; //汽修店
	//汽车维修
//	private String url = "http://m.dianping.com/search/keyword/2/0_%E6%B1%BD%E8%BD%A6%E7%BB%B4%E4%BF%AE?reqType=ajax&page=";  
	//洗车
//	private String url = "http://m.dianping.com/search/keyword/2/0_%E6%B4%97%E8%BD%A6?reqType=ajax&page=";
	private static Log log = LogFactory.getLog(SpiderMaintenance.class);
	IWeiXiuFactoryService service = new WeiXiuFactoryImpl();
	
	private int breakCount =0;

	public void start() throws Exception{
		for(int i=1;;i++){
			String newUrl = url+i;
			log.info("url : "+newUrl);
			List<String> detailURL = getDetailURL(newUrl);
			if(detailURL==null||detailURL.isEmpty()){
				breakCount++;
			}
			if(breakCount>10){
				break;
			}
			for(String detail : detailURL){
				log.info("detail url : "+detail);
				try{
				WeiXiuFactory wx = parse(detail);
				log.info(wx);
				service.add(wx);
				}catch(Throwable e){
					log.error("parse wx error ",e);
				}
				Thread.sleep(2000);
			}
		}
	}
	
	public List<String> getDetailURL(String url) throws Exception{
		HttpResponse res = HttpClient.getInstance().get(url);
		String statusLine = res.getStatusLine();
		if(statusLine.contains("40")){
			log.info("status:"+statusLine);
			Thread.sleep(1000);
			return null;
			
		}
	//s	log.info(res.getContent());
		Document doc = Jsoup.parse(res.getContent());
		Elements lis = doc.select("li");
		List<String> childrenUrls = new ArrayList<String>(16);
		if(lis!=null&&!lis.isEmpty()){
			for(Element li :lis){
				Element a = li.select("a").first();
				String href = a.attr("href");
				log.info("detail url :"+href);
				childrenUrls.add("http://m.dianping.com"+href);
			}
			breakCount =0;
		}
		return childrenUrls;
	}
	
	public WeiXiuFactory parse(String detailUrl) throws IOException{
		URL inUrl =new URL(detailUrl);
		Document doc = Jsoup.parse(inUrl, 10000);
		WeiXiuFactory wx = new WeiXiuFactory();
		Elements divs = doc.select("div.shop-info");
		if(divs!=null&&!divs.isEmpty()){
			Element div = divs.first();
			Elements imgs = div.select("img");
			if(imgs!=null&&!imgs.isEmpty()){
				String img = imgs.first().attr("src");
				wx.setImage(img);
			}
		Element span = div.select("span.shop-name").first();
		String attr = div.select("span.star").attr("class");
		double grade = CommUtil.get(attr);
		wx.setGrade(grade);
		wx.setName(span.text());
		}
		Element div = doc.select("div.info-address").first();
		Elements as = div.select("a.item");
		String addr = as.get(0).text();
		wx.setAddr(addr);
		try{
			String tel = as.get(1).text();
			wx.setTel(tel);
		}catch(Exception e){
			log.error(" tel error",e);
		}
		wx.setUrl(detailUrl);
		wx.setDt(new Date());
		wx.setType(2);//洗车店
		return wx;
	}
	
	
}
