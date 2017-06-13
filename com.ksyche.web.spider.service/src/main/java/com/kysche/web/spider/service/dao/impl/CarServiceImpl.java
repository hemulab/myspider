package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.ICarService;
import com.kysche.web.spider.service.entity.Car;

public class CarServiceImpl extends BaseServiceImpl<Car> implements ICarService{

	@Override
	protected Class<Car> getEntityClass() {
		return Car.class;
	}

}
