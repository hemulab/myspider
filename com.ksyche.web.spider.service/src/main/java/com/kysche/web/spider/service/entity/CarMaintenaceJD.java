package com.kysche.web.spider.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

/**
 * 车辆和报销的关系
 * @author mydog741
 *
 */
@Table(name="t_car_maintenace_jd")
public class CarMaintenaceJD {
	
	@Id
	private long id;
	
	@Column(name="car_id")
	private long carId;
	
	@Column(name="maintenace_id")
	private long maintenaceId;
	
	private double count;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public long getMaintenaceId() {
		return maintenaceId;
	}

	public void setMaintenaceId(long maintenaceId) {
		this.maintenaceId = maintenaceId;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}
	

}
