package com.cdac.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cdac.dto.User;

@Service
public class NotificationService {

	
	
private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	
	public void sendNotificaitoin(User user) throws MailException {
		// send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("akashschaudhari@gmail.com");
		mail.setSubject("Toys for Shots is coming soon!");
		mail.setText("This is a cool email notificaiton");
		
		javaMailSender.send(mail);
	}
}
