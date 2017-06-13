package com.kysche.web.service.entity;

import com.ksyche.tools.dao.annotation.Column;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_car_comm")
public class CarComm {
 
 
	 /**
     * 描述: id     
     * 字段: id  BIGINT(19)  
     */
	@Column(name="id")
	private java.lang.Long id;
	
 
	 /**
     * 描述: carId     
     * 字段: car_id  BIGINT(19)  
     */
	@Column(name="car_id")
	private java.lang.Long carId;
	
 
	 /**
     * 描述: commId     
     * 字段: comm_id  BIGINT(19)  
     */
	@Column(name="comm_id")
	private java.lang.Long commId;
	
 

	public CarComm(){
	}
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
    
	public void setCarId(java.lang.Long carId) {
		this.carId = carId;
	}
	
	public java.lang.Long getCarId() {
		return this.carId;
	}
    
	public void setCommId(java.lang.Long commId) {
		this.commId = commId;
	}
	
	public java.lang.Long getCommId() {
		return this.commId;
	}
    
	
	
 
}

