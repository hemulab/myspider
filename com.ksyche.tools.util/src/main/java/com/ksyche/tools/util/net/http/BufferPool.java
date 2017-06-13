package com.ksyche.tools.util.net.http;


class BufferPool {

//	private TransferQueue<IOBuffer> bufferQueue = new LinkedTransferQueue<IOBuffer>();
//	private Object locker = new Object();
	private int currentSize;
	private int maxPoolSize;
	private int maxPackegSize;


	public BufferPool(int minPoolSize, int maxPoolSize, int maxPackegSize) {
		this.maxPoolSize = maxPoolSize;
		this.maxPackegSize = maxPackegSize;

//		for (int i = 0; i < minPoolSize; i++) {
//			bufferQueue.offer(IOBuffer.allocate(maxPackegSize));
//			currentSize++;
//		}
	}
//	
//	public IOBuffer get() throws Exception {
//		IOBuffer buf = bufferQueue.poll(1000 * 3, TimeUnit.MILLISECONDS);
//		if(buf == null) {
//			if(currentSize < maxPoolSize) {
//				synchronized (locker) {
//					if (currentSize < maxPoolSize) {
//						buf = IOBuffer.allocate(maxPackegSize);
//						currentSize++;
//					} else {
//						throw new Exception("io buffer is full");
//					}
//				}
//			} else {
//				throw new Exception("io buffer is full");
//			}
//		}
//
//		buf.reset();
//		return buf;
//	}
//
//	public void release(IOBuffer buf) {
//		if(buf != null) {
//			bufferQueue.offer(buf);
//		}
//	}
//
//	public int getCurrentSize() {
//		return currentSize;
//	}
	
	public IOBuffer get() throws Exception {
		return IOBuffer.allocate(maxPackegSize);
	}
	
	public void release(IOBuffer buf) {
		
	}
}
