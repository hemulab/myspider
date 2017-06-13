package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.IChangeMaintenaceJDService;
import com.kysche.web.spider.service.entity.ChangeMaintenaceJD;

public class ChangeMaintenaceJDServiceImpl extends BaseServiceImpl<ChangeMaintenaceJD> implements IChangeMaintenaceJDService{

	@Override
	protected Class<ChangeMaintenaceJD> getEntityClass() {
		return ChangeMaintenaceJD.class;
	}	

}
