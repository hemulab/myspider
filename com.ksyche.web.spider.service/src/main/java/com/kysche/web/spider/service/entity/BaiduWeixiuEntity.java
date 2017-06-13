package com.kysche.web.spider.service.entity;

import java.util.Date;

import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_baidu_weixiu")
public class BaiduWeixiuEntity {

	@Id
	private long id;
	
	private String name;
	
	private String address;
	
	private String street_id;
	
	private String telephone;
	
	private int detail;
	
	private String uid;
	
	private String city;
	
	private long pid;
	
	private Date dt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet_id() {
		return street_id;
	}

	public void setStreet_id(String street_id) {
		this.street_id = street_id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getDetail() {
		return detail;
	}

	public void setDetail(int detail) {
		this.detail = detail;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	
}
