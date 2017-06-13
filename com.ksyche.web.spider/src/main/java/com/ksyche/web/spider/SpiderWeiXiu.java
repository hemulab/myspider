package com.ksyche.web.spider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.kysche.web.spider.service.dao.IWeiXiuFactoryService;
import com.kysche.web.spider.service.dao.impl.WeiXiuFactoryImpl;
import com.kysche.web.spider.service.entity.WeiXiuFactory;

public class SpiderWeiXiu {

	private String cityUrl = "http://m.aibang.com/locate.d?m=city_index"; 
	
	private String weixiu = "http://www.aibang.com/%s/weixiubaoyang/p%d/";
	IWeiXiuFactoryService service = new WeiXiuFactoryImpl();
	private Log log = LogFactory.getLog(SpiderWeiXiu.class);

	public void start() throws Exception{
		log.info("start spider weixiu....");
		List<String> citys = spiderCity(cityUrl);
		if(citys==null||citys.isEmpty()){
			log.info(" citys is null spider Weixiu stop....");
		}
		for(String city : citys){
			for(int i=1;;i++){
				String url = String.format(weixiu, city,i);
				log.info("weixiu url :"+url);
				try{
					List<WeiXiuFactory> list = parseWeiXiu(url,city);
					if(list==null||list.isEmpty()){
						break;
					}
					save(list);
				}catch(Exception e){
					log.error("parseWeiXiu error ",e);
					break;
				}
				Thread.sleep(30000);
			}
		}
		log.info("over spider weixiu....");
	}
	
	public List<String> spiderCity(String url) throws IOException{
		URL newUrl = new URL(url);
		Document doc = Jsoup.parse(newUrl, 10*1000);
		 List<String> list = new ArrayList<String>();
		Elements lis = doc.select("li");
		for(Element li :lis){
			Elements as = li.select("a");
			if(as==null||as.isEmpty()){
				continue;
			}
			String href = as.first().attr("href");
			String cityStr = href.replaceAll("/", "");
			list.add(cityStr);
			System.out.println(cityStr);
		}
		return list;
	}
	
	
	public List<WeiXiuFactory> parseWeiXiu(String url,String city) throws Exception{
		URL newUrl = new URL(url);
		Document doc = Jsoup.parse(newUrl, 10*1000);
		Elements divs = doc.select("div#bizshow>div.cell");
		List<WeiXiuFactory>  list= new ArrayList<WeiXiuFactory>();
		for(Element div : divs){
			Element img = div.select("div.imgvc > a >img").first();
			String src ="";
			src = img.attr("src");
			if(src==null||"".equals(src)){
				src = img.attr("original");
			}
			String name = img.attr("title");
			Elements ps = div.select("div.part1 >p");
			String addr = ps.get(0).text().replace("地址：", "").trim();
			Elements telSpan = div.select("div.part1 >p>span.biztel");
			String tel = "";
			String typeName = "";
			if(telSpan!=null&&telSpan.size()>0){
				tel= telSpan.first().text().replaceAll("电话：", "");
				typeName = ps.get(2).select("a").first().text();
			}else{
				typeName = ps.get(1).select("a").first().text();
			}
			int type = 0;
			if(typeName.contains("4S")){
				type = 1;
			}else{
				type = 2;
			}
			double grade = 0.0;
			try{
			Element span = div.select("span.star_rate ").first();
			String attr = span.attr("title");
				grade= Double.parseDouble(attr);
			}catch(Exception e){
				log.error("parse grade error ",e);
			}
			log.info(src+" "+name +" "+addr+" "+tel+" "+type);
			WeiXiuFactory wxf = new WeiXiuFactory( name,tel, city, addr, grade, src, type);
			list.add(wxf);
		}
		
		return list;
	}
	
	public long save(List<WeiXiuFactory> list) throws Exception{
		if(list==null||list.isEmpty()){
			return 0;
		}
		return service.add(list);
	}
	
	
	public List<WeiXiuFactory> parseMWeixiu(String mUrl,String city) throws IOException{
		URL newUrl = new URL(mUrl);
		Document doc = Jsoup.parse(newUrl, 10*1000);
		Elements divs = doc.select("div.list_li");
		for(Element div : divs){
			Elements a = div.select("a.phone");
			if(a==null||a.isEmpty()){
				continue;
			}
			Element titA = div.select("div.list_li_tit>a").first();
			String href = titA.attr("href");
			String tite = titA.text();
			Element spanScore = div.select("div.list_li_lev>span").first();
			String scoreClass = spanScore.child(0).attr("class");
			char c = scoreClass.charAt(scoreClass.length()-1);
			double score = (int)c-48;
			String addr = div.select("div.list_li_addr").first().text().replaceAll("地址：", "");
			String typeName = div.select("div.list_li_label").first().text();
			int type = 0;
			if(typeName.contains("4S")){
				type = 1;
			}else{
				type = 2;
			}
			String findString = findString(div.html());
			System.out.println(findString);
		}
		return null;
	}
	
	public String findString(String s){
		System.out.println(s);
		String reg = "<div\\s+class\\s*=\\s*\"pop_box\"\\s*>([^<]*)<\\s*/div>";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);
		return m.group(0);
	}
	
}
