package com.ksyche.web.spider.vo;

import java.util.List;

import com.kysche.web.spider.service.entity.BaiduWeixiuEntity;

public class BaiduResultList {

	private int status;
	
	private String message;
	
	private int total;
	
	private List<BaiduWeixiuEntity> results;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotal() {
		return total;
	}

	public List<BaiduWeixiuEntity> getResults() {
		return results;
	}

	public void setResults(List<BaiduWeixiuEntity> results) {
		this.results = results;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	
	
}
