package com.kysche.web.spider.service.entity;

import java.util.Date;

import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_wei_xiu_factory")
public class WeiXiuFactory {
	
	@Id
	private long id;
	
	private String name;
	
	private String tel;
	
	private String city;
	
	private String addr;
	
	private double grade;
	
	private String image;

	private Date dt;
	private int type ;//14s店铺   2 普通维修店 
	
	private String url;
	
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


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WeiXiuFactory( String name,String tel, String city, String addr,
			double grade, String image, int type) {
		this.name = name;
		this.tel = tel;
		this.city = city;
		this.addr = addr;
		this.grade = grade;
		this.image = image;
		this.type = type;
	}

	public WeiXiuFactory() {
	}

	@Override
	public String toString() {
		return "WeiXiuFactory [id=" + id + ", name=" + name + ", tel=" + tel
				+ ", city=" + city + ", addr=" + addr + ", grade=" + grade
				+ ", image=" + image + ", dt=" + dt + ", type=" + type + "]";
	}
	
	

}
