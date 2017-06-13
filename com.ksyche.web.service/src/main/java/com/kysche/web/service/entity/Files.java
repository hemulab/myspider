package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_files")
public class Files {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: groupId     
     * 字段: group_id  BIGINT(19)  
     */
	@Column(name="group_id")
	private java.lang.Long groupId;
	
 
	 /**
     * 描述: fileContent     
     * 字段: file_content  BLOB(65535)  
     */
	@Column(name="file_content")
	private byte[] fileContent;
	
 
	 /**
     * 描述: fileName     
     * 字段: file_name  VARCHAR(255)  
     */
	@Column(name="file_name")
	private java.lang.String fileName;
	
 
	 /**
     * 描述: fileType     
     * 字段: file_type  TINYINT(3)  
     */
	@Column(name="file_type")
	private Integer fileType;
	
 
	 /**
     * 描述: createTime     
     * 字段: create_time  DATETIME(19)  
     */
	@Column(name="create_time")
	private java.util.Date createTime;
	
 
	 /**
     * 描述: updateTime     
     * 字段: update_time  DATETIME(19)  
     */
	@Column(name="update_time")
	private java.util.Date updateTime;
	
 
	 /**
     * 描述: 删除标示：0未删除。1已经删除     
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
	
 

	public Files(){
	}

	public Files(
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
    
	public void setGroupId(java.lang.Long groupId) {
		this.groupId = groupId;
	}
	
	public java.lang.Long getGroupId() {
		return this.groupId;
	}
    
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
	public byte[] getFileContent() {
		return this.fileContent;
	}
    
	public void setFileName(java.lang.String fileName) {
		this.fileName = fileName;
	}
	
	public java.lang.String getFileName() {
		return this.fileName;
	}
    
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	
	public Integer getFileType() {
		return this.fileType;
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
    
	
	
 
}

