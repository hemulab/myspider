package com.ksyche.tools.util.net.http;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
	
	private Map<String, String> headers = new HashMap<String, String>();
	
	private String statusLine;

	private byte[] body;
	
	
	public String getContent() throws Exception {
		if(body != null) {
			String encoding = Constant.DEFAULT_ENCODING;
			String contentType = headers.get("Content-Type");
			if(contentType!=null && contentType.indexOf("charset")>0 && !contentType.equalsIgnoreCase("text/html;charset=utf-8")) {
				encoding = contentType.substring(contentType.indexOf("charset=") + 8);
			}
			
			if(headers.containsKey("Content-Encoding") && headers.get("Content-Encoding").equalsIgnoreCase("gzip")) {
				return new String(GZip.unzip(body), encoding);
			} else {
				return new String(body, encoding);
			}
		}
		return null;
	}
	
	public void addHeader(String key, String value) {
		headers.put(key, value);
	}
	
	public void removeHeader(String key) {
		headers.remove(key);
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getStatusLine() {
		return statusLine;
	}

	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}
	
	public byte[] getBody() {
		return body;
	}
}
