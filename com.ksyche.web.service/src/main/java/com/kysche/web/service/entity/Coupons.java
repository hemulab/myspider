package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_coupons")
public class Coupons {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 优惠券状态：已使用，未使用，已过期     
     * 字段: cou_state  BIGINT(19)  
     */
	@Column(name="cou_state")
	private java.lang.Long couState;
	
 
	 /**
     * 描述: 优惠券面值     
     * 字段: cou_price  DOUBLE(22)  
     */
	@Column(name="cou_price")
	private java.lang.Double couPrice;
	
 
	 /**
     * 描述: 所需消费金额     
     * 字段: cou_need_price  DOUBLE(22)  
     */
	@Column(name="cou_need_price")
	private java.lang.Double couNeedPrice;
	
 
	 /**
     * 描述: 优惠券类别：     
     * 字段: cou_type  BIGINT(19)  
     */
	@Column(name="cou_type")
	private java.lang.Long couType;
	
 
	 /**
     * 描述: 使用限制     
     * 字段: need_limit  VARCHAR(255)  
     */
	@Column(name="need_limit")
	private java.lang.String needLimit;
	
 
	 /**
     * 描述: 过期时间     
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
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 来源     
     * 字段: cou_source  BIGINT(19)  
     */
	@Column(name="cou_source")
	private java.lang.Long couSource;
	
 
	 /**
     * 描述: 0未删除 1删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 

	public Coupons(){
	}

	public Coupons(
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
    
	public void setCouState(java.lang.Long couState) {
		this.couState = couState;
	}
	
	public java.lang.Long getCouState() {
		return this.couState;
	}
    
	public void setCouPrice(java.lang.Double couPrice) {
		this.couPrice = couPrice;
	}
	
	public java.lang.Double getCouPrice() {
		return this.couPrice;
	}
    
	public void setCouNeedPrice(java.lang.Double couNeedPrice) {
		this.couNeedPrice = couNeedPrice;
	}
	
	public java.lang.Double getCouNeedPrice() {
		return this.couNeedPrice;
	}
    
	public void setCouType(java.lang.Long couType) {
		this.couType = couType;
	}
	
	public java.lang.Long getCouType() {
		return this.couType;
	}
    
	public void setNeedLimit(java.lang.String needLimit) {
		this.needLimit = needLimit;
	}
	
	public java.lang.String getNeedLimit() {
		return this.needLimit;
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
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setCouSource(java.lang.Long couSource) {
		this.couSource = couSource;
	}
	
	public java.lang.Long getCouSource() {
		return this.couSource;
	}
    
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
    
	
	
 
}

