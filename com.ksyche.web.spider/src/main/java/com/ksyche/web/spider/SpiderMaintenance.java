package com.ksyche.web.spider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ksyche.tools.util.comm.CommTool;
import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.tools.util.net.http.HttpResponse;
import com.ksyche.web.spider.bll.CarBLL;
import com.ksyche.web.spider.bll.MaintenanceBLL;
import com.ksyche.web.spider.util.CommUtil;
import com.kysche.web.spider.service.entity.Car;
import com.kysche.web.spider.service.entity.CarItemJD;
import com.kysche.web.spider.service.entity.ChangeMaintenaceJD;
import com.kysche.web.spider.service.entity.MaintenanceItemJD;

/**
 * 爬取保修项目
 * @author mydog741
 *
 */
public class SpiderMaintenance {
	private static String itemUrl = "http://auto.jd.com/maintain/getMaintain?mileage=120000&carModelId=";
	private static HttpClient httpClient = HttpClient.getInstance(1, 512, 1024*1024*100);
	
	private static Log log = LogFactory.getLog(SpiderMaintenance.class);

	private static CarBLL carBLL = new CarBLL();
	private MaintenanceBLL maintenanceBLL = new MaintenanceBLL();
	
	public JSONObject getJSON(String url,long carIDJD) throws Exception{
		if(url==null&&"".equals(url)){
			return null;
		}
		HttpResponse res = null;
		
		try{  
			res = httpClient.get(url, 10000);
			Thread.sleep(1000);
		}
		catch(Exception e){
			log.error("error url:"+url ,e);
			getJSON(url, carIDJD);
		}
		if(res == null){
			getJSON(url,carIDJD);
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
		log.info("content "+content);
		return  JSONObject.fromObject(content);
		
		
	}
	
	
	public JSONArray parseJSON(JSONObject json){
		if(json==null||json.isEmpty()||json.isNullObject()){
			return null;
		}
		String code = json.getString("code");
		if(!"success".equals(code)){
			return null;
		}
		JSONObject json1 = json.getJSONObject("data");
		JSONObject json2 = json1.getJSONObject("maintainInfo");
		return json2.getJSONArray("columnCells");
		
		
	}
	
	public JSONArray getName(JSONObject json){
		if(json==null||json.isEmpty()){
			return null;
		}
		return json.getJSONArray("cells");
	}
	
	/** {
				"cells": ["发动机机油（6升）",
				"机油滤清器（1个）",
				"空气滤清器（1个）",
				"空调滤清器（1个）",
				"燃油滤清器（1个）",
				"火花塞（4个）"],
				"columnName": "保养项目（单位）／里程",
				"selected": null,
				"num": 0
			}
	 * @param jsonArr
	 * @return
	 * @throws Exception 
	 */
	public Map<Integer,Long> getFromJsonArray(JSONObject json,long carid) throws Exception{
		
		if(json==null||json.isEmpty()){
			return null;
		}
		Map<Integer,Long> map = new HashMap<Integer,Long>();
		JSONArray jsonArr = getName(json);
		for(int i=0;i<jsonArr .size();i++){
			String firstName = jsonArr.getString(i);
			String name = firstName.split("（")[0];
			MaintenanceItemJD itemJD = maintenanceBLL.get(name);
			if(itemJD==null){
				itemJD = maintenanceBLL.add(name);
			}
			double d =-1;
			try {
				d = CommUtil.get(firstName);
			} catch (Exception e) {
				log.error("find number error ",e);;
			}
			long carMaintenaceJDID = maintenanceBLL.addCarMaintenaceItem(carid, itemJD.getId(), d);
			map.put(i, carMaintenaceJDID);
		}
		return map;
	}
	
	
	
	/**
	 * {
				"cells": ["true",
				"true",
				"false",
				"false",
				"false",
				"false"],
				"columnName": "5000",
				"selected": null,
				"num": 2
			},
	 * @param json
	 * @param carid
	 * @param map
	 * @throws Exception 
	 */
	public void parseChange(JSONObject json,long carid,Map<Integer,Long> map) throws Exception{
		if(json==null||carid<=0 || map==null||map.isEmpty()){
			return ;
		}
		JSONArray jsonArray = json.getJSONArray("cells");
		if(jsonArray==null||jsonArray.isEmpty()){
			return ;
		}
		long distanceName = json.getLong("columnName");
		for(int i=0;i<jsonArray.size();i++){
			boolean bool = jsonArray.getBoolean(i);
			if(bool){
				long id = map.get(i);
				maintenanceBLL.addChangeMaintenace(id, distanceName);
			}
		}
		
	}
	
	public  void start(String[] args)  {
		log.info("star spider maintenace ---------------");
		try{
		List<Car> cars = carBLL.getByLevel(3);
		if(cars==null||cars.isEmpty()){
			System.exit(0);
		}
		SpiderMaintenance spider = new SpiderMaintenance();
		for(int i=0;i<cars.size();i++){
			Car c = cars.get(i);
			String itemUrl2 = itemUrl+c.getCarIDJD();
			JSONObject json = spider.getJSON(itemUrl2,c.getCarIDJD());
			JSONArray jarr = spider.parseJSON(json);
			log.info("jarr:" +jarr);
			if(jarr==null||jarr.size()<2){
				continue;
			}
			Map<Integer, Long> map = spider.getFromJsonArray(jarr.getJSONObject(0), c.getCarID());
			for(int j=1;j<jarr.size();j++){
				spider.parseChange(jarr.getJSONObject(j), c.getCarID(), map);
			}
			Thread.sleep(1*1000);
		}
		System.exit(0);
		}catch(Throwable e){
			log.error(" spider error ",e);
			e.printStackTrace();
		}
		log.info(" end spider ---------");
	}
	
}
