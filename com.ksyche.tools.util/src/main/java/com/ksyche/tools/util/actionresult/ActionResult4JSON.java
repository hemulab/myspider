package com.ksyche.tools.util.actionresult;

import javax.servlet.http.HttpServletResponse;

import com.bj58.wf.mvc.ActionResult;
import com.bj58.wf.mvc.BeatContext;


public class ActionResult4JSON extends ActionResult {

	private String content;
	
	public String getContent() {
		return content;
	}


	public ActionResult4JSON(String content){
		this.content=content;
	}
	

	@Override
	public void render(BeatContext beat) throws Exception {
		HttpServletResponse response = beat.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(content);
		response.flushBuffer();
	}

}
