package com.revature.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail
{
	public static void sendEmail(String email, String temporaryPassword ) {
	      // Recipient's email ID needs to be mentioned.
	      String to = email;//change accordingly

	      // Sender's email ID needs to be mentioned
	      String from = "noreply@revaturereimbursement.com";//change accordingly
	      final String username = "huriel@logisticnation.com";//change accordingly
	      final String password = "revature";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "mail.logisticnation.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "25");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Confirm your account");

	         // Now set the actual message
	         message.setText("Hello, Welcome to RevatureReimbursement.  Follow the link to activate your account: \nPassword: temporaryPassword\n "
	         		+ "<a href='http//localhost:8082/RevatureReimbursement/#/login'>RevatureReimbursement</a>");

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	   }
}
