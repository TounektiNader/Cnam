package com.cnam.utils;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {


public static void	envoyerEmail(String recepteur,String subject,String object) throws MessagingException{
	
	
	String from = "AdminCNAM";// change accordingly
	final String username = "cnam20017@gmail.com";// change accordingly
	final String password = "cnam20172017";// change accordingly
	// Assuming you are sending email through relay.jangosmtp.net
	String host = "smtp.gmail.com";
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", "587");
	// Get the Session object.


	
	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(username, password);
	    }
	});
	// Create a default MimeMessage object.
	javax.mail.Message message = new MimeMessage(session);
	// Set From: header field of the header.
	message.setFrom(new InternetAddress(from));
	// Set To: header field of the header.
	
	message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(recepteur));
	// Set Subject: header field
	message.setSubject(subject);
	// Now set the actual message
	//message.setText(reponse);
	  BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(object);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
		multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
        
         // Send the complete message parts
         message.setContent(multipart);
	// Send message
	Transport.send(message);
	System.out.println("Sent message successfully....");
}

public static void main(String []args){
	try {
		envoyerEmail("mouradbounasri@gmail.com", "sss", "sddssds");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
