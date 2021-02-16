package com.cdac.Service;



import org.springframework.web.multipart.MultipartFile;

import com.cdac.dto.Contact;

import javax.mail.MessagingException;



public interface EmailService {

public void sendSimpleEmail(Contact contact) throws MessagingException;

public void sendEmail(Contact contact) throws MessagingException;
	
	public void sendAttachmentEmail(Contact contact, MultipartFile file) throws MessagingException;
	
	public void sendPasswordEmail(Contact contact) throws MessagingException;

}
