package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

/**
 * @Project       : com.ksyche.web.service
 * @Program Name  : com.kysche.web.service.entity.Shops.java
 * @Description   : 加盟店铺实体类
 * @Author        : wangchao
 * @Creation Date : 2015-4-16 下午7:37:05 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * wangchao     2015-4-16        create
 */
@Table(name="t_shops")
public class Shops {
 
	 /**
     * 描述:id     
     * 字段: ID  INT(10)  
     */
	@Id
	private java.lang.Integer id;
	
 
	 /**
     * 描述:店铺类型（1:维修店铺;2:洗车店铺）     
     * 字段: COMPANY_TYPE  TINYINT(3)  
     */
	@Column(name="COMPANY_TYPE")
	private Integer companyType;
	
 
	 /**
     * 描述:企业名称     
     * 字段: COMPANY_NAME  VARCHAR(100)  
     */
	@Column(name="COMPANY_NAME")
	private java.lang.String companyName;
	
 
	 /**
     * 描述:维修资质类别（1:一级,2:二级,3:三级）     
     * 字段: QUALIFICATION_TYPE  TINYINT(3)  
     */
	@Column(name="QUALIFICATION_TYPE")
	private Integer qualificationType;
	
 
	 /**
     * 描述:维修品牌     
     * 字段: SERVICING_BRAND  VARCHAR(500)  
     */
	@Column(name="SERVICING_BRAND")
	private java.lang.String servicingBrand;
	
 
	 /**
     * 描述:经营地址     
     * 字段: BUSINESS_ADDRESS  VARCHAR(200)  
     */
	@Column(name="BUSINESS_ADDRESS")
	private java.lang.String businessAddress;
	
 
	 /**
     * 描述:联系人     
     * 字段: CONTACT  VARCHAR(50)  
     */
	@Column(name="CONTACT")
	private java.lang.String contact;
	
 
	 /**
     * 描述:联系人手机     
     * 字段: MOBILE  VARCHAR(20)  
     */
	@Column(name="MOBILE")
	private java.lang.String mobile;
	
 
	 /**
     * 描述:状态（1:无效,2:有效）     
     * 字段: STATUS  TINYINT(3)  
     */
	@Column(name="STATUS")
	private Integer status;
	
 
	 /**
     * 描述:创建时间     
     * 字段: CREATE_DATE  DATETIME(19)  
     */
	@Column(name="CREATE_DATE")
	private java.util.Date createDate;
 

	public Shops() {
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
    
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
	
	public Integer getCompanyType() {
		return this.companyType;
	}
    
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}
	
	public java.lang.String getCompanyName() {
		return this.companyName;
	}
	
    
    
	public void setQualificationType(Integer qualificationType) {
		this.qualificationType = qualificationType;
	}
	
	public Integer getQualificationType() {
		return this.qualificationType;
	}
	
    
    
	public void setServicingBrand(java.lang.String servicingBrand) {
		this.servicingBrand = servicingBrand;
	}
	
	public java.lang.String getServicingBrand() {
		return this.servicingBrand;
	}
	
    
    
	public void setBusinessAddress(java.lang.String businessAddress) {
		this.businessAddress = businessAddress;
	}
	
	public java.lang.String getBusinessAddress() {
		return this.businessAddress;
	}
	
    
    
	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}
	
	public java.lang.String getContact() {
		return this.contact;
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

