package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user_address")
public class UserAddress {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 用户id     
     * 字段: user_id  BIGINT(19)  
     */
	@Column(name="user_id")
	private java.lang.Long userId;
	
 
	 /**
     * 描述: 具体地址     
     * 字段: address  VARCHAR(1024)  
     */
	@Column(name="address")
	private java.lang.String address;
	
 
	 /**
     * 描述: 类型：家，公司，其他等     
     * 字段: address_type  BIGINT(19)  
     */
	@Column(name="address_type")
	private java.lang.Long addressType;
	
 
	 /**
     * 描述: 城市id     
     * 字段: city_id  BIGINT(19)  
     */
	@Column(name="city_id")
	private java.lang.Long cityId;
	
 
	 /**
     * 描述: jd     
     * 字段: jd  DOUBLE(22)  
     */
	@Column(name="jd")
	private java.lang.Double jd;
	
 
	 /**
     * 描述: wd     
     * 字段: wd  DOUBLE(22)  
     */
	@Column(name="wd")
	private java.lang.Double wd;
	
 
	 /**
     * 描述: tel     
     * 字段: tel  VARCHAR(20)  
     */
	@Column(name="tel")
	private java.lang.String tel;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 是否是默认     
     * 字段: is_default  TINYINT(3)  
     */
	@Column(name="is_default")
	private Integer isDefault;
	
 
	 /**
     * 描述: updateTime     
     * 字段: update_time  DATETIME(19)  
     */
	@Column(name="update_time")
	private java.util.Date updateTime;
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 
	 /**
     * 描述: 删除标示：0未删除，1已删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 

	public UserAddress(){
	}

	public UserAddress(
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
    
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
    
	public void setAddressType(java.lang.Long addressType) {
		this.addressType = addressType;
	}
	
	public java.lang.Long getAddressType() {
		return this.addressType;
	}
    
	public void setCityId(java.lang.Long cityId) {
		this.cityId = cityId;
	}
	
	public java.lang.Long getCityId() {
		return this.cityId;
	}
    
	public void setJd(java.lang.Double jd) {
		this.jd = jd;
	}
	
	public java.lang.Double getJd() {
		return this.jd;
	}
    
	public void setWd(java.lang.Double wd) {
		this.wd = wd;
	}
	
	public java.lang.Double getWd() {
		return this.wd;
	}
    
	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	
	public Integer getIsDefault() {
		return this.isDefault;
	}
    
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
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
    
	
	
 
}

