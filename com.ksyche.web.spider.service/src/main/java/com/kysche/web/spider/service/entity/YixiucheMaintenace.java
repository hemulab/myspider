package com.kysche.web.spider.service.entity;

import com.ksyche.tools.dao.annotation.Id;
import com.ksyche.tools.dao.annotation.Table;

@Table(name="t_yixiuche_maintenance")
public class YixiucheMaintenace {
	@Id
	private long id;
	//页面显示内容
	private String brand;//品牌名称
	private String series;//车系名称
	private String model;//车型名称（没有年款）
	private String modelName;//车型全名
	//url内容
	private String brandInfo;//品牌urlInfo
	private String seriesInfo;//车系urlInfo
	private String modelInfo;//车型urlInfo
	private String url;//原始页面URL
	
	//重点内容
	private String serviceName;//服务项目
	private double servicePriceMin;//工时价格最小
	private double servicePriceMax;//工时价格最大
	private String accessoriesName;//配件名称
	private double accessoriesPrice;//配件价格
	private int accessoriesCount;//需要配件个数
	
	//查询筛选条件
	private long modelid;//车型库关联
	private int distance;//里程数
	//@see YixiucheTypeEnum
	private int type;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getServicePriceMin() {
		return servicePriceMin;
	}

	public void setServicePriceMin(double servicePriceMin) {
		this.servicePriceMin = servicePriceMin;
	}

	public double getServicePriceMax() {
		return servicePriceMax;
	}

	public void setServicePriceMax(double servicePriceMax) {
		this.servicePriceMax = servicePriceMax;
	}

	public String getAccessoriesName() {
		return accessoriesName;
	}

	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}

	public double getAccessoriesPrice() {
		return accessoriesPrice;
	}

	public void setAccessoriesPrice(double accessoriesPrice) {
		this.accessoriesPrice = accessoriesPrice;
	}

	public int getAccessoriesCount() {
		return accessoriesCount;
	}

	public void setAccessoriesCount(int accessoriesCount) {
		this.accessoriesCount = accessoriesCount;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(String brandInfo) {
		this.brandInfo = brandInfo;
	}

	public String getSeriesInfo() {
		return seriesInfo;
	}

	public void setSeriesInfo(String seriesInfo) {
		this.seriesInfo = seriesInfo;
	}

	public String getModelInfo() {
		return modelInfo;
	}

	public void setModelInfo(String modelInfo) {
		this.modelInfo = modelInfo;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public long getModelid() {
		return modelid;
	}

	public void setModelid(long modelid) {
		this.modelid = modelid;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
