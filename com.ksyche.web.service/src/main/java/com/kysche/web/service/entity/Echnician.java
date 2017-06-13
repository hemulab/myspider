package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_technician")
public class Echnician {
 
 
	 /**
     * 描述: id     
     * 字段: ID  INT(10)  
     */
	@Column(name="ID")
	private java.lang.Integer id;
	
 
	 /**
     * 描述: 技师姓名     
     * 字段: NAME  VARCHAR(200)  
     */
	@Column(name="NAME")
	private java.lang.String name;
	
 
	 /**
     * 描述: 性别（1:男,2:女）     
     * 字段: SEX  TINYINT(3)  
     */
	@Column(name="SEX")
	private Integer sex;
	
 
	 /**
     * 描述: 身份证号     
     * 字段: ID_CARD  VARCHAR(20)  
     */
	@Column(name="ID_CARD")
	private java.lang.String idCard;
	
 
	 /**
     * 描述: 职业资质     
     * 字段: OCCUPATION_QUALIFICATION  VARCHAR(100)  
     */
	@Column(name="OCCUPATION_QUALIFICATION")
	private java.lang.String occupationQualification;
	
 
	 /**
     * 描述: 住址     
     * 字段: ADDRESS  VARCHAR(200)  
     */
	@Column(name="ADDRESS")
	private java.lang.String address;
	
 
	 /**
     * 描述: 服务范围     
     * 字段: SERVICE_SCOPE  VARCHAR(500)  
     */
	@Column(name="SERVICE_SCOPE")
	private java.lang.String serviceScope;
	
 
	 /**
     * 描述: 手机     
     * 字段: MOBILE  VARCHAR(20)  
     */
	@Column(name="MOBILE")
	private java.lang.String mobile;
	
 
	 /**
     * 描述: 状态(1:有效,2:无效）     
     * 字段: STATUS  TINYINT(3)  
     */
	@Column(name="STATUS")
	private Integer status;
	
 
	 /**
     * 描述: 创建时间     
     * 字段: CREATE_DATE  DATETIME(19)  
     */
	@Column(name="CREATE_DATE")
	private java.util.Date createDate;
	
 

	public Echnician(){
	}

	public Echnician(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
    
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
    
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getSex() {
		return this.sex;
	}
    
	public void setIdCard(java.lang.String idCard) {
		this.idCard = idCard;
	}
	
	public java.lang.String getIdCard() {
		return this.idCard;
	}
    
	public void setOccupationQualification(java.lang.String occupationQualification) {
		this.occupationQualification = occupationQualification;
	}
	
	public java.lang.String getOccupationQualification() {
		return this.occupationQualification;
	}
    
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
    
	public void setServiceScope(java.lang.String serviceScope) {
		this.serviceScope = serviceScope;
	}
	
	public java.lang.String getServiceScope() {
		return this.serviceScope;
	}
    
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
    
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return this.status;
	}
    
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
    
	
	
 
}

