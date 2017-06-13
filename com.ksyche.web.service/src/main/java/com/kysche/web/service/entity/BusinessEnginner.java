package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_business_enginner")
public class BusinessEnginner {
 
 
	 /**
     * 描述: 主键     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 所属商家id     
     * 字段: bus_id  BIGINT(19)  
     */
	@Column(name="bus_id")
	private java.lang.Long busId;
	
 
	 /**
     * 描述: 工程师名字     
     * 字段: eng_name  VARCHAR(100)  
     */
	@Column(name="eng_name")
	private java.lang.String engName;
	
 
	 /**
     * 描述: 性别     
     * 字段: sex  TINYINT(3)  
     */
	@Column(name="sex")
	private Integer sex;
	
 
	 /**
     * 描述: 电话     
     * 字段: tel  VARCHAR(50)  
     */
	@Column(name="tel")
	private java.lang.String tel;
	
 
	 /**
     * 描述: 枚举类型，擅长技术     
     * 字段: skill  BIGINT(19)  
     */
	@Column(name="skill")
	private java.lang.Long skill;
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: updateTime     
     * 字段: update_time  DATETIME(19)  
     */
	@Column(name="update_time")
	private java.util.Date updateTime;
	
 
	 /**
     * 描述: 0未删除 1删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 
	 /**
     * 描述: 好评数量     
     * 字段: good_num  INT(10)  
     */
	@Column(name="good_num")
	private java.lang.Integer goodNum;
	
 

	public BusinessEnginner(){
	}
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
    
	public void setBusId(java.lang.Long busId) {
		this.busId = busId;
	}
	
	public java.lang.Long getBusId() {
		return this.busId;
	}
    
	public void setEngName(java.lang.String engName) {
		this.engName = engName;
	}
	
	public java.lang.String getEngName() {
		return this.engName;
	}
    
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getSex() {
		return this.sex;
	}
    
	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
    
	public void setSkill(java.lang.Long skill) {
		this.skill = skill;
	}
	
	public java.lang.Long getSkill() {
		return this.skill;
	}
    
	public void setCreateUser(java.lang.Long createUser) {
		this.createUser = createUser;
	}
	
	public java.lang.Long getCreateUser() {
		return this.createUser;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
    
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
    
	public void setGoodNum(java.lang.Integer goodNum) {
		this.goodNum = goodNum;
	}
	
	public java.lang.Integer getGoodNum() {
		return this.goodNum;
	}
    
	
	
 
}

