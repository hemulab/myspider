package com.kysche.web.spider.service.dao.impl;

import com.kysche.web.spider.service.dao.IZxxkPaperService;
import com.kysche.web.spider.service.entity.ZxxkPaper;

public class ZxxkPaperServiceImpl extends BaseServiceImpl<ZxxkPaper> implements IZxxkPaperService{

  @Override
  protected Class<ZxxkPaper> getEntityClass() {
    return ZxxkPaper.class;
  }

}
