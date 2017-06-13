package com.ksyche.tools.util.net.http;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpRequest {

	private HttpMethod method = HttpMethod.GET;
	
	private Map<String, String> headers = new HashMap<String, String>();

	private byte[] content;

	private String url;

	private String host;
	
	private int port;

	private String path;
	
	private String contentType = "text/html";
	
	
	public HttpRequest(String url) throws Exception {
		super();
		this.setUrl(url);
	}
	

	public HttpRequest(HttpMethod method, byte[] content, String url) throws Exception {
		super();
		this.setMethod(method);
		this.setContent(content);
		this.setUrl(url);
	}

	public void addHeader(String key, String value) {
		headers.put(key, value);
	}
	
	public void removeHeader(String key) {
		headers.remove(key);
	}
	
	public void setUrl(String url) throws Exception {
		if(!url.startsWith("http")) {
			throw new Exception("url must start with http");
		}
		
		this.url = url;

		URL tempUrl = new URL(url);
		this.host = tempUrl.getHost();
		if (tempUrl.getPath() == null || tempUrl.getPath().equalsIgnoreCase("")) {
			this.path = "/";
		} else {
			if(tempUrl.getQuery() != null) {
				this.path = tempUrl.getPath() + "?" + tempUrl.getQuery();
			} else {
				this.path = tempUrl.getPath();
			}
		}
		if(url.startsWith("https")) {
			this.port = Constant.HTTPS_PORT;
		} else {
			this.port = tempUrl.getPort() == -1 ? 80 : tempUrl.getPort();
		}
	}
	
	public byte[] getHeaderBuf() throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		sb.append(this.method.toString());
		sb.append(" ");
		sb.append(this.path);
		sb.append(" HTTP/1.1\r\n");
		
		sb.append("Content-Type: ");
		sb.append(this.contentType);
		sb.append("\r\n");

		sb.append("Host: ");
		sb.append(this.host);
		sb.append("\r\n");

		sb.append("Connection: Keep-Alive\r\n");
		sb.append("Accept-Encoding: gzip, deflate\r\n");
		sb.append("Cache-Control: no-cache\r\n");

		if (this.content != null) {
			sb.append("Content-Length: ");
			sb.append(this.content.length);
			sb.append("\r\n");
		} else {
			sb.append("Content-Length: 0\r\n");
		}

		Iterator<Entry<String, String>> it = this.headers.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			sb.append(entry.getKey());
			sb.append(": ");
			sb.append(entry.getValue());
			sb.append("\r\n");
		}
		sb.append("\r\n");

		return sb.toString().getBytes(Constant.DEFAULT_ENCODING);
	}
	
	public HttpMethod getMethod() {
		return method;
	}

	public byte[] getContent() {
		return content;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public String getPath() {
		return path;
	}

	public String getHost() {
		return host;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getPort() {
		return port;
	}
}
