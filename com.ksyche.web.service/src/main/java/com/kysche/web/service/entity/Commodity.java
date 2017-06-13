package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_commodity")
public class Commodity {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 品牌     
     * 字段: brand  VARCHAR(100)  
     */
	@Column(name="brand")
	private java.lang.String brand;
	
 
	 /**
     * 描述: 名称     
     * 字段: name  VARCHAR(255)  
     */
	@Column(name="name")
	private java.lang.String name;
	
 
	 /**
     * 描述: 单价     
     * 字段: price  DOUBLE(22)  
     */
	@Column(name="price")
	private java.lang.Double price;
	
 
	 /**
     * 描述: 规格     
     * 字段: spec  VARCHAR(255)  
     */
	@Column(name="spec")
	private java.lang.String spec;
	
 
	 /**
     * 描述: 已售     
     * 字段: sell_num  INT(10)  
     */
	@Column(name="sell_num")
	private java.lang.Integer sellNum;
	
 
	 /**
     * 描述: 未售数量     
     * 字段: not_sell_num  INT(10)  
     */
	@Column(name="not_sell_num")
	private java.lang.Integer notSellNum;
	
 
	 /**
     * 描述: 所属类型     
     * 字段: comm_type  BIGINT(19)  
     */
	@Column(name="comm_type")
	private java.lang.Long commType;
	
 
	 /**
     * 描述: 备注描述     
     * 字段: memo  VARCHAR(2048)  
     */
	@Column(name="memo")
	private java.lang.String memo;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 图片组id     
     * 字段: image  BIGINT(19)  
     */
	@Column(name="image")
	private java.lang.Long image;
	
 
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
     * 描述: 0未删除，1删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 

	public Commodity(){
	}

	public Commodity(
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
    
	public void setBrand(java.lang.String brand) {
		this.brand = brand;
	}
	
	public java.lang.String getBrand() {
		return this.brand;
	}
    
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
    
	public void setPrice(java.lang.Double price) {
		this.price = price;
	}
	
	public java.lang.Double getPrice() {
		return this.price;
	}
    
	public void setSpec(java.lang.String spec) {
		this.spec = spec;
	}
	
	public java.lang.String getSpec() {
		return this.spec;
	}
    
	public void setSellNum(java.lang.Integer sellNum) {
		this.sellNum = sellNum;
	}
	
	public java.lang.Integer getSellNum() {
		return this.sellNum;
	}
    
	public void setNotSellNum(java.lang.Integer notSellNum) {
		this.notSellNum = notSellNum;
	}
	
	public java.lang.Integer getNotSellNum() {
		return this.notSellNum;
	}
    
	public void setCommType(java.lang.Long commType) {
		this.commType = commType;
	}
	
	public java.lang.Long getCommType() {
		return this.commType;
	}
    
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	
	public java.lang.String getMemo() {
		return this.memo;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setImage(java.lang.Long image) {
		this.image = image;
	}
	
	public java.lang.Long getImage() {
		return this.image;
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

