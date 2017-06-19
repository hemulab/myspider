package com.ksyche.web.spider.zxxk.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ksyche.web.spider.zxxk.ParseDetail;
import com.kysche.web.spider.service.entity.ZxxkPaper;

public class ClearFixItemParse implements ParseDetail{
  private static Log log = LogFactory.getLog(ClearFixItemParse.class);

  @Override
  public List<ZxxkPaper> paserFromContent(long parentId, String content) {
    List<ZxxkPaper> list = new ArrayList<ZxxkPaper>();
    try{
      Document document = Jsoup.parse(content);
      Elements elements = document.select("div[class=clearfix list-item]");
      for(Element element :elements){
        ZxxkPaper paper = new ZxxkPaper();
        String id = element.attr("id");
        paper.setExamId(id);
        Elements aSelect = element.select("div.list-mid > a");
        if(aSelect!=null&&aSelect.size()>0){
          paper.setName(aSelect.first().text());
        }
  
        Elements addCars = element.select("a[name=addcart]");
        if(addCars!=null&&addCars.size()>0){
          paper.setExt( addCars.attr("ext"));
        }
        
        Elements ilSelects = element.select("ul.attribute > li");
        if(ilSelects!=null&&ilSelects.size()>0){
          for(Element e : ilSelects){
            if(e.attr("class").contains("jiaocai")){
              Elements aSelects = e.select("a");
              for(Element a : aSelects){
                paper.setType(a.attr("title"));
              }
            }
            
            if(e.attr("class").contains("feilei")){
              Elements aSelects = e.select("a");
              for(Element a : aSelects){
                paper.setCategory(a.attr("title"));
              }
            }
            
            if(e.attr("class").contains("zhishi")){
              Elements aSelects = e.select("a");
              for(Element a : aSelects){
                paper.setKnowledge(a.attr("title"));
              }
            }
          }
        }
        list.add(paper);
      }
    }catch(Exception e){
      log.error("parse error ",e);
    }
    return list;
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
