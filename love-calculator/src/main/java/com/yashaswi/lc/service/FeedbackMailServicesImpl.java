package com.yashaswi.lc.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class FeedbackMailServicesImpl implements FeedBackMailServices {
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendMailToUser(String userName, String mailId) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailId);
		message.setSubject("Love Calculator Feedback greeting");
		message.setText("Hello Mr."+userName+"\nYour feedback to the Love calculator has been "
				+ "successfully recived and we will Improve our app more in future.");
		
		mailSender.send(message);

	}

	public void sendMailToAdmin(String mailId, String userName, String feedback) throws MessagingException {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
		
		messageHelper.setTo(mailId);
		messageHelper.setSubject("User Feedback information");
		messageHelper.setText("UserName: "+userName);
		messageHelper.setText("mailId: "+ mailId);
		messageHelper.setText("Feedback: "+feedback);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\yashw\\Downloads\\thankyou.jpg"));
		messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		mailSender.send(message);
	}

}
