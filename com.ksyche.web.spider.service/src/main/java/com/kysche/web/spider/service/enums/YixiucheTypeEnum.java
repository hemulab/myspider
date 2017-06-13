package com.kysche.web.spider.service.enums;

public enum YixiucheTypeEnum {
	original(1,"原厂"),
	highly_active(2,"高效"),
	standard(3,"标准"),
	economical(4,"经济");
	YixiucheTypeEnum(int type,String name){
		this.type = type;
		this.name = name;
	}
	private int type;
	private String name;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
