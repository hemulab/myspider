package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user_order")
public class UserOrder {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 订单号     
     * 字段: order_num  VARCHAR(255)  
     */
	@Column(name="order_num")
	private java.lang.String orderNum;
	
 
	 /**
     * 描述: 用户id     
     * 字段: user_id  BIGINT(19)  
     */
	@Column(name="user_id")
	private java.lang.Long userId;
	
 
	 /**
     * 描述: 用户车辆id     
     * 字段: car_id  BIGINT(19)  
     */
	@Column(name="car_id")
	private java.lang.Long carId;
	
 
	 /**
     * 描述: 订单日期     
     * 字段: order_time  DATETIME(19)  
     */
	@Column(name="order_time")
	private java.util.Date orderTime;
	
 
	 /**
     * 描述: 预约 姓名     
     * 字段: mark_name  VARCHAR(100)  
     */
	@Column(name="mark_name")
	private java.lang.String markName;
	
 
	 /**
     * 描述: 预约电话号码     
     * 字段: mark_tel  VARCHAR(100)  
     */
	@Column(name="mark_tel")
	private java.lang.String markTel;
	
 
	 /**
     * 描述: 预约时间     
     * 字段: mark_time  DATETIME(19)  
     */
	@Column(name="mark_time")
	private java.util.Date markTime;
	
 
	 /**
     * 描述: 预约地点     
     * 字段: mark_address  VARCHAR(255)  
     */
	@Column(name="mark_address")
	private java.lang.String markAddress;
	
 
	 /**
     * 描述: 订单状态     
     * 字段: order_state  BIGINT(19)  
     */
	@Column(name="order_state")
	private java.lang.Long orderState;
	
 
	 /**
     * 描述: 付款价格     
     * 字段: pay_money  DOUBLE(22)  
     */
	@Column(name="pay_money")
	private java.lang.Double payMoney;
	
 
	 /**
     * 描述: 订单总金额     
     * 字段: order_money  DOUBLE(22)  
     */
	@Column(name="order_money")
	private java.lang.Double orderMoney;
	
 
	 /**
     * 描述: 服务商id     
     * 字段: business_id  BIGINT(19)  
     */
	@Column(name="business_id")
	private java.lang.Long businessId;
	
 
	 /**
     * 描述: 订单类型：抢单，到店上门，洗车     
     * 字段: order_type  BIGINT(19)  
     */
	@Column(name="order_type")
	private java.lang.Long orderType;
	
 
	 /**
     * 描述: 服务项目：换机油，换滤清器等     
     * 字段: service_proj_id  VARCHAR(255)  
     */
	@Column(name="service_proj_id")
	private java.lang.String serviceProjId;
	
 
	 /**
     * 描述: 付款时间     
     * 字段: pay_time  DATETIME(19)  
     */
	@Column(name="pay_time")
	private java.util.Date payTime;
	
 
	 /**
     * 描述: 付款类型：支付宝，微信等     
     * 字段: pay_type  BIGINT(19)  
     */
	@Column(name="pay_type")
	private java.lang.Long payType;
	
 
	 /**
     * 描述: 付款状态     
     * 字段: pay_state  BIGINT(19)  
     */
	@Column(name="pay_state")
	private java.lang.Long payState;
	
 
	 /**
     * 描述: 服务类型：上门保养，到店保养     
     * 字段: service_type  BIGINT(19)  
     */
	@Column(name="service_type")
	private java.lang.Long serviceType;
	
 
	 /**
     * 描述: 工程师id     
     * 字段: eng_id  INT(10)  
     */
	@Column(name="eng_id")
	private java.lang.Integer engId;
	
 
	 /**
     * 描述: 创建时间     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 更新时间     
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
     * 描述: 优惠券id     
     * 字段: coup_id  BIGINT(19)  
     */
	@Column(name="coup_id")
	private java.lang.Long coupId;
	
 
	 /**
     * 描述: 删除标示：0未删除，1删除，2废弃等     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 

	public UserOrder(){
	}

	public UserOrder(
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
    
	public void setOrderNum(java.lang.String orderNum) {
		this.orderNum = orderNum;
	}
	
	public java.lang.String getOrderNum() {
		return this.orderNum;
	}
    
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
    
	public void setCarId(java.lang.Long carId) {
		this.carId = carId;
	}
	
	public java.lang.Long getCarId() {
		return this.carId;
	}
    
	public void setOrderTime(java.util.Date orderTime) {
		this.orderTime = orderTime;
	}
	
	public java.util.Date getOrderTime() {
		return this.orderTime;
	}
    
	public void setMarkName(java.lang.String markName) {
		this.markName = markName;
	}
	
	public java.lang.String getMarkName() {
		return this.markName;
	}
    
	public void setMarkTel(java.lang.String markTel) {
		this.markTel = markTel;
	}
	
	public java.lang.String getMarkTel() {
		return this.markTel;
	}
    
	public void setMarkTime(java.util.Date markTime) {
		this.markTime = markTime;
	}
	
	public java.util.Date getMarkTime() {
		return this.markTime;
	}
    
	public void setMarkAddress(java.lang.String markAddress) {
		this.markAddress = markAddress;
	}
	
	public java.lang.String getMarkAddress() {
		return this.markAddress;
	}
    
	public void setOrderState(java.lang.Long orderState) {
		this.orderState = orderState;
	}
	
	public java.lang.Long getOrderState() {
		return this.orderState;
	}
    
	public void setPayMoney(java.lang.Double payMoney) {
		this.payMoney = payMoney;
	}
	
	public java.lang.Double getPayMoney() {
		return this.payMoney;
	}
    
	public void setOrderMoney(java.lang.Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	
	public java.lang.Double getOrderMoney() {
		return this.orderMoney;
	}
    
	public void setBusinessId(java.lang.Long businessId) {
		this.businessId = businessId;
	}
	
	public java.lang.Long getBusinessId() {
		return this.businessId;
	}
    
	public void setOrderType(java.lang.Long orderType) {
		this.orderType = orderType;
	}
	
	public java.lang.Long getOrderType() {
		return this.orderType;
	}
    
	public void setServiceProjId(java.lang.String serviceProjId) {
		this.serviceProjId = serviceProjId;
	}
	
	public java.lang.String getServiceProjId() {
		return this.serviceProjId;
	}
    
	public void setPayTime(java.util.Date payTime) {
		this.payTime = payTime;
	}
	
	public java.util.Date getPayTime() {
		return this.payTime;
	}
    
	public void setPayType(java.lang.Long payType) {
		this.payType = payType;
	}
	
	public java.lang.Long getPayType() {
		return this.payType;
	}
    
	public void setPayState(java.lang.Long payState) {
		this.payState = payState;
	}
	
	public java.lang.Long getPayState() {
		return this.payState;
	}
    
	public void setServiceType(java.lang.Long serviceType) {
		this.serviceType = serviceType;
	}
	
	public java.lang.Long getServiceType() {
		return this.serviceType;
	}
    
	public void setEngId(java.lang.Integer engId) {
		this.engId = engId;
	}
	
	public java.lang.Integer getEngId() {
		return this.engId;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
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
    
	public void setCoupId(java.lang.Long coupId) {
		this.coupId = coupId;
	}
	
	public java.lang.Long getCoupId() {
		return this.coupId;
	}
    
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
    
	
	
 
}

