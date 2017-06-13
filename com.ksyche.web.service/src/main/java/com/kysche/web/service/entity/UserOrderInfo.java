package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user_order_info")
public class UserOrderInfo {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 订单id     
     * 字段: order_id  BIGINT(19)  
     */
	@Column(name="order_id")
	private java.lang.Long orderId;
	
 
	 /**
     * 描述: 商品id     
     * 字段: comm_id  BIGINT(19)  
     */
	@Column(name="comm_id")
	private java.lang.Long commId;
	
 
	 /**
     * 描述: 商品数量     
     * 字段: comm_num  INT(10)  
     */
	@Column(name="comm_num")
	private java.lang.Integer commNum;
	
 
	 /**
     * 描述: 商品单价     
     * 字段: comm_price  DOUBLE(22)  
     */
	@Column(name="comm_price")
	private java.lang.Double commPrice;
	
 
	 /**
     * 描述: 是否是套餐     
     * 字段: is_combo  BIGINT(19)  
     */
	@Column(name="is_combo")
	private java.lang.Long isCombo;
	
 
	 /**
     * 描述: 套餐id     
     * 字段: combo_id  BIGINT(19)  
     */
	@Column(name="combo_id")
	private java.lang.Long comboId;
	
 
	 /**
     * 描述: 删除标示 0 未删除，1删除     
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
	
 

	public UserOrderInfo(){
	}

	public UserOrderInfo(
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
    
	public void setOrderId(java.lang.Long orderId) {
		this.orderId = orderId;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
    
	public void setCommId(java.lang.Long commId) {
		this.commId = commId;
	}
	
	public java.lang.Long getCommId() {
		return this.commId;
	}
    
	public void setCommNum(java.lang.Integer commNum) {
		this.commNum = commNum;
	}
	
	public java.lang.Integer getCommNum() {
		return this.commNum;
	}
    
	public void setCommPrice(java.lang.Double commPrice) {
		this.commPrice = commPrice;
	}
	
	public java.lang.Double getCommPrice() {
		return this.commPrice;
	}
    
	public void setIsCombo(java.lang.Long isCombo) {
		this.isCombo = isCombo;
	}
	
	public java.lang.Long getIsCombo() {
		return this.isCombo;
	}
    
	public void setComboId(java.lang.Long comboId) {
		this.comboId = comboId;
	}
	
	public java.lang.Long getComboId() {
		return this.comboId;
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

