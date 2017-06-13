package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_city")
public class City {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: cityName     
     * 字段: city_name  VARCHAR(255)  
     */
	@Column(name="city_name")
	private java.lang.String cityName;
	
 
	 /**
     * 描述: cityCode     
     * 字段: city_code  VARCHAR(255)  
     */
	@Column(name="city_code")
	private java.lang.String cityCode;
	
 
	 /**
     * 描述: 删除标示     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: parentId     
     * 字段: parent_id  BIGINT(19)  
     */
	@Column(name="parent_id")
	private java.lang.Long parentId;
	
 

	public City(){
	}

	public City(
		java.lang.Long id
	){
		this.id = id;
	}

	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
    
	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}
	
	public java.lang.String getCityName() {
		return this.cityName;
	}
    
	public void setCityCode(java.lang.String cityCode) {
		this.cityCode = cityCode;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
	}
    
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}
	
	public java.lang.Long getParentId() {
		return this.parentId;
	}
    
	
	
 
}

