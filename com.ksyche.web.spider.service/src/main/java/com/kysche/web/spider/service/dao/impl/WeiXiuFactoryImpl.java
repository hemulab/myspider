package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.IWeiXiuFactoryService;
import com.kysche.web.spider.service.entity.WeiXiuFactory;

public class WeiXiuFactoryImpl extends BaseServiceImpl<WeiXiuFactory> implements IWeiXiuFactoryService{

	@Override
	protected Class<WeiXiuFactory> getEntityClass() {
		return WeiXiuFactory.class;
	}

}
