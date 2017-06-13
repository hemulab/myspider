package com.ksyche.tools.util.net.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZip {

	public static byte[] zip(byte[] buf) throws Exception {
		ByteArrayOutputStream baos = null;
		GZIPOutputStream gos = null;
		try {
			baos = new ByteArrayOutputStream();
			gos = new GZIPOutputStream(baos);
			gos.write(buf);
			gos.finish();
			gos.flush();
			
			return baos.toByteArray();
		} catch (Exception e) {
			throw e;
		} finally {
			if(gos != null) {
				gos.close();
			}
		}
	}

	public static byte[] unzip(byte[] buf) throws Exception {
		ByteArrayInputStream bais = null;
		GZIPInputStream gis = null;
		ByteArrayOutputStream baos = null;
		
		try {
			bais = new ByteArrayInputStream(buf);
			gis = new GZIPInputStream(bais);
			baos = new ByteArrayOutputStream();
			
			byte[] tmp = new byte[1024];
			int count = 0;
			count = gis.read(tmp);
			while(count != -1) {
				baos.write(tmp, 0, count);
				count = gis.read(tmp);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			throw e;
		} finally {
			if(gis != null) {
				gis.close();
			}
		}
	}

}
