package com.ksyche.tools.util.net.http;

import java.io.IOException;

class IOBuffer {

	private byte[] buffer;
	
	private int position;
	
	private int capacity;
	
	
	public static IOBuffer allocate(int capacity) {
		IOBuffer buffer = new IOBuffer();
		buffer.capacity = capacity;
		buffer.position = 0;
		buffer.buffer = new byte[capacity];
		
		return buffer;
	}
	
	private IOBuffer() {
	
	}

	public void put(byte b) throws IOException {
		if(position < capacity) {
			this.buffer[position] = b;
			position++;
		} else {
			throw new IOException("buffer over flow capacity:" + capacity);
		}
	}
	
	public void put(byte[] b) throws IOException {
		if((position + b.length) < capacity) {
			System.arraycopy(b, 0, this.buffer, position, b.length);
			position += b.length;
		} else {
			throw new IOException("buffer over flow capacity:" + capacity);
		}
	}
	
	public byte[] toByteArray() {
		byte[] buf = new byte[position];
		System.arraycopy(buffer, 0, buf, 0, position);
		return buf;
	}
	
	public void reset() {
		this.position = 0;
	}
	
	public void addPosition(int len) {
		this.position += len;
	}

	public int position() {
		return position;
	}

	public int capacity() {
		return capacity;
	}
	
	public void position(int position) {
		this.position = position;
	}
	
	public byte[] getBuffer() {
		return buffer;
	}
}
