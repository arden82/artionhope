package com.tha103.artion.promoCode.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PromocoEmailutil {

	public void sendRestMail(String userEmail, String proCodeCode, String url) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");// Gmail身分驗證，必須設置true
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("artionhope@gmail.com", "yqotrsrhicrilbwy");
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("artionhope@gmail.com"));// 寄件者
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail)); // 收件者
			message.setSubject("Artion 折扣碼發送信-系統信件-請勿回覆"); // 信件主旨
//			String alink = url + "/artion/memberRestPassword?email=" + userEmail + "&promocode=" + proCodeId;
			message.setText("Artion用戶您好:本期最新優惠碼，立馬去逛逛吧 !。\n" + "優惠碼為：" + proCodeCode);// 信件內文
			Transport.send(message);// 發送email
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public void sendPromoCodeEmail(String userEmail, String proCodeCode, String url) {
		sendRestMail(userEmail, proCodeCode, url);
	}

}
