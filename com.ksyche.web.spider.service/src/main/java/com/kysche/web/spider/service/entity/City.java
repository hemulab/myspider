package com.kysche.web.spider.service.entity;

import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="tbl_city")
public class City {

	@Id
	private long id;
	
	
	private String cnname;
	
	private String enname;
	
	private long parentid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public long getParentid() {
		return parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}
	
	
}
