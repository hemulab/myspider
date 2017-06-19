package com.kysche.web.spider.service.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kysche.web.spider.service.dao.IZxxkPaperService;
import com.kysche.web.spider.service.entity.ZxxkPaper;

public class ZxxkPaperServiceImpl extends BaseServiceImpl<ZxxkPaper> implements IZxxkPaperService{

  @Override
  protected Class<ZxxkPaper> getEntityClass() {
    return ZxxkPaper.class;
  }

  @Override
  public long saveOrUpadate(ZxxkPaper paper) throws Exception {
    Map<String, Object> condition = new HashMap<String, Object>();
    condition.put("examId", paper.getExamId());
    List<ZxxkPaper> list = get(condition , "id desc");
    long id = 0;
    if(list == null || list.isEmpty()){
     id = add(paper);
     paper.setId(id);
    }else{
      ZxxkPaper zxxkPaper = list.get(0);
      paper.setId(zxxkPaper.getId());
      id= zxxkPaper.getId();
      update(paper);
    }
    return id;
  }

}
