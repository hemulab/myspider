package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.IYixiucheMaintenaceService;
import com.kysche.web.spider.service.entity.YixiucheMaintenace;

public class YixiucheMaintenaceCarServiceImpl extends BaseServiceImpl<YixiucheMaintenace> implements IYixiucheMaintenaceService{

	@Override
	protected Class<YixiucheMaintenace> getEntityClass() {
		return YixiucheMaintenace.class;
	}

}
