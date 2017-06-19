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

import com.ksyche.web.spider.zxxk.Main;
import com.ksyche.web.spider.zxxk.ParseDetail;
import com.kysche.web.spider.service.entity.ZxxkPaper;

public class ListHClearFixParse implements ParseDetail{
  private static Log log = LogFactory.getLog(ListHClearFixParse.class);

  @Override
  public List<ZxxkPaper> paserFromContent(long parentId, String content) {
    List<ZxxkPaper> list = new ArrayList<ZxxkPaper>();
    if(StringUtils.isBlank(content)){
      return list;
    }
    try{
      Document document = Jsoup.parse(content);
      Elements elements = document.select("div[class=list_h clearfix]");
      for(Element element :elements){
        ZxxkPaper paper = new ZxxkPaper();
        String id = element.attr("id");
        paper.setExamId(id);
        Elements inputName = element.select("input[name=jsSoftName]");
        if(inputName!=null&&inputName.size()>0){
          paper.setName(inputName.first().attr("value"));
        }
  
        Elements addCars = element.select("a[name=addcart]");
        if(addCars!=null&&addCars.size()>0){
          paper.setExt( addCars.attr("ext"));
        }
        
        Elements ilSelects = element.select("div.attribute > ul > li");
        if(ilSelects!=null&&ilSelects.size()>0){
          for(Element e : ilSelects){
            Element strong = e.select("strong").first();
            if(strong.text().contains("教材")){
              Elements aSelects = e.select("a");
              for(Element a : aSelects){
                paper.setType(a.attr("title"));
              }
            }
            
            if(strong.text().contains("分类")){
              Elements aSelects = e.select("a");
              for(Element a : aSelects){
                paper.setCategory(a.attr("title"));
              }
            }
            
            if(strong.text().contains("知识")){
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
      log.error("paser error ",e);
    }
    
    return list;
  }

  @Override
  public boolean isRightPasre(String content) {
    
    if(StringUtils.isBlank(content)){
      return false;
    }
    
    Document document = Jsoup.parse(content);
    Elements elements = document.select("div[class=list_h clearfix]");
    if(elements==null||elements.isEmpty()){
      return false;
    }
    
    return true;
  }


}
