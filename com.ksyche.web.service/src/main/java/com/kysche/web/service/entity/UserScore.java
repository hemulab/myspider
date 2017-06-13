package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user_score")
public class UserScore {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: userId     
     * 字段: user_id  BIGINT(19)  
     */
	@Column(name="user_id")
	private java.lang.Long userId;
	
 
	 /**
     * 描述: 来源方式：分享，预约成功,增加还是减少     
     * 字段: source_type  BIGINT(19)  
     */
	@Column(name="source_type")
	private java.lang.Long sourceType;
	
 
	 /**
     * 描述: 获得时间     
     * 字段: time  DATETIME(19)  
     */
	@Column(name="time")
	private java.util.Date time;
	
 
	 /**
     * 描述: 分数     
     * 字段: score  INT(10)  
     */
	@Column(name="score")
	private java.lang.Integer score;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 失效时间     
     * 字段: over_time  DATETIME(19)  
     */
	@Column(name="over_time")
	private java.util.Date overTime;
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 
	 /**
     * 描述: 0未删除，1删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 
	 /**
     * 描述: updateTime     
     * 字段: update_time  DATETIME(19)  
     */
	@Column(name="update_time")
	private java.util.Date updateTime;
	
 

	public UserScore(){
	}

	public UserScore(
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
    
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
    
	public void setSourceType(java.lang.Long sourceType) {
		this.sourceType = sourceType;
	}
	
	public java.lang.Long getSourceType() {
		return this.sourceType;
	}
    
	public void setTime(java.util.Date time) {
		this.time = time;
	}
	
	public java.util.Date getTime() {
		return this.time;
	}
    
	public void setScore(java.lang.Integer score) {
		this.score = score;
	}
	
	public java.lang.Integer getScore() {
		return this.score;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setOverTime(java.util.Date overTime) {
		this.overTime = overTime;
	}
	
	public java.util.Date getOverTime() {
		return this.overTime;
	}
    
	public void setCreateUser(java.lang.Long createUser) {
		this.createUser = createUser;
	}
	
	public java.lang.Long getCreateUser() {
		return this.createUser;
	}
    
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
    
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
    
	
	
 
}

