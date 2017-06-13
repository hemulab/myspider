package com.ksyche.tools.util.encrypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESHelper {
	
	private static final String DEFAULT_ENCODE = "utf-8";
	
	private Cipher encryptCipher;
	private Cipher decryptCipher;
	
	private DESHelper(String password) throws Exception {
		if(password.length() < 8) {
			throw new Exception("密钥长度必须8位以上");
		}
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secureKey = keyFactory.generateSecret(desKey);
		SecureRandom random = new SecureRandom();
		
		// Cipher对象实际完成加密操作
		this.encryptCipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		this.encryptCipher.init(Cipher.ENCRYPT_MODE, secureKey, random);
		
		this.decryptCipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		this.decryptCipher.init(Cipher.DECRYPT_MODE, secureKey, random);
	}
	
	public static DESHelper getInstrance(String password) throws Exception {
		return new DESHelper(password);
	}

	/**
	 * 加密
	 * @param buf
	 * @return
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] buf) throws Exception {
		return encryptCipher.doFinal(buf);
	}

	/**
	 * 解密
	 * @param buf
	 * @return
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] buf) throws Exception {
		return decryptCipher.doFinal(buf);
	}

	/**
	 * 加密
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String src) throws Exception {
		byte[] srcBuf = src.getBytes(DEFAULT_ENCODE);
		byte[] destBuf = encrypt(srcBuf);
		return Base64.encrypt(destBuf);
	}

	/**
	 * 解密
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String src) throws Exception {
		byte[] srcBuf = Base64.decrypt(src);
		byte[] destBuf = decrypt(srcBuf);
		return new String(destBuf, DEFAULT_ENCODE);
	}
}
