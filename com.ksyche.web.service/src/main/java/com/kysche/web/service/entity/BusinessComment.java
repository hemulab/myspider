package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_business_comment")
public class BusinessComment {
 
 
	 /**
     * 描述: 主键     
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
     * 描述: 用户id     
     * 字段: user_id  BIGINT(19)  
     */
	@Column(name="user_id")
	private java.lang.Long userId;
	
 
	 /**
     * 描述: 订单id，针对哪个订单评价的     
     * 字段: order_id  BIGINT(19)  
     */
	@Column(name="order_id")
	private java.lang.Long orderId;
	
 
	 /**
     * 描述: 评级等级几颗星     
     * 字段: rank  DOUBLE(22)  
     */
	@Column(name="rank")
	private java.lang.Double rank;
	
 
	 /**
     * 描述: 评级时间     
     * 字段: comment_time  DATETIME(19)  
     */
	@Column(name="comment_time")
	private java.util.Date commentTime;
	
 
	 /**
     * 描述: 评价内容     
     * 字段: content  VARCHAR(1024)  
     */
	@Column(name="content")
	private java.lang.String content;
	
 
	 /**
     * 描述: updateTime     
     * 字段: update_time  DATETIME(19)  
     */
	@Column(name="update_time")
	private java.util.Date updateTime;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 创建者     
     * 字段: creat_user  BIGINT(19)  
     */
	@Column(name="creat_user")
	private java.lang.Long creatUser;
	
 
	 /**
     * 描述: 删除标示0未删除，1已经删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 
	 /**
     * 描述: 其他     
     * 字段: qt  VARCHAR(255)  
     */
	@Column(name="qt")
	private java.lang.String qt;
	
 

	public BusinessComment(){
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
    
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
    
	public void setOrderId(java.lang.Long orderId) {
		this.orderId = orderId;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
    
	public void setRank(java.lang.Double rank) {
		this.rank = rank;
	}
	
	public java.lang.Double getRank() {
		return this.rank;
	}
    
	public void setCommentTime(java.util.Date commentTime) {
		this.commentTime = commentTime;
	}
	
	public java.util.Date getCommentTime() {
		return this.commentTime;
	}
    
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
    
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
    
	public void setCreatUser(java.lang.Long creatUser) {
		this.creatUser = creatUser;
	}
	
	public java.lang.Long getCreatUser() {
		return this.creatUser;
	}
    
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
    
	public void setQt(java.lang.String qt) {
		this.qt = qt;
	}
	
	public java.lang.String getQt() {
		return this.qt;
	}
    
	
	
 
}

