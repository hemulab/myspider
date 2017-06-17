package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.entity.ZxxkIndexEntity;

public class IZxxkIndexServiceImpl extends BaseServiceImpl<ZxxkIndexEntity> implements IZxxkIndexService {

  @Override
  protected Class<ZxxkIndexEntity> getEntityClass() {
    return ZxxkIndexEntity.class;
  }

}
