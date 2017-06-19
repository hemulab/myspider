package com.kysche.web.spider.service.dao;

import com.kysche.web.spider.service.entity.ZxxkPaper;

public interface IZxxkPaperService extends BaseService<ZxxkPaper>{

  long saveOrUpadate(ZxxkPaper paper) throws Exception ;
  
}
