package com.ksyche.tools.util.net.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class HttpConnection {
	
	private static final Log log = LogFactory.getLog(HttpConnection.class);
	private static SSLContext sslCTX;
	
	private Socket socket;
	private BufferedInputStream inStream;
	private BufferedOutputStream outStream;
	private BufferPool bufPool;
	
	static {
		try {
			X509TrustManager xtm = new SimpleTrustManager();
			TrustManager tm[] = { xtm };
			sslCTX = SSLContext.getInstance("SSL");
			sslCTX.init(null, tm, null);  
		} catch (Exception e) {
			log.error("init SSLContext error", e);
		}
	}

	public HttpConnection(HttpRequest request, int timeout, BufferPool bufPool) throws Exception {
		this.socket = createSocket(request.getUrl());
		this.socket.setSoTimeout(timeout);
		this.socket.setTcpNoDelay(true);
		this.socket.setSendBufferSize(1024 * 128);
		this.socket.setReceiveBufferSize(1024 * 32);
		SocketAddress address = new InetSocketAddress(InetAddress.getByName(request.getHost()), request.getPort());
		this.socket.connect(address, timeout);

		// wrap streams
		this.inStream = new BufferedInputStream(socket.getInputStream());
		this.outStream = new BufferedOutputStream(socket.getOutputStream());
		this.bufPool = bufPool;
	}

	public HttpResponse receive() throws Exception {
		HttpResponse response  = new HttpResponse();
		IOBuffer headBuf = null;
		IOBuffer bodyBuf = null;
		try {
			headBuf = bufPool.get();
			readHeader(headBuf, response);
			
			bodyBuf = bufPool.get();
			readBody(headBuf, bodyBuf, response);
		} catch (Exception e) {
			throw e;
		} finally {
			bufPool.release(headBuf);
			bufPool.release(bodyBuf);
		}

		return response;
	}
	
	public void send(byte[] ... bufs) throws IOException {
		for(byte[] buf : bufs) {
			if(buf != null) {
				outStream.write(buf);
			}
		}
		outStream.flush();
	}

	public void close() throws IOException {
		if (inStream != null) {
			try {
				inStream.close();
				inStream = null;
			} catch (IOException ex) {
				throw ex;
			}
		}

		if (outStream != null) {
			try {
				outStream.close();
				outStream = null;
			} catch (IOException ex) {
				throw ex;
			}
		}

		if (socket != null) {
			try {
				socket.close();
				socket = null;
			} catch (IOException ex) {
				throw ex;
			}
		}
	}
	
	private int readHeader(IOBuffer headBuf, HttpResponse response) throws IOException {
		boolean firstLine = true;
		int len = 0;
		String line;
		
		while((line=readLine(headBuf)) != null) {
			len += line.length();
			if(firstLine) {
				response.setStatusLine(line);
				firstLine = false;
			} else {
				String[] kv = line.split(":");
				if(kv.length == 2) {
					response.addHeader(kv[0].trim(), kv[1].trim());
				}
			}
		}
		
		return len;
	}
	
	private int readBody(IOBuffer headBuf, IOBuffer bodyBuf, HttpResponse response) throws IOException {
		String value = response.getHeaders().get("Content-Length");
		String chunk = response.getHeaders().get("Transfer-Encoding"); //chunked
		int len = 0;
		
		//System.out.println("------------------------Content-Length:" + value);
		
		if(chunk!=null && chunk.equalsIgnoreCase("chunked")) {
			String line;
			while((line=readLine(headBuf)) != null) { //read chunk_head
				int chunkLen = Integer.parseInt(line, 16);
				if(chunkLen==0) {
					break;
				}
				
				len += chunkLen;
				int off = 0;
				int count = 0;
				while((chunkLen-off)>0 && count!=-1) {
					count = inStream.read(bodyBuf.getBuffer(), bodyBuf.position(), chunkLen-off);
					bodyBuf.addPosition(count);
					off += count;
				}
				readLine(headBuf);
			}
			response.setBody(bodyBuf.toByteArray());
		} else if(value != null) { //content-length
			len = Integer.parseInt(value);
			int off = 0;
			int count = 0;
			while((len-off)>0 && count!=-1) {
				count = inStream.read(bodyBuf.getBuffer(), bodyBuf.position(), len-off);
				bodyBuf.addPosition(count);
				off += count;
			}
			response.setBody(bodyBuf.toByteArray());
		} else {
			int count = 0;
			while((count=inStream.read()) != -1) {
				bodyBuf.put((byte)count);
				len++;
			}
			response.setBody(bodyBuf.toByteArray());
		}
		
		return len;
	}
	
	private String readLine(IOBuffer buf) throws IOException {
		byte last = 0;
		int b = 0;
		
		buf.reset();
		while (b != -1) {
			b = inStream.read();
			buf.put((byte)b);
			if(last=='\r' && b=='\n') {
				if(buf.position() > 2) {
					buf.addPosition(-2);
					String line = new String(buf.toByteArray(), Constant.DEFAULT_ENCODING);
					return line;
				} else {
					return null;
				}
			}
			last = (byte) b;
		}
		return null;
	}
	
	private Socket createSocket(String url) throws Exception {
		Socket sock = null;
		if(url.startsWith("https")) {
			sock = sslCTX.getSocketFactory().createSocket(); 
		} else {
			sock = new Socket();
		}
		return sock;
	}
}
