package com.kysche.web.spider.service.entity;

import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

/**
 * 保养项目 京东
 * @author mydog741
 *
 */
@Table(name="t_maintenance_item_jd")
public class MaintenanceItemJD {

	@Id
	private long id;
	
	private String name;

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
	
	
	
}
