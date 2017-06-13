package com.ksyche.tools.util.net.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UDPClient {
	
	private static final Log logger = LogFactory.getLog(UDPClient.class);
	private static volatile UDPClient client = null;
	private static Object locker = new Object();
	
	private ByteBuffer sendBuffer = ByteBuffer.allocateDirect(1024 * 64);
	private String encode = "utf-8";
	private InetSocketAddress addr = null;
	private DatagramChannel channel = null;
	
	
	/**
	 * 获取UDPClient实例
	 */
	public static UDPClient getInstrance() throws IOException {
		return client;
	}
	
	/**
	 * 创建UDPClient实例
	 * @param ip udp服务ip
	 * @param port udp服务端口
	 * @param encode 编码
	 * @return
	 * @throws IOException 
	 */
	public static UDPClient createInstrance(String ip, int port, String encode) throws IOException {
		if(client == null) {
			synchronized (locker) {
				if(client == null) {
					client = new UDPClient();
					client.encode = encode;
					client.channel = DatagramChannel.open();
					client.addr = new InetSocketAddress(ip, port);
					client.channel.socket().setSendBufferSize(1024 * 1024);
					client.channel.connect(client.addr);
				}
			}
		}
		
		return client;
	}
	
	private UDPClient() {
		
	}
	
	public void close() throws IOException {
		channel.close();
	}

	/**
	 * 发送udp消息
	 * @param msg 消息
	 * @param encode 编码
	 * @throws Exception
	 */
	public void send(String msg, String encode) throws Exception {
		byte[] buf = msg.getBytes(encode);
		send(buf);
	}
	
	/**
	 * 发送udp消息
	 * @param msg 消息
	 * @throws IOException
	 */
	public void send(String msg) throws IOException {
		byte[] buf = msg.getBytes(encode);
		send(buf);
	}
	
	/**
	 * 发送udp消息
	 * @param buf 消息
	 * @throws IOException
	 */
	public void send(byte[] buf) throws IOException {
		if(channel.isOpen()) {
			synchronized (locker) {
				sendBuffer.clear();
				sendBuffer.put(buf);
				sendBuffer.flip();
				while(sendBuffer.hasRemaining()) {
					channel.write(sendBuffer);
				}
			}
		} else {
			logger.warn("udp client channel is close:" + addr.toString());
		}
	}
}
