package com.ksyche.web.spider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.tools.util.net.http.HttpResponse;
import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.ICarItemJDService;
import com.kysche.web.spider.service.dao.ICarService;
import com.kysche.web.spider.service.dao.impl.CarItemJDServiceImpl;
import com.kysche.web.spider.service.entity.Car;
import com.kysche.web.spider.service.entity.CarItemJD;

public class SpiderItem {
	private static String itemUrl = "http://auto.jd.com/maintain/getMaintain?mileage=120000&carModelId=";
	private static HttpClient httpClient = HttpClient.getInstance(1, 512, 1024*1024*100);

	private static ICarItemJDService itemService = new CarItemJDServiceImpl();
	private static ICarService carService = ServiceFactory.createService(ICarService.class);
	
	private static Log log = LogFactory.getLog(SpiderItem.class);

	public List<CarItemJD> parse2Itme(String url,long carID,long carIDJD) throws Exception{
		if(url==null&&"".equals(url)){
			return null;
		}
		HttpResponse res = null;
		
		try{  res = httpClient.get(url, 10000);}
		catch(Exception e){
			log.error("error url:"+url ,e);
			parse2Itme(url, carID, carIDJD);
		}
		if(res == null){
			parse2Itme(url, carID, carIDJD);
		}
		
		if(res == null){
			return null ;
		}
		String content = res.getContent();
		log.info(content);
		if(!content.startsWith("{")){
			content = "{"+content+"}";
//			log.info(" aaaaaa+"+url);
//			parse2Itme(url, carID, carIDJD);
		}
		JSONObject json = JSONObject.fromObject(content);
		Object resCode = json.get("code");
		if(resCode== null||"nomodel".equals(((String)resCode))){
			Thread.sleep(1000*4);
			return null;
		}
		
		JSONObject cjson = json.getJSONObject("data");
		if(cjson.isNullObject()||cjson.isEmpty()){
			return null;
		}
		JSONArray jsonArray = cjson.getJSONArray("catItems");
		List<CarItemJD> list = new ArrayList<CarItemJD>();
		for(int i=0;!jsonArray.isEmpty()&&i<jsonArray.size();i++){
			CarItemJD item = parse2Item(jsonArray.getJSONObject(i),carID,carIDJD);
			if(item!=null){
				itemService.add(item);
				list.add(item);
			}
		}
		Thread.sleep(1000*4);
		return list;
		
	}
	
	
	public CarItemJD parse2Item(JSONObject json,long carID,long carIDJD){
		if(json.isNullObject()||json.isEmpty()){
			return null;
		}
		
		CarItemJD item = new CarItemJD();
		item.setCarID(carID);
		item.setAccyCatID(json.getLong("accyCatId"));
		item.setItemID(json.getLong("itemId"));
		item.setName(json.getString("itemName"));
		item.setPictureUrl(json.getString("pictureUrl"));
		item.setCarIDJD(carIDJD);
		item.setDt(new Date());
		return item;
	}
	
public static void main(String[] args)  {
//		SpiderCar spiderCar = new SpiderCar();
//		spiderCar.spider();
		log.info("---------------");
		try{
		SpiderItem spiderItem = new SpiderItem();
		List<Car> cars = spiderItem.getByLevel(3);
		if(cars==null||cars.isEmpty()){
			System.exit(0);
		}
		for(int i=0;i<cars.size();i++){
		    
			Car c = cars.get(i);
			String itemUrl2 = itemUrl+c.getCarIDJD();
			spiderItem.parse2Itme(itemUrl2 , c.getCarID(), c.getCarIDJD());
			
		}
		System.exit(0);
		}catch(Throwable e){
			log.error(" spider error ",e);
		}
	}
	
	public List<Car> getByLevel(int level) throws Exception{
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("level", 3);
		return carService.get(condition , " id ASC");
	}
}
