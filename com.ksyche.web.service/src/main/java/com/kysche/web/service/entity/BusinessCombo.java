package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_business_combo")
public class BusinessCombo {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 商家id     
     * 字段: bus_id  BIGINT(19)  
     */
	@Column(name="bus_id")
	private java.lang.Long busId;
	
 
	 /**
     * 描述: 套餐名称     
     * 字段: com_name  VARCHAR(255)  
     */
	@Column(name="com_name")
	private java.lang.String comName;
	
 
	 /**
     * 描述: 套餐价格     
     * 字段: com_price  DOUBLE(22)  
     */
	@Column(name="com_price")
	private java.lang.Double comPrice;
	
 
	 /**
     * 描述: 套餐类型     
     * 字段: com_type  BIGINT(19)  
     */
	@Column(name="com_type")
	private java.lang.Long comType;
	
 
	 /**
     * 描述: 套餐描述     
     * 字段: com_dis  VARCHAR(1024)  
     */
	@Column(name="com_dis")
	private java.lang.String comDis;
	
 
	 /**
     * 描述: 商品数量     
     * 字段: com_num  INT(10)  
     */
	@Column(name="com_num")
	private java.lang.Integer comNum;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 0未删除，1删除     
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
	
 
	 /**
     * 描述: 套餐过期时间     
     * 字段: com_over_time  DATETIME(19)  
     */
	@Column(name="com_over_time")
	private java.util.Date comOverTime;
	
 

	public BusinessCombo(){
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
    
	public void setComName(java.lang.String comName) {
		this.comName = comName;
	}
	
	public java.lang.String getComName() {
		return this.comName;
	}
    
	public void setComPrice(java.lang.Double comPrice) {
		this.comPrice = comPrice;
	}
	
	public java.lang.Double getComPrice() {
		return this.comPrice;
	}
    
	public void setComType(java.lang.Long comType) {
		this.comType = comType;
	}
	
	public java.lang.Long getComType() {
		return this.comType;
	}
    
	public void setComDis(java.lang.String comDis) {
		this.comDis = comDis;
	}
	
	public java.lang.String getComDis() {
		return this.comDis;
	}
    
	public void setComNum(java.lang.Integer comNum) {
		this.comNum = comNum;
	}
	
	public java.lang.Integer getComNum() {
		return this.comNum;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
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
    
	public void setComOverTime(java.util.Date comOverTime) {
		this.comOverTime = comOverTime;
	}
	
	public java.util.Date getComOverTime() {
		return this.comOverTime;
	}
    
	
	
 
}

