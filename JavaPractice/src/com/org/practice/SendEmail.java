package com.org.practice;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

	public static void main(String[] args) {
		Properties properties = new Properties();
		// Setup mail server
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.starttls.required", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		String authuerid = "donthu04";
		String pass = "donthu_123";
		String fromEmail = "anudeepdonthu@gmail.com";
		String toEmail = "donthu04@gail.com";
		String subject = "I am email from Java Program";
		String messgae = "I am message from Java Program";

		Session session = Session.getDefaultInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(authuerid, pass);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject);
			message.setText(messgae);
			Transport.send(message);
			System.out.println("Mail sent successfully..");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}