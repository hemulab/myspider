package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user_open_token")
public class UserOpenToken {
 
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
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
     * 描述: type     
     * 字段: type  TINYINT(3)  
     */
	@Column(name="type")
	private Integer type;
	
 
	 /**
     * 描述: token     
     * 字段: token  VARCHAR(255)  
     */
	@Column(name="token")
	private java.lang.String token;
	
 
	 /**
     * 描述: updateTime     
     * 字段: update_time  DATETIME(19)  
     */
	@Column(name="update_time")
	private java.util.Date updateTime;
	
 
	 /**
     * 描述: deleteFlag     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 

	public UserOpenToken(){
	}

	public UserOpenToken(
		java.lang.Long id
	){
		this.id = id;
	}

	
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
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
    
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return this.type;
	}
    
	public void setToken(java.lang.String token) {
		this.token = token;
	}
	
	public java.lang.String getToken() {
		return this.token;
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
    
	public void setCreateUser(java.lang.Long createUser) {
		this.createUser = createUser;
	}
	
	public java.lang.Long getCreateUser() {
		return this.createUser;
	}
    
	
	
 
}

