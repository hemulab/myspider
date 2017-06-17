package com.kysche.web.spider.service.entity;

import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="tbl_zxxk_index")
public class ZxxkIndexEntity implements Cloneable{

  @Id
  private long id;
  
  private String subject;
  
  private String category;
  
  private String issuse;
  
  private String url;
  
  @Override  
  public Object clone() {  
    ZxxkIndexEntity entity = null;  
      try{  
        entity = (ZxxkIndexEntity)super.clone();  
      }catch(CloneNotSupportedException e) {  
          e.printStackTrace();  
      }  
      return entity;  
  } 

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getIssuse() {
    return issuse;
  }

  public void setIssuse(String issuse) {
    this.issuse = issuse;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
  
  
  
}
