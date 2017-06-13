package com.ksyche.web.spider.bll;

import java.util.List;

import com.ksyche.tools.dao.Query;
import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.ICityService;
import com.kysche.web.spider.service.entity.City;

public class CityBLL {

	ICityService cityService = ServiceFactory.createService(ICityService.class);
	
	public List<City> getCitys() throws Exception{
		Query query = new Query();
		query.column("id").lessOrEqual(13).or().leftBracket().column("id").greaterOrEqual(100).and().column("id").lessOrEqual("100000").rightBracket();
		return cityService.get(query, 1, 10000, "");
	}
}
