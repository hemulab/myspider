package com.kysche.web.spider.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

/**
 * 是否需要更换项目的记录 有更改的才在此表中记录
 * @author mydog741
 *
 */
@Table(name="t_change_maintenace_jd")
public class ChangeMaintenaceJD {
	
	@Id
	private long id;
	
	@Column(name="car_mintenace_id")
	private long carMintenaceId;
	
	@Column(name="distance_name")
	private long distanceName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCarMintenaceId() {
		return carMintenaceId;
	}

	public void setCarMintenaceId(long carMintenaceId) {
		this.carMintenaceId = carMintenaceId;
	}

	public long getDistanceName() {
		return distanceName;
	}

	public void setDistanceName(long distanceName) {
		this.distanceName = distanceName;
	}

	

}
