package com.ksyche.web.spider.bll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.ICarItemJDService;
import com.kysche.web.spider.service.dao.ICarService;
import com.kysche.web.spider.service.dao.impl.CarItemJDServiceImpl;
import com.kysche.web.spider.service.entity.Car;

public class CarBLL {
	private static ICarItemJDService itemService = new CarItemJDServiceImpl();
	private static ICarService carService = ServiceFactory.createService(ICarService.class);
	
	public List<Car> get(int page,int size) throws Exception{
		
		Map<String, Object> condition = new HashMap<String, Object>();
		return carService.get(condition  , page, size, "id desc");
	}
	
	public List<Car> getByLevel(int level) throws Exception{
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("level", 3);
		return carService.get(condition , " id ASC");
	}
	
}
