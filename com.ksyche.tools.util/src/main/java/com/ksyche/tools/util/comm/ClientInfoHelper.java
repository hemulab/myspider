package com.ksyche.tools.util.comm;

import com.bj58.wf.mvc.BeatContext;

public class ClientInfoHelper {

	/**
	 * 获取客户端ip
	 * @param beat
	 * @return
	 */
	public static String getClientIP(BeatContext beat) {
		String ip = beat.getRequest().getHeader("X-Real-IP");
		if(ip==null || ip.equals("")) {
			ip = beat.getRequest().getRemoteAddr();
		}

		return ip;
	}
}
