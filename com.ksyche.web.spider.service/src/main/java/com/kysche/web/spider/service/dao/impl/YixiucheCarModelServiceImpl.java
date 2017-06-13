package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.IYixiucheCarModelService;
import com.kysche.web.spider.service.entity.YixiucheCarModel;

public class YixiucheCarModelServiceImpl extends BaseServiceImpl<YixiucheCarModel> implements IYixiucheCarModelService{

	@Override
	protected Class<YixiucheCarModel> getEntityClass() {
		return YixiucheCarModel.class;
	}

}
