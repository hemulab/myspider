package com.kysche.web.spider.service.enums;

public enum DistanceTypeEnum {

	Unkonw(1,"aa");
	
	private int type;
	
	private String name;
	
	private DistanceTypeEnum(int type,String name){
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	
}
