package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user_coupons")
public class UserCoupons {
 
 
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
     * 描述: conId     
     * 字段: con_id  BIGINT(19)  
     */
	@Column(name="con_id")
	private java.lang.Long conId;
	
 
	 /**
     * 描述: 获得时间     
     * 字段: get_time  DATETIME(19)  
     */
	@Column(name="get_time")
	private java.util.Date getTime;
	
 
	 /**
     * 描述: 状态     
     * 字段: state  TINYINT(3)  
     */
	@Column(name="state")
	private Integer state;
	
 

	public UserCoupons(){
	}

	public UserCoupons(
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
    
	public void setConId(java.lang.Long conId) {
		this.conId = conId;
	}
	
	public java.lang.Long getConId() {
		return this.conId;
	}
    
	public void setGetTime(java.util.Date getTime) {
		this.getTime = getTime;
	}
	
	public java.util.Date getGetTime() {
		return this.getTime;
	}
    
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getState() {
		return this.state;
	}
    
	
	
 
}

