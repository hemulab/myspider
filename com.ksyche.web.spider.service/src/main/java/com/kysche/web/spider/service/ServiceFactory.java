package com.kysche.web.spider.service;

import com.kysche.web.spider.service.dao.ICarItemJDService;
import com.kysche.web.spider.service.dao.ICarMaintenaceJDService;
import com.kysche.web.spider.service.dao.ICarService;
import com.kysche.web.spider.service.dao.IChangeMaintenaceJDService;
import com.kysche.web.spider.service.dao.ICityService;
import com.kysche.web.spider.service.dao.IMaintenanceItemJDService;
import com.kysche.web.spider.service.dao.IWeiXiuFactoryService;
import com.kysche.web.spider.service.dao.IYixiucheCarModelService;
import com.kysche.web.spider.service.dao.IYixiucheMaintenaceService;
import com.kysche.web.spider.service.dao.impl.BaiduWeixiuEntityServiceImpl;
import com.kysche.web.spider.service.dao.impl.CarItemJDServiceImpl;
import com.kysche.web.spider.service.dao.impl.CarMaintenaceJDServiceImpl;
import com.kysche.web.spider.service.dao.impl.CarServiceImpl;
import com.kysche.web.spider.service.dao.impl.ChangeMaintenaceJDServiceImpl;
import com.kysche.web.spider.service.dao.impl.CityServiceImpl;
import com.kysche.web.spider.service.dao.impl.IBaiduWeixiuEntityService;
import com.kysche.web.spider.service.dao.impl.MaintenanceItemJDServiceImpl;
import com.kysche.web.spider.service.dao.impl.WeiXiuFactoryImpl;
import com.kysche.web.spider.service.dao.impl.YixiucheCarModelServiceImpl;
import com.kysche.web.spider.service.dao.impl.YixiucheMaintenaceCarServiceImpl;


public class ServiceFactory {

	private static ICarService carService = new CarServiceImpl();
	private static ICarItemJDService carItemJDService = new CarItemJDServiceImpl();
	private static IWeiXiuFactoryService weixiuService = new WeiXiuFactoryImpl();
	private static ICarMaintenaceJDService carMaintenaceJDService = new CarMaintenaceJDServiceImpl();
	private static IChangeMaintenaceJDService changeMaintenaceJDservice = new ChangeMaintenaceJDServiceImpl();
	private static IMaintenanceItemJDService maintenanceItemService = new MaintenanceItemJDServiceImpl();
	private static IYixiucheMaintenaceService yixiucheMaintenaceService = new YixiucheMaintenaceCarServiceImpl();
	private static IYixiucheCarModelService yixiucheCarModelService = new YixiucheCarModelServiceImpl();
	private static ICityService cityService = new CityServiceImpl();
	private static IBaiduWeixiuEntityService baiduService = new BaiduWeixiuEntityServiceImpl();
	@SuppressWarnings("unchecked")
	public static <T> T createService(Class<T> cls) {
		if(cls ==ICarService.class){
			return (T) carService;
		}
		if(cls ==ICarItemJDService.class){
			return (T) carItemJDService;
		}
		if(cls == IWeiXiuFactoryService.class){
			return (T)weixiuService;
		}
		if(cls == IChangeMaintenaceJDService.class){
			return (T)changeMaintenaceJDservice;
		}
		if(cls == ICarMaintenaceJDService.class){
			return (T)carMaintenaceJDService;
		}
		if(cls == IMaintenanceItemJDService.class){
			return (T)maintenanceItemService;
		}
		if(cls == IYixiucheMaintenaceService.class){
			return (T)yixiucheMaintenaceService;
		}
		if(cls == IYixiucheCarModelService.class){
			return (T)yixiucheCarModelService;
		}
		if(cls==ICityService.class){
			return (T)cityService;
		}
		if(cls==IBaiduWeixiuEntityService.class){
			return (T)baiduService;
		}
		return null;
	}
}
