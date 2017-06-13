package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.ICarItemJDService;
import com.kysche.web.spider.service.entity.CarItemJD;

public class CarItemJDServiceImpl extends BaseServiceImpl<CarItemJD> implements ICarItemJDService{

	@Override
	protected Class<CarItemJD> getEntityClass() {
		return CarItemJD.class;
	}

}
