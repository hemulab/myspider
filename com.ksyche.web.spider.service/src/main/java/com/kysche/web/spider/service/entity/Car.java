package com.kysche.web.spider.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_cars")
public class Car {
	
	@Id
	private long id;
	
	private int level;
	
	@Column(name="name")
	private String name;
	
	@Column(name="parent_id")
	private long parentID;
	
	@Column(name="car_id")
	private long carID;

	
	@Column(name="car_id_jd")
	private long carIDJD;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

	public long getCarID() {
		return carID;
	}

	public void setCarID(long carID) {
		this.carID = carID;
	}

	public long getCarIDJD() {
		return carIDJD;
	}

	public void setCarIDJD(long carIDJD) {
		this.carIDJD = carIDJD;
	}

	public Car( int level, String name, long parentID, long carID,long carIDJD) {
		super();
		this.level = level;
		this.name = name;
		this.parentID = parentID;
		this.carID = carID;
		this.carIDJD = carIDJD;
	}
	
	public Car( int level, String name,long carID) {
		super();
		this.level = level;
		this.name = name;
		this.carID = carID;
	}

	
	public Car() {
	}
	
}
