package com.ksyche.tools.util.mail;

public class Email {
	
	private String receivers;
	private String subject;
	private String content;
	private int priority = 0;
	
	
	public Email() {
		
	}
	
	/**
	 * 邮件实体
	 * @param receivers 接收者(多个以逗号分隔)
	 * @param subject 邮件主题
	 * @param content 邮件内容(可以是html)
	 */
	public Email(String receivers, String subject, String content) {
		super();
		this.receivers = receivers;
		this.subject = subject;
		this.content = content;
	}
	
	/**
	 * 
	 * @param receivers 接收者(多个以逗号分隔)
	 * @param subject 邮件主题
	 * @param content 邮件内容(可以是html)
	 * @param priority 优先级
	 */
	public Email(String receivers, String subject, String content, int priority) {
		super();
		this.receivers = receivers;
		this.subject = subject;
		this.content = content;
		this.priority = priority;
	}

	public String getReceivers() {
		return receivers;
	}
	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
