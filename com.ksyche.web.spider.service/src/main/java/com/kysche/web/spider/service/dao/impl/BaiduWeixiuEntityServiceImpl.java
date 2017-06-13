package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.entity.BaiduWeixiuEntity;

public class BaiduWeixiuEntityServiceImpl extends BaseServiceImpl<BaiduWeixiuEntity> implements IBaiduWeixiuEntityService{

	@Override
	protected Class<BaiduWeixiuEntity> getEntityClass() {
		return BaiduWeixiuEntity.class;
	}

}
