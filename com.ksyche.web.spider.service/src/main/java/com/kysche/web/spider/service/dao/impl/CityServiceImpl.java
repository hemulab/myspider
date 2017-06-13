package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.ICityService;
import com.kysche.web.spider.service.entity.City;

public class CityServiceImpl extends BaseServiceImpl<City> implements ICityService{

	@Override
	protected Class<City> getEntityClass() {
		// TODO Auto-generated method stub
		return City.class;
	}

}
