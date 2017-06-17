package com.ksyche.web.spider.zxxk;

import java.util.List;

import com.kysche.web.spider.service.entity.ZxxkPaper;

public interface ParseDetail {

  List<ZxxkPaper> paserFromContent(long parentId,String content);
  
  
  boolean isRightPasre(String content);
}
