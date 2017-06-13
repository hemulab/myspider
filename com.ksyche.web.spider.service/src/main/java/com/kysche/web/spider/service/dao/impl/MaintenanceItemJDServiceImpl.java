package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.IMaintenanceItemJDService;
import com.kysche.web.spider.service.entity.MaintenanceItemJD;

public class MaintenanceItemJDServiceImpl extends BaseServiceImpl<MaintenanceItemJD> implements IMaintenanceItemJDService{

	@Override
	protected Class<MaintenanceItemJD> getEntityClass() {
		return MaintenanceItemJD.class;
	}
	

}
