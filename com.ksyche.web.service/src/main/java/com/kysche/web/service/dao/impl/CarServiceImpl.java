package com.kysche.web.service.dao.impl;

import com.kysche.web.service.dao.ICarService;
import com.kysche.web.service.entity.Car;

public class CarServiceImpl extends BaseServiceImpl<Car> implements ICarService{

	@Override
	protected Class<Car> getEntityClass() {
		return Car.class;
	}

}
