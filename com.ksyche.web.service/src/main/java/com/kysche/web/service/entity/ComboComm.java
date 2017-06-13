package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_combo_comm")
public class ComboComm {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: commId     
     * 字段: comm_id  BIGINT(19)  
     */
	@Column(name="comm_id")
	private java.lang.Long commId;
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: 套餐id     
     * 字段: combo_id  BIGINT(19)  
     */
	@Column(name="combo_id")
	private java.lang.Long comboId;
	
 
	 /**
     * 描述: 0未删除 1删除     
     * 字段: delete_flag  TINYINT(3)  
     */
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
 

	public ComboComm(){
	}

	public ComboComm(
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
    
	public void setCommId(java.lang.Long commId) {
		this.commId = commId;
	}
	
	public java.lang.Long getCommId() {
		return this.commId;
	}
    
	public void setCreateUser(java.lang.Long createUser) {
		this.createUser = createUser;
	}
	
	public java.lang.Long getCreateUser() {
		return this.createUser;
	}
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
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
    
	
	
 
}

