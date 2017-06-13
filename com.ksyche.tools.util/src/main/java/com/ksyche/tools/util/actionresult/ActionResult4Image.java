package com.ksyche.tools.util.actionresult;

import javax.servlet.http.HttpServletResponse;

import com.bj58.wf.mvc.ActionResult;
import com.bj58.wf.mvc.BeatContext;

public class ActionResult4Image extends ActionResult {

	private byte[] buf;
	
	public ActionResult4Image(byte[] buf){
		this.buf = buf;
	}
	
	@Override
	public void render(BeatContext beat) throws Exception {
		HttpServletResponse response = beat.getResponse();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);
		response.setContentType("image/jpeg");
		response.getOutputStream().write(buf);
		response.getOutputStream().flush();
	}
}
