package com.tha103.artion.member.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberEmailutil {
	
	
	
	public void sendRestMail(String userEmail, String token,String url) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");//Gmail身分驗證，必須設置true
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("artionhope@gmail.com", "yqotrsrhicrilbwy");
			}
		});
	     try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("artionhope@gmail.com"));//寄件者
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail)); //收件者
	            message.setSubject("Artion 忘記密碼信-系統信件-請勿回覆"); //信件主旨
	            String alink= url+"/artion/memberRestPassword?email="+userEmail+"&token=" + token; 
	            message.setText("Artion用戶您好:請點選下方連結重新設定您的會員密碼。\n"+ alink);//信件內文
	            Transport.send(message);//發送email
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	}
}
