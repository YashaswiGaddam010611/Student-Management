package com.yashaswi.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServicesImpl implements MailServices{
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String userName,String crushName, String mailId, String result) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailId);
		message.setSubject("Love calculator Prediction");
		message.setText("Hi "+crushName+" Love calculator predicted that you and "+userName+" are "+result);
		
		mailSender.send(message);
	}
}
