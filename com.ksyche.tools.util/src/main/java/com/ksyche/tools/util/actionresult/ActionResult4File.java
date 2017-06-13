package com.ksyche.tools.util.actionresult;

import javax.servlet.http.HttpServletResponse;

import com.bj58.wf.mvc.ActionResult;
import com.bj58.wf.mvc.BeatContext;

/**
 * 
 * @author Wang Lianbin
 * @date 2014-3-7 上午11:43:36
 */
public class ActionResult4File extends ActionResult {

	private byte[] buf;
	private String fileName;
	private ContentType contentType;

	public ActionResult4File(byte[] buf, String fileName, ContentType contentType) {
		super();
		this.buf = buf;
		this.fileName = fileName;
		this.contentType = contentType;
	}

	@Override
	public void render(BeatContext beat) throws Exception {
		HttpServletResponse response = beat.getResponse();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");

		response.setHeader("Content-Disposition", "attachment;filename = " + fileName);
		response.setDateHeader("Expires", -1);
		response.setContentType(contentType.value());
		response.setContentLength(buf.length);

		response.getOutputStream().write(buf);
		response.getOutputStream().flush();
	}

	public static enum ContentType {
		Excel("application/vnd.ms-excel"),
		Other("application/octet-stream");

		private String value;

		private ContentType(String value) {
			this.value = value;
		}

		String value() {
			return value;
		}

	}

}
