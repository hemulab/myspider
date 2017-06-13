package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_user")
public class User {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: 登录帐号     
     * 字段: login_id  VARCHAR(100)  
     */
	@Column(name="login_id")
	private java.lang.String loginId;
	
 
	 /**
     * 描述: 密码     
     * 字段: pwd  VARCHAR(100)  
     */
	@Column(name="pwd")
	private java.lang.String pwd;
	
 
	 /**
     * 描述: 昵称     
     * 字段: user_name  VARCHAR(100)  
     */
	@Column(name="user_name")
	private java.lang.String userName;
	
 
	 /**
     * 描述: 用户类型     
     * 字段: user_type  TINYINT(3)  
     */
	@Column(name="user_type")
	private Integer userType;
	
 
	 /**
     * 描述: 最后登录时间     
     * 字段: last_login_date  DATETIME(19)  
     */
	@Column(name="last_login_date")
	private java.util.Date lastLoginDate;
	
 
	 /**
     * 描述: 注册时间     
     * 字段: reg_time  DATETIME(19)  
     */
	@Column(name="reg_time")
	private java.util.Date regTime;
	
 
	 /**
     * 描述: 图片     
     * 字段: image  VARCHAR(255)  
     */
	@Column(name="image")
	private java.lang.String image;
	
 
	 /**
     * 描述: sex     
     * 字段: sex  TINYINT(3)  
     */
	@Column(name="sex")
	private Integer sex;
	
 
	 /**
     * 描述: 状态     
     * 字段: state  TINYINT(3)  
     */
	@Column(name="state")
	private Integer state;
	
 
	 /**
     * 描述: 分数     
     * 字段: score  INT(10)  
     */
	@Column(name="score")
	private java.lang.Integer score;
	
 
	 /**
     * 描述: jd     
     * 字段: jd  VARCHAR(100)  
     */
	@Column(name="jd")
	private java.lang.String jd;
	
 
	 /**
     * 描述: wd     
     * 字段: wd  VARCHAR(100)  
     */
	@Column(name="wd")
	private java.lang.String wd;
	
 
	 /**
     * 描述: 删除标示0 未删除 1删除     
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
	
 
	 /**
     * 描述: createUser     
     * 字段: create_user  BIGINT(19)  
     */
	@Column(name="create_user")
	private java.lang.Long createUser;
	
 

	public User(){
	}

	public User(
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
    
	public void setLoginId(java.lang.String loginId) {
		this.loginId = loginId;
	}
	
	public java.lang.String getLoginId() {
		return this.loginId;
	}
    
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}
	
	public java.lang.String getPwd() {
		return this.pwd;
	}
    
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
    
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public Integer getUserType() {
		return this.userType;
	}
    
	public void setLastLoginDate(java.util.Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	public java.util.Date getLastLoginDate() {
		return this.lastLoginDate;
	}
    
	public void setRegTime(java.util.Date regTime) {
		this.regTime = regTime;
	}
	
	public java.util.Date getRegTime() {
		return this.regTime;
	}
    
	public void setImage(java.lang.String image) {
		this.image = image;
	}
	
	public java.lang.String getImage() {
		return this.image;
	}
    
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getSex() {
		return this.sex;
	}
    
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getState() {
		return this.state;
	}
    
	public void setScore(java.lang.Integer score) {
		this.score = score;
	}
	
	public java.lang.Integer getScore() {
		return this.score;
	}
    
	public void setJd(java.lang.String jd) {
		this.jd = jd;
	}
	
	public java.lang.String getJd() {
		return this.jd;
	}
    
	public void setWd(java.lang.String wd) {
		this.wd = wd;
	}
	
	public java.lang.String getWd() {
		return this.wd;
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
    
	public void setCreateUser(java.lang.Long createUser) {
		this.createUser = createUser;
	}
	
	public java.lang.Long getCreateUser() {
		return this.createUser;
	}
    
	
	
 
}

