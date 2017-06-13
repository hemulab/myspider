package com.ksyche.tools.util.net.http;

import java.io.IOException;

public class HttpClient {
	
	private BufferPool bufPool;
	
	private HttpClient(int minBufPoolSize,
			int maxBufPoolSize,
			int maxPackegSize) {
		bufPool = new BufferPool(minBufPoolSize, maxBufPoolSize, maxPackegSize);
	}
	
	public static HttpClient getInstance() {
		return new HttpClient(Constant.MIN_BUFFER_POOL_SIZE,
				Constant.MAX_BUFFER_POOL_SIZE,
				Constant.MAX_PACKEG_SIZE);
	}
	
	public static HttpClient getInstance(int minBufPoolSize,
			int maxBufPoolSize,
			int maxPackegSize) {
		return new HttpClient(minBufPoolSize, maxBufPoolSize, maxPackegSize);
	}
	
	
	
	public HttpResponse get(String url) throws Exception {
		return get(url, Constant.READ_TIMEOUT);
	}
	
	public HttpResponse get(String url, int timeout) throws Exception {
		HttpRequest request = new HttpRequest(url);
		return request(request, timeout);
	}
	
	public HttpResponse post(String url, String ... params) throws Exception {
		return post(url, Constant.READ_TIMEOUT, params);
	}
	
	public HttpResponse post(String url, int timeout, String ... params) throws Exception {
		StringBuilder body = new StringBuilder();
		for(int i=0; i<params.length; i+=2) {
			if(i != 0) {
				body.append("&");
			}
			body.append(params[i]);
			body.append("=");
			body.append(params[i+1]);
		}
		
		HttpRequest request = new HttpRequest(url);
		request.setMethod(HttpMethod.POST);
		request.setContent(body.toString().getBytes(Constant.DEFAULT_ENCODING));
		request.setContentType("application/x-www-form-urlencoded");
		return request(request, timeout);
	}
	
	public HttpResponse request(HttpRequest request, int timeout) throws Exception {
		HttpConnection conn = null;
		try {
			conn = new HttpConnection(request, timeout, bufPool);
			conn.send(request.getHeaderBuf(), request.getContent());
			return conn.receive();
		} catch (IOException e) {
			throw e;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public HttpResponse request(HttpRequest request, int timeout, byte[] ... bufs) throws Exception {
		HttpConnection conn = null;
		try {
			conn = new HttpConnection(request, timeout, bufPool);
			conn.send(bufs);
			return conn.receive();
		} catch (IOException e) {
			throw e;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
