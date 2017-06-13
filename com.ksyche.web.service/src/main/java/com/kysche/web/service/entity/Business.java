package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_business")
public class Business {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 商家名称     
     * 字段: bus_name  VARCHAR(100)  
     */
	@Column(name="bus_name")
	private java.lang.String busName;
	
 
	 /**
     * 描述: 商家类型：4s，非4s     
     * 字段: bus_type  TINYINT(3)  
     */
	@Column(name="bus_type")
	private Integer busType;
	
 
	 /**
     * 描述: 是否可上门服务     
     * 字段: is_room_service  TINYINT(3)  
     */
	@Column(name="is_room_service")
	private Integer isRoomService;
	
 
	 /**
     * 描述: 等级     
     * 字段: rank  DOUBLE(22)  
     */
	@Column(name="rank")
	private java.lang.Double rank;
	
 
	 /**
     * 描述: 地点     
     * 字段: address  VARCHAR(255)  
     */
	@Column(name="address")
	private java.lang.String address;
	
 
	 /**
     * 描述: 联系电话     
     * 字段: tel  VARCHAR(50)  
     */
	@Column(name="tel")
	private java.lang.String tel;
	
 
	 /**
     * 描述: 详细介绍     
     * 字段: details  VARCHAR(2048)  
     */
	@Column(name="details")
	private java.lang.String details;
	
 
	 /**
     * 描述: 图片     
     * 字段: image  BIGINT(19)  
     */
	@Column(name="image")
	private java.lang.Long image;
	
 
	 /**
     * 描述: 营业时间     
     * 字段: bus_time  DATETIME(19)  
     */
	@Column(name="bus_time")
	private java.util.Date busTime;
	
 
	 /**
     * 描述: 坐标位置     
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
     * 描述: cityId     
     * 字段: city_id  BIGINT(19)  
     */
	@Column(name="city_id")
	private java.lang.Long cityId;
	
 
	 /**
     * 描述: 查看次数     
     * 字段: look_num  INT(10)  
     */
	@Column(name="look_num")
	private java.lang.Integer lookNum;
	
 
	 /**
     * 描述: 0未删除 1删除     
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
	
 

	public Business(){
	}
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
    
	public void setBusName(java.lang.String busName) {
		this.busName = busName;
	}
	
	public java.lang.String getBusName() {
		return this.busName;
	}
    
	public void setBusType(Integer busType) {
		this.busType = busType;
	}
	
	public Integer getBusType() {
		return this.busType;
	}
    
	public void setIsRoomService(Integer isRoomService) {
		this.isRoomService = isRoomService;
	}
	
	public Integer getIsRoomService() {
		return this.isRoomService;
	}
    
	public void setRank(java.lang.Double rank) {
		this.rank = rank;
	}
	
	public java.lang.Double getRank() {
		return this.rank;
	}
    
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
    
	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
    
	public void setDetails(java.lang.String details) {
		this.details = details;
	}
	
	public java.lang.String getDetails() {
		return this.details;
	}
    
	public void setImage(java.lang.Long image) {
		this.image = image;
	}
	
	public java.lang.Long getImage() {
		return this.image;
	}
    
	public void setBusTime(java.util.Date busTime) {
		this.busTime = busTime;
	}
	
	public java.util.Date getBusTime() {
		return this.busTime;
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
    
	public void setCityId(java.lang.Long cityId) {
		this.cityId = cityId;
	}
	
	public java.lang.Long getCityId() {
		return this.cityId;
	}
    
	public void setLookNum(java.lang.Integer lookNum) {
		this.lookNum = lookNum;
	}
	
	public java.lang.Integer getLookNum() {
		return this.lookNum;
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
    
	
	
 
}

