package com.ksyche.tools.util.net.http;

public enum HttpMethod {
	
	GET(1),

	POST(2),

	DELETE(3),

	PUT(4),

	HEAD(5);

	private final int value;

	public int getValue() {
		return value;
	}

	private HttpMethod(int value) {
		this.value = value;
	}
}