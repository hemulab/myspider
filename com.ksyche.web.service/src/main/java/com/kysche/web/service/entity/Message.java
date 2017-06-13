package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_message")
public class Message {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 接受者id,如果是所有用户，该值为空。     
     * 字段: review_id  BIGINT(19)  
     */
	@Column(name="review_id")
	private java.lang.Long reviewId;
	
 
	 /**
     * 描述: 消息内容     
     * 字段: message  VARCHAR(1024)  
     */
	@Column(name="message")
	private java.lang.String message;
	
 
	 /**
     * 描述: 类型：系统消息，管理员消息     
     * 字段: mess_type  BIGINT(19)  
     */
	@Column(name="mess_type")
	private java.lang.Long messType;
	
 
	 /**
     * 描述: 消息状态：已读，未读，     
     * 字段: state  BIGINT(19)  
     */
	@Column(name="state")
	private java.lang.Long state;
	
 
	 /**
     * 描述: 发送者姓名     
     * 字段: send_name  VARCHAR(100)  
     */
	@Column(name="send_name")
	private java.lang.String sendName;
	
 
	 /**
     * 描述: 单个普通用户，全部普通用户，单个商户，全部商户     
     * 字段: receiver_type  TINYINT(3)  
     */
	@Column(name="receiver_type")
	private Integer receiverType;
	
 
	 /**
     * 描述: 创建时间     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 删除标示 0未删除 1删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 
	 /**
     * 描述: 发送时间     
     * 字段: send_time  DATETIME(19)  
     */
	@Column(name="send_time")
	private java.util.Date sendTime;
	
 

	public Message(){
	}

	public Message(
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
    
	public void setReviewId(java.lang.Long reviewId) {
		this.reviewId = reviewId;
	}
	
	public java.lang.Long getReviewId() {
		return this.reviewId;
	}
    
	public void setMessage(java.lang.String message) {
		this.message = message;
	}
	
	public java.lang.String getMessage() {
		return this.message;
	}
    
	public void setMessType(java.lang.Long messType) {
		this.messType = messType;
	}
	
	public java.lang.Long getMessType() {
		return this.messType;
	}
    
	public void setState(java.lang.Long state) {
		this.state = state;
	}
	
	public java.lang.Long getState() {
		return this.state;
	}
    
	public void setSendName(java.lang.String sendName) {
		this.sendName = sendName;
	}
	
	public java.lang.String getSendName() {
		return this.sendName;
	}
    
	public void setReceiverType(Integer receiverType) {
		this.receiverType = receiverType;
	}
	
	public Integer getReceiverType() {
		return this.receiverType;
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
    
	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}
	
	public java.util.Date getSendTime() {
		return this.sendTime;
	}
    
	
	
 
}

