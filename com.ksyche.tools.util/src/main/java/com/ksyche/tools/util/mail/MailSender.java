package com.ksyche.tools.util.mail;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ksyche.tools.util.jsr166.LinkedTransferQueue;
import com.ksyche.tools.util.jsr166.TransferQueue;

public class MailSender {

	private static Thread sender;
	private static final TransferQueue<Email> queue = new LinkedTransferQueue<Email>();
	private static final Object locker = new Object();
	private static final Log log = LogFactory.getLog(MailSender.class);

	private String fromUser = "test"; // 发件人
	private String passWord = "passwad";
	private String smtpHost = "smtp.exmail.qq.com";
	private int smtpPort = 25;
	private Session session;
	private Transport transport;
	private int sendInterval = 0;
	private int maxQueueLen = 10000;

	
	private MailSender() {

	}

	/**
	 * 获取MailSender实例
	 * @param fromUser 发送者
	 * @param passWord 密码
	 * @param smtpHost stmp地址
	 * @param smtpPort stmp端口
	 * @param sendInterval 每封邮件发送时间间隔(毫秒)
	 * @param maxQueueLen 最大发送队列长度
	 * @return
	 * @throws Exception
	 */
	public static MailSender getInstance(String fromUser, 
			String passWord, 
			String smtpHost, 
			int smtpPort, 
			int sendInterval,
			int maxQueueLen) throws Exception {
		MailSender sender = new MailSender();
		sender.fromUser = fromUser;
		sender.smtpHost = smtpHost;
		sender.smtpPort = smtpPort;
		sender.passWord = passWord;
		sender.sendInterval = sendInterval;
		sender.maxQueueLen = maxQueueLen;
		sender.init();

		return sender;
	}

	/**
	 * 获取MailSender实例
	 * @return
	 * @throws Exception
	 */
	public static MailSender getInstance() throws Exception {
		MailSender sender = new MailSender();
		sender.init();

		return sender;
	}

	/**
	 * 发邮件(异步)
	 * @param email
	 * @throws Exception 
	 */
	public void send(Email email) throws Exception {
		if(queue.size() > maxQueueLen) {
			throw new Exception("MailSender 发送队列过长(maxQueueLen:" + maxQueueLen + ")");
		}
		
		queue.offer(email);
	}

	/**
	 * 发邮件(同步)
	 * @param email
	 * @throws Exception
	 */
	public void syncSend(Email email) throws Exception {
		MimeMessage mimeMsg = new MimeMessage(session);
		mimeMsg.setFrom(new InternetAddress(MimeUtility.encodeText("达人工") + "<" + fromUser + ">"));
		mimeMsg.setSubject(email.getSubject());
		mimeMsg.setContent(email.getContent(), "text/html;charset=utf-8");
		mimeMsg.setSentDate(new Date());
		mimeMsg.setHeader("Content-Type", "text/html;charset=utf-8");
//		mimeMsg.setHeader("Content-Transfer-Encoding", "quoted-printable");
		mimeMsg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(email.getReceivers()));

		if(transport.isConnected()) {
			transport.sendMessage(mimeMsg, mimeMsg.getAllRecipients());
		} else {
			transport.close();
			transport = session.getTransport("smtp");
			transport.connect(smtpHost, fromUser, passWord);
			transport.sendMessage(mimeMsg, mimeMsg.getAllRecipients());
		}
	}
	
	/**
	 * 关闭链接
	 * @throws MessagingException
	 */
	public void close() throws MessagingException {
		transport.close();
	}
	
	/**
	 * 初始化MailSender
	 * @throws Exception
	 */
	private void init() throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort + "");
		props.put("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(props);
		
		initSendThread();

		try {
			transport = session.getTransport("smtp");
			transport.connect(smtpHost, fromUser, passWord);
		} catch (Exception e) {
			log.error("conn to stmp server error", e);
		}
	}
	
	/**
	 * 初始化发送线程
	 */
	private void initSendThread() {
		if (sender == null) {
			synchronized (locker) {
				if (sender == null) {
					sender = new Thread(new Runnable() {
						@Override
						public void run() {
							while(true) {
								try {
									Email email = queue.poll(60, TimeUnit.SECONDS);
									if(email != null) {
										log.info("send email:" + email.getReceivers());
										syncSend(email);
									}
								} catch (Exception e) {
									log.error("send email error", e);
								} finally {
									if (sendInterval > 0) {
										try {
											Thread.sleep(sendInterval);
										} catch (InterruptedException e) {
											log.error("send email error", e);
										}
									}
								}
							}
						}
					});
				}
			}
			
			sender.setDaemon(true);
			sender.setName("drg_mail_sender");
			sender.start();
		}
	}
	
}
