package com.kysche.web.service;

import com.kysche.web.service.dao.ICarItemJDService;
import com.kysche.web.service.dao.ICarService;
import com.kysche.web.service.dao.impl.CarItemJDServiceImpl;
import com.kysche.web.service.dao.impl.CarServiceImpl;


public class ServiceFactory {

	private static ICarService carService = new CarServiceImpl();
	private static ICarItemJDService carItemJDService = new CarItemJDServiceImpl();
	
	@SuppressWarnings("unchecked")
	public static <T> T createService(Class<T> cls) {
		if(cls ==ICarService.class){
			return (T) carService;
		}
		if(cls ==ICarItemJDService.class){
			return (T) carItemJDService;
		}
		return null;
	}
}
