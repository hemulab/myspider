package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_dictionary")
public class Dictionary {
 
 
	 /**
     * 描述: 层级     
     * 字段: level  TINYINT(3)  
     */
	@Column(name="level")
	private Integer level;
	
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 字典编码，作为预留字段，程序中引用ID     
     * 字段: item_code  VARCHAR(255)  
     */
	@Column(name="item_code")
	private java.lang.String itemCode;
	
 
	 /**
     * 描述: 字典项名称     
     * 字段: item_name  VARCHAR(100)  
     */
	@Column(name="item_name")
	private java.lang.String itemName;
	
 
	 /**
     * 描述: 父字典ID     
     * 字段: parent_id  BIGINT(19)  
     */
	@Column(name="parent_id")
	private java.lang.Long parentId;
	
 
	 /**
     * 描述: memo     
     * 字段: memo  VARCHAR(255)  
     */
	@Column(name="memo")
	private java.lang.String memo;
	
 
	 /**
     * 描述: 字典项的显示顺序     
     * 字段: order_id  INT(10)  
     */
	@Column(name="order_id")
	private java.lang.Integer orderId;
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 
	 /**
     * 描述: 0未删除 1珊瑚     
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
	
 

	public Dictionary(){
	}

	public Dictionary(
		java.lang.Long id
	){
		this.id = id;
	}

	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getLevel() {
		return this.level;
	}
    
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
    
	public void setItemCode(java.lang.String itemCode) {
		this.itemCode = itemCode;
	}
	
	public java.lang.String getItemCode() {
		return this.itemCode;
	}
    
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
	}
	
	public java.lang.String getItemName() {
		return this.itemName;
	}
    
	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}
	
	public java.lang.Long getParentId() {
		return this.parentId;
	}
    
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	
	public java.lang.String getMemo() {
		return this.memo;
	}
    
	public void setOrderId(java.lang.Integer orderId) {
		this.orderId = orderId;
	}
	
	public java.lang.Integer getOrderId() {
		return this.orderId;
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
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	
	
 
}

