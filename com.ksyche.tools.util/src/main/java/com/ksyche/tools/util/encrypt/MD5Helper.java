package com.ksyche.tools.util.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {
	
	private static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	public static String getMD5(String source) throws Exception {
		byte[] sourceByte = source.getBytes("utf-8");
		return getMD5(sourceByte);
	}
	
	public static String getMD5(String source, String encoding) throws Exception {
		byte[] sourceByte = source.getBytes(encoding);
		return getMD5(sourceByte);
	}
	
	public static String getMD5(byte[] buf) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(buf);
		byte tmp[] = md.digest();
		char str[] = new char[16 * 2];
		int k = 0;
		for (int i = 0; i < 16; i++) {
			byte byte0 = tmp[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}
}
