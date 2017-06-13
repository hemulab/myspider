package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.ICarMaintenaceJDService;
import com.kysche.web.spider.service.entity.CarMaintenaceJD;

public class CarMaintenaceJDServiceImpl extends BaseServiceImpl<CarMaintenaceJD> implements ICarMaintenaceJDService{

	@Override
	protected Class<CarMaintenaceJD> getEntityClass() {
		return CarMaintenaceJD.class;
	}

}
