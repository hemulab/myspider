package com.kysche.web.spider.service.entity;

import com.bj58.wf.util.StringUtil;
import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="tbl_zxxk_paper")
public class ZxxkPaper {

  @Id
  private long id;
  
  private String examId;
  
  private String name;
  
  private String type1;
  
  private String type2;
  
  private String type3;
  
  private String type4;
  
  private String type5;
  
  private String category1;
  
  private String category2;
  
  private String category3;
  
  private String category4;
  
  private String category5;
  
  private String knowledge1;
  
  private String knowledge2;
  
  private String knowledge3;
  
  private String knowledge4;
  
  private String time;
  
  private int size;
  
  private String author;
  
  private String detailUrl;
  
  private String parentUrl;
  
  private String downloadCount;
  
  private String loaclPath;
  
  private String downloadUrl;

  private String ext ;
  
  public void setType(String type){
    if(StringUtil.isBlank(type1)){
      type1 = type;
    }else if(StringUtil.isBlank(type2)){
      type2 = type;
    }else if(StringUtil.isBlank(type3)){
      type3 = type;
    }else if(StringUtil.isBlank(type4)){
      type4 = type;
    }else if(StringUtil.isBlank(type5)){
      type5 = type;
    }
  }

  public void setCategory(String category){
    if(StringUtil.isBlank(category1)){
      category1 = category;
    }else if(StringUtil.isBlank(category2)){
      category2 = category;
    }else if(StringUtil.isBlank(category3)){
      category3 = category;
    }else if(StringUtil.isBlank(category4)){
      category4 = category;
    }else if(StringUtil.isBlank(category5)){
      category5 = category;
    }
  }
  
  public void setKnowledge(String knowledge){
    if(StringUtil.isBlank(knowledge1)){
      knowledge1 = knowledge;
    }else if(StringUtil.isBlank(knowledge2)){
      knowledge2 = knowledge;
    }else if(StringUtil.isBlank(knowledge3)){
      knowledge3 = knowledge;
    }else if(StringUtil.isBlank(knowledge4)){
      knowledge4 = knowledge;
    }
  }
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  

  public String getType1() {
    return type1;
  }

  public void setType1(String type1) {
    this.type1 = type1;
  }

  public String getType2() {
    return type2;
  }

  public void setType2(String type2) {
    this.type2 = type2;
  }

  public String getType3() {
    return type3;
  }

  public void setType3(String type3) {
    this.type3 = type3;
  }

  public String getType4() {
    return type4;
  }

  public void setType4(String type4) {
    this.type4 = type4;
  }

  public String getType5() {
    return type5;
  }

  public void setType5(String type5) {
    this.type5 = type5;
  }

  public String getCategory1() {
    return category1;
  }

  public void setCategory1(String category1) {
    this.category1 = category1;
  }

  public String getCategory2() {
    return category2;
  }

  public void setCategory2(String category2) {
    this.category2 = category2;
  }

  public String getCategory3() {
    return category3;
  }

  public void setCategory3(String category3) {
    this.category3 = category3;
  }

  public String getCategory4() {
    return category4;
  }

  public void setCategory4(String category4) {
    this.category4 = category4;
  }

  public String getCategory5() {
    return category5;
  }

  public void setCategory5(String category5) {
    this.category5 = category5;
  }

  public String getKnowledge1() {
    return knowledge1;
  }

  public void setKnowledge1(String knowledge1) {
    this.knowledge1 = knowledge1;
  }

  public String getKnowledge2() {
    return knowledge2;
  }

  public void setKnowledge2(String knowledge2) {
    this.knowledge2 = knowledge2;
  }

  public String getKnowledge3() {
    return knowledge3;
  }

  public void setKnowledge3(String knowledge3) {
    this.knowledge3 = knowledge3;
  }

  public String getKnowledge4() {
    return knowledge4;
  }

  public void setKnowledge4(String knowledge4) {
    this.knowledge4 = knowledge4;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDetailUrl() {
    return detailUrl;
  }

  public void setDetailUrl(String detailUrl) {
    this.detailUrl = detailUrl;
  }

  public String getDownloadCount() {
    return downloadCount;
  }

  public void setDownloadCount(String downloadCount) {
    this.downloadCount = downloadCount;
  }

  public String getLoaclPath() {
    return loaclPath;
  }

  public void setLoaclPath(String loaclPath) {
    this.loaclPath = loaclPath;
  }

  public String getParentUrl() {
    return parentUrl;
  }

  public void setParentUrl(String parentUrl) {
    this.parentUrl = parentUrl;
  }

  public String getExamId() {
    return examId;
  }

  public void setExamId(String examId) {
    this.examId = examId;
  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public String getExt(){
    return this.ext;
  }

  public void setExt(String ext){
    this.ext = ext;
  }
}
