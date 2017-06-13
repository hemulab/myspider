package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_car_item_jd")
public class CarItemJD {

	@Id
	private long id;
	
	@Column(name="car_id")
	private long carID;
	
	@Column(name="accy_cat_id")
	private long accyCatID;
	
	private String name;
	
	@Column(name="item_id")
	private long itemID;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	@Column(name="car_id_jd")
	private long carIDJD;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCarID() {
		return carID;
	}

	public void setCarID(long carID) {
		this.carID = carID;
	}

	public long getAccyCatID() {
		return accyCatID;
	}

	public void setAccyCatID(long accyCatID) {
		this.accyCatID = accyCatID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public long getCarIDJD() {
		return carIDJD;
	}

	public void setCarIDJD(long carIDJD) {
		this.carIDJD = carIDJD;
	}
	
	
	
	
}
