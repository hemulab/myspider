package com.kysche.web.service.dao.impl;

import com.kysche.web.service.dao.ICarItemJDService;
import com.kysche.web.service.entity.CarItemJD;

public class CarItemJDServiceImpl extends BaseServiceImpl<CarItemJD> implements ICarItemJDService{

	@Override
	protected Class<CarItemJD> getEntityClass() {
		return CarItemJD.class;
	}

}
