package easyclean.sendmail.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

import easyclean.sendmail.dto.Messages;
@Component
public class SendMessageUtilImpl implements SendMessageUtilService{

	
	final String username = "rafcasto@gmail.com";
	final String password = "Gerardo88";

	@Override
	public void sendMessage(Messages message) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(prop,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		
		try{
			Message msg = new MimeMessage(session);
			Multipart mp = new MimeMultipart();
			msg.setFrom(new InternetAddress(message.getFrom(), "EasyClean"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(message.getTo(), "Dear "+message.getEmployee().getFullName() ));
			msg.setSubject(message.getSubject());
			
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(message.getMessage(), "text/html");
			mp.addBodyPart(htmlPart);
			msg.setContent(mp);
			Transport.send(msg);
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}

	@Override
	public void sendMessage(List<Messages> listOfMessages) {
		// TODO Auto-generated method stub
		
	}

}
