package com.ksyche.tools.util.net.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class SimpleTrustManager implements X509TrustManager {
	
	SimpleTrustManager() {
		// 这里可以进行证书的初始化操作
	}

	// 检查客户端的可信任状态
	@Override
	public void checkClientTrusted(X509Certificate chain[], String authType) throws CertificateException {

	}

	// 检查服务器的可信任状态
	@Override
	public void checkServerTrusted(X509Certificate chain[], String authType) throws CertificateException {

	}

	// 返回接受的发行商数组
	@Override
	public X509Certificate[] getAcceptedIssuers() {

		return null;
	}
}
