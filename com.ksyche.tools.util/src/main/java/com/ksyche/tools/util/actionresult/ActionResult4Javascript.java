package com.ksyche.tools.util.actionresult;

import javax.servlet.http.HttpServletResponse;

import com.bj58.wf.mvc.ActionResult;
import com.bj58.wf.mvc.BeatContext;


public class ActionResult4Javascript extends ActionResult {

	private static final String HTML_FRAME_HEAD = "<html><head><script type=\"text/javascript\">";
	private static final String HTML_FRAME_TAIL = "</script></head><body></body></html>";
	private String content;
	
	public String getContent() {
		return content;
	}


	public ActionResult4Javascript(String content){
		this.content=content;
	}
	
	public ActionResult4Javascript(String content, String redirectURL){
		this.content = content + ";window.location.href='" + redirectURL + "';";
	}
	

	@Override
	public void render(BeatContext beat) throws Exception {
		StringBuilder html = new StringBuilder();
		html.append(HTML_FRAME_HEAD);
		html.append(content);
		html.append(HTML_FRAME_TAIL);
		
		HttpServletResponse response = beat.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(html.toString());
		response.flushBuffer();
	}

}
