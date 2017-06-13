package com.ksyche.tools.util.encrypt;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSAHelper {
	
	/*默认编码*/
	private static final String DEFAULT_ENCODING = "utf-8";
	
	private RSACipher cipher;
	private RSAKeyPair keyPair;
	
	private RSAHelper(byte[] publicKey, byte[] privateKey) throws Exception {
		if(publicKey==null && privateKey==null) {
			this.keyPair = new RSAKeyPair();
		} else {
			this.keyPair = new RSAKeyPair(publicKey, privateKey);
		}
		
		this.cipher = new RSACipher(this.keyPair);
	}
	
	/**
	 * 获取实例
	 * @param 密钥长度(默认为1024)
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws Exception
	 */
	public static RSAHelper getInstance() throws Exception{
		return new RSAHelper(null, null);
	}
	
	public static RSAHelper getInstance(String publicKey, String privateKey) throws Exception{
		return new RSAHelper(publicKey.getBytes(DEFAULT_ENCODING), privateKey.getBytes(DEFAULT_ENCODING));
	}
	
	public static RSAHelper getInstance(byte[] publicKey, byte[] privateKey) throws Exception{
		return new RSAHelper(publicKey, privateKey);
	}
	
	
	/**
	 * 私钥加密
	 * @param data 原文byte[]
	 * @return 密文
	 * @throws Exception
	 */
	public byte[] encryptByPrivateKey(byte[] data) throws Exception{
		return cipher.getPrivateEncrypt().doFinal(data);
	}
	
	/**
	 * 私钥解密
	 * @param data 密文byte[]
	 * @return 原文byte[]
	 * @throws Exception
	 */
	public byte[] decryptByPrivateKey(byte[] data) throws Exception{
		return cipher.getPrivateDecrypt().doFinal(data);
	}
	
	/**
	 * 公钥解密
	 * @param data 密文byte[]
	 * @param key 密钥byte[]
	 * @return 原文byte[]
	 * @throws Exception
	 */
	public byte[] decryptByPublicKey(byte[] data) throws Exception{
		return cipher.getPublicDecrypt().doFinal(data);
	}
	
	/**
	 * 公钥加密
	 * @param data 原文byte[]
	 * @param key 密钥byte[]
	 * @return 密文byte[]
	 * @throws Exception
	 */
	public byte[] encryptByPublicKey(byte[] data) throws Exception{
		return cipher.getPublicEncrypt().doFinal(data);
	}
	
	
	/**
	 * 私钥加密
	 * @param data 原文byte[]
	 * @return 密文
	 * @throws Exception
	 */
	public String encryptByPrivateKey(String data) throws Exception{
		return Base64.encrypt(encryptByPrivateKey(data.getBytes(DEFAULT_ENCODING)));
	}
	
	/**
	 * 私钥解密
	 * @param data 密文byte[]
	 * @return 原文byte[]
	 * @throws Exception
	 */
	public String decryptByPrivateKey(String data) throws Exception{
		byte[] src = decryptByPrivateKey(Base64.decrypt(data));
		return new String(src, DEFAULT_ENCODING);
	}
	
	/**
	 * 公钥加密
	 * @param data 原文byte[]
	 * @param key 密钥byte[]
	 * @return 密文byte[]
	 * @throws Exception
	 */
	public String encryptByPublicKey(String data) throws Exception{
		return Base64.encrypt(encryptByPublicKey(data.getBytes(DEFAULT_ENCODING)));
	}
	
	/**
	 * 公钥解密
	 * @param data 密文byte[]
	 * @param key 密钥byte[]
	 * @return 原文byte[]
	 * @throws Exception
	 */
	public String decryptByPublicKey(String data) throws Exception{
		byte[] src = decryptByPublicKey(Base64.decrypt(data));
		return new String(src, DEFAULT_ENCODING);
	}
	

	
	/**
	 * 获取公钥
	 * @param map 密钥对Map
	 * @return 公钥byte[]
	 */
	public byte[] getPublicKey(){
		return keyPair.getPublicKey().getEncoded();
	}
	
	/**
	 * 获取公钥
	 * @param map 密钥对Map
	 * @return String 公钥
	 */
	public String getStrPublicKey(){
		return Base64.encrypt(getPublicKey());
	}
	
	/**
	 * 获取私钥
	 * @param map 密钥对Map
	 * @return 私钥byte[]
	 */
	public byte[] getPrivateKey(){
		return keyPair.getPrivateKey().getEncoded();
	}
	
	/**
	 * 获取私钥
	 * @param map 密钥对Map
	 * @return String 私钥
	 */
	public String getStrPrivateKey(){
		return Base64.encrypt(getPrivateKey());
	}

	class RSACipher {
		private Cipher publicEncrypt;
		private Cipher privateEncrypt;
		private Cipher publicDecrypt;
		private Cipher privateDecrypt;
		
		public RSACipher(RSAKeyPair keyPair) throws Exception {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			this.publicEncrypt = Cipher.getInstance(kf.getAlgorithm());
			this.publicEncrypt.init(Cipher.ENCRYPT_MODE, keyPair.getPublicKey());
			this.publicDecrypt = Cipher.getInstance(kf.getAlgorithm());
			this.publicDecrypt.init(Cipher.DECRYPT_MODE, keyPair.getPublicKey());
			
			this.privateEncrypt = Cipher.getInstance(kf.getAlgorithm());
			this.privateEncrypt.init(Cipher.ENCRYPT_MODE, keyPair.getPrivateKey());
			this.privateDecrypt = Cipher.getInstance(kf.getAlgorithm());
			this.privateDecrypt.init(Cipher.DECRYPT_MODE, keyPair.getPrivateKey());
		}
		
		public Cipher getPublicEncrypt() {
			return publicEncrypt;
		}
		public void setPublicEncrypt(Cipher publicEncrypt) {
			this.publicEncrypt = publicEncrypt;
		}
		public Cipher getPrivateEncrypt() {
			return privateEncrypt;
		}
		public void setPrivateEncrypt(Cipher privateEncrypt) {
			this.privateEncrypt = privateEncrypt;
		}
		public Cipher getPublicDecrypt() {
			return publicDecrypt;
		}
		public void setPublicDecrypt(Cipher publicDecrypt) {
			this.publicDecrypt = publicDecrypt;
		}
		public Cipher getPrivateDecrypt() {
			return privateDecrypt;
		}
		public void setPrivateDecrypt(Cipher privateDecrypt) {
			this.privateDecrypt = privateDecrypt;
		}
	}
	
	class RSAKeyPair {
		private PublicKey publicKey;
		private PrivateKey privateKey;
		
		public RSAKeyPair() throws NoSuchAlgorithmException {
			super();

			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(1024);
			KeyPair keypair = keyPairGen.generateKeyPair();
			this.publicKey = keypair.getPublic();//公钥
			this.privateKey = keypair.getPrivate(); //私钥
		}
		
		public RSAKeyPair(byte[] publicKey, byte[] privateKey) throws Exception {
			super();
			
			KeyFactory kf = KeyFactory.getInstance("RSA");
			if(publicKey != null) {
				X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(publicKey);
				this.publicKey = kf.generatePublic(pubSpec);
			}
			if(privateKey != null) {
				X509EncodedKeySpec priSpec = new X509EncodedKeySpec(privateKey);
				this.privateKey = kf.generatePrivate(priSpec);
			}
		}
		
		public PublicKey getPublicKey() {
			return publicKey;
		}
		public PrivateKey getPrivateKey() {
			return privateKey;
		}
	}
}
