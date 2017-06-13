package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user_cars")
public class UserCars {
 
 
	 /**
     * 描述: 主键     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 车辆id     
     * 字段: car_id  BIGINT(19)  
     */
	@Column(name="car_id")
	private java.lang.Long carId;
	
 
	 /**
     * 描述: 里程     
     * 字段: mileage  INT(10)  
     */
	@Column(name="mileage")
	private java.lang.Integer mileage;
	
 
	 /**
     * 描述: 用户id     
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
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 
	 /**
     * 描述: updateTime     
     * 字段: update_time  DATETIME(19)  
     */
	@Column(name="update_time")
	private java.util.Date updateTime;
	
 
	 /**
     * 描述: 是否删除了,0未删除，1删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 

	public UserCars(){
	}

	public UserCars(
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
    
	public void setCarId(java.lang.Long carId) {
		this.carId = carId;
	}
	
	public java.lang.Long getCarId() {
		return this.carId;
	}
    
	public void setMileage(java.lang.Integer mileage) {
		this.mileage = mileage;
	}
	
	public java.lang.Integer getMileage() {
		return this.mileage;
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
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setCreateUser(java.lang.Long createUser) {
		this.createUser = createUser;
	}
	
	public java.lang.Long getCreateUser() {
		return this.createUser;
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
    
	
	
 
}

