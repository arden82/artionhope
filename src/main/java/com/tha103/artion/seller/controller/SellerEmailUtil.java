	package com.tha103.artion.seller.controller;
	
	import java.util.Properties;
	import javax.mail.*;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	
	public class SellerEmailUtil {
	
		public void sendRestMail(String selAccount, String url) {
		    String generatedCode = VerificationCodeGenerator.generateVerificationCode(6);

		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true"); // Gmail身分驗證，必須設置true
		    props.put("mail.smtp.port", "465");
	
		    Session session = Session.getDefaultInstance(props, new Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication("artionhope@gmail.com", "yqotrsrhicrilbwy");
		        }
		    });
		    try {
		        MimeMessage message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("artionhope@gmail.com")); // 寄件者
		        message.addRecipient(Message.RecipientType.TO, new InternetAddress(selAccount)); // 收件者
		        message.setSubject("Artion 忘記密碼信-系統信件-請勿回覆"); // 信件主旨
		        String alink = url + "/seller/selResetPassword?email=" + selAccount + "&verificationCode=" + generatedCode + "&source=email";
		        message.setText("Artion廠商您好: 請點選下方連結輸入驗證碼，並重新設置您的廠商密碼。驗證碼：" + generatedCode + "\n" + alink);
		        Transport.send(message); // 发送email
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
		}
	
	    public void sendResetPasswordEmail(String selAccount, String resetUrl) {
	        sendRestMail(selAccount, resetUrl);
	    }
	
	}
	