package com.ksyche.web.spider.zxxk.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ksyche.web.spider.zxxk.ParseDetail;
import com.kysche.web.spider.service.entity.ZxxkPaper;

public class ClearFixItemParse implements ParseDetail{

  @Override
  public List<ZxxkPaper> paserFromContent(long parentId, String content) {
    Document document = Jsoup.parse(content);
    Elements elements = document.select("div[class=clearfix list-item]");

    return null;
  }

  @Override
  public boolean isRightPasre(String content) {
    if(StringUtils.isBlank(content)){
      return false;
    }
    
    Document document = Jsoup.parse(content);
    Elements elements = document.select("div[class=clearfix list-item]");
    if(elements==null||elements.isEmpty()){
      return false;
    }
    
    return true;
  }

}
