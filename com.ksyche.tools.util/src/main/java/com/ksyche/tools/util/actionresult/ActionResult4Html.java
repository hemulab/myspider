package com.ksyche.tools.util.actionresult;

import javax.servlet.http.HttpServletResponse;

import com.bj58.wf.mvc.ActionResult;
import com.bj58.wf.mvc.BeatContext;

public class ActionResult4Html extends ActionResult {
	
	private String content;
	private int responseStatus = 200;
	
	
	public static ActionResult show(String html) {
		return new ActionResult4Html(html, 200);	
	}
	
	public static ActionResult show(String html, int responseStatus) {
		return new ActionResult4Html(html, responseStatus);	
	}
	
	public ActionResult4Html(String content, int responseStatus){
		this.content = content;
		this.responseStatus = responseStatus;
	}
	

	@Override
	public void render(BeatContext beat) throws Exception {
		HttpServletResponse response = beat.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setStatus(responseStatus);
		response.getWriter().print(content);
		response.flushBuffer();
	}
}
