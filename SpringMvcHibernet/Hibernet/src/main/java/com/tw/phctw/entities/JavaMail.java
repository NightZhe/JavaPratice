package com.tw.phctw.entities;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class JavaMail {
	private String userName = "zerozhe588@gmail.com";
	private String password = "hvbmuntxihpahvau";
	private String customer = "zerozhe588@gmail.com";
	private String subject = "java maill test";
	private String text = "this is password";

	@SuppressWarnings("static-access")
	public void SendMail(String customer, String text) throws MessagingException {
//		連線設定
		Properties prop = new Properties();
//		設定連線方式smtp
		prop.setProperty("mail.transport.protocol", "smtp");
		// hos stmp gmail.com
		prop.setProperty("mail.host", "smtp.gmail.com");
		// host port 465
		prop.put("mail.smtp.port", "465");
		// 寄件者帳號驗證
		prop.put("mail.smtp.auth", "true");

		// 安全資料庫傳輸 ssl
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// 安全傳輸
		prop.put("mail.smtp.socketFactory.port", "465");

		// 顯示連線資訊
//		prop.put("mail.debug", "true");

		Auth auth = new Auth(userName, password);
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zerozhe588@gmail.com", "hvbmuntxihpahvau");
			}
		});

//		message
		MimeMessage message = new MimeMessage(session);

		try {
			InternetAddress sender = new InternetAddress(userName);
			message.setSender(sender);

//			收件者
			message.setRecipient(RecipientType.TO, new InternetAddress(customer));

//			標題
			message.setSubject(subject);

//			內容
			message.setContent(text, "text/html;charset=UTF-8");

//			Transport 將 Message 傳出

			Transport transport = session.getTransport();
			transport.send(message);
			transport.close();

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Auth extends Authenticator {
	private String userName;
	private String password;

	public Auth(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(userName, password);
		return super.getPasswordAuthentication();
	}

}
