package com.cdac.Controller;

import javax.mail.MessagingException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.Service.EmailServiceImple;
import com.cdac.dto.Admin;
import com.cdac.dto.Contact;
import com.cdac.dto.Librarian;
import com.cdac.dto.User;






@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

	private static Logger log = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private EmailServiceImple emailService;
	
	

//	@GetMapping("success")
//	public String successPage() {
//		log.info("Showing successPage...");
//		return "success";
//	}

	@GetMapping("text-email")
	public ModelAndView textEmail(Contact contact) {
		ModelAndView mav = new ModelAndView("text-email");
		mav.addObject("textEmail", contact);
		log.info("Showing Text-Based Email Form...");
		return mav;
	}

	@GetMapping("attachment-email")
	public ModelAndView attachmentEmail(Contact contact) {
		ModelAndView mav = new ModelAndView("attachment-email");
		mav.addObject("attachmentEmail", contact);
		log.info("Showing Attachment-Based Email Form...");
		return mav;
	}

	//@PostMapping("sendText")
	@RequestMapping(value = "sendText", method = RequestMethod.POST)
	//public ModelAndView sendSimpleEmail(@Valid @ModelAttribute("textEmail") Contact contact, BindingResult br)
	
	public String sendSimpleEmail(@Valid @RequestBody  Contact contact, BindingResult br)
			throws MessagingException {
		try {
			System.out.println("hieeeeeeee");
			String mav = new String("success");
			log.info("Spring Boot - Sending Text Email...");
			if (br.hasErrors()) {
				log.error("Something gone wrong...");
				return new String("text-email");
			} else {
				log.info(contact.getName() + " " + contact.getPhone() + " " + contact.getEmail() + " "
			+ contact.getSubject() + " " + contact.getComment());
				contact.setName(contact.getName());
				contact.setPhone(contact.getPhone());
				contact.setEmail(contact.getEmail());
				contact.setSubject(contact.getSubject());
				contact.setComment(contact.getComment());
//	            ModelAndView v1  = new ModelAndView();
//				v1.addObject("name", contact.getName());
				log.info("Sening Text Email...");
				emailService.sendSimpleEmail(contact);
				log.info("Done...");
			}
			return mav;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new String("text-email");
		}
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(value = "sendAttachmentEmail", consumes = "multipart/form-data", method = RequestMethod.POST)
	public String sendEmailWithAttachment(@Valid @ModelAttribute("attachmentEmail") Contact contact,
			BindingResult br, final @RequestParam("attachment") MultipartFile attachFile) throws MessagingException {
		try {
			String mav = new String("success");
			log.info("Spring Boot - Sending Attachment Email...");
			if (br.hasErrors()) {
				log.error("Something gone wrong...");
				return new String("attachment-email");
			} else {
				// reads form input
				final String email = contact.getEmail();
				final String phone = contact.getPhone();
				final String name = contact.getName();
				final String subject = contact.getSubject();
				final String comment = contact.getComment();

				log.info(name + " " + phone + " " + email + " " + subject + " " + comment);

				if ((attachFile != null) && (attachFile.getSize() > 0) && (!attachFile.equals(""))) {
					log.info("FileName=====" + attachFile.getOriginalFilename());
				} else {
					log.info("FileName=====" + attachFile.getOriginalFilename() + " " + attachFile);
				}
				contact.setName(name);
				contact.setPhone(phone);
				contact.setEmail(email);
				contact.setSubject(subject);
				contact.setComment(comment);
			//	mav.addObject("name", contact.getName());
				log.info("Sening Attachment Email...");
				emailService.sendAttachmentEmail(contact, attachFile);
				log.info("Done...");
				return mav;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return new String("attachment-email");
		}
	}
	
	
	@RequestMapping(value = "sendcontact", method = RequestMethod.POST)
	//public ModelAndView sendSimpleEmail(@Valid @ModelAttribute("textEmail") Contact contact, BindingResult br)
	
	public String sendEmail(@Valid @RequestBody  Contact contact, BindingResult br)
			throws MessagingException {
		try {
			
			String mav = new String("success");
			log.info("Spring Boot - Sending Text Email...");
			if (br.hasErrors()) {
				log.error("Something gone wrong...");
				return new String("text-email");
			} else {
				log.info(contact.getName() + " " + contact.getPhone() + " " + contact.getEmail() + " "
			+ contact.getSubject() + " " + contact.getComment());
				contact.setName(contact.getName());
				contact.setPhone(contact.getPhone());
				contact.setEmail(contact.getEmail());
				contact.setSubject(contact.getSubject());
				contact.setComment(contact.getComment());
//	            ModelAndView v1  = new ModelAndView();
//				v1.addObject("name", contact.getName());
				log.info("Sening Text Email...");
				emailService.sendEmail(contact);
				log.info("Done...");
			}
			return mav;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new String("text-email");
		}
	}
	
	
	
	public void  sendPasswordEmail1(User user)
			throws MessagingException {
				try {

					Contact contact = new Contact();
					contact.setName(user.getFirstname());
					contact.setPhone(user.getContact());
					contact.setEmail(user.getEmail());
					contact.setSubject("Your Password for R-Books Website");
					contact.setComment("Your Password is "+ user.getPassword());
					emailService.sendSimpleEmail(contact);
				} catch (Exception e) {
			log.error(e.getMessage());
//			return new String("text-email");
		}
	
	
	
	
}
	
	
	
	
	public void  sendPasswordEmail2(Librarian librarian)
			throws MessagingException {
				try {

					Contact contact = new Contact();
					contact.setName(librarian.getName());
					contact.setPhone(librarian.getPhone());
					contact.setEmail(librarian.getEmail());
					contact.setSubject("Your Password for R-Books Website");
					contact.setComment("Your Password is "+ librarian.getPassword());
					emailService.sendSimpleEmail(contact);
				} catch (Exception e) {
			log.error(e.getMessage());
//			return new String("text-email");
		}
				
		
}
	
	public void  sendPasswordEmail3(Admin admin)
			throws MessagingException {
				try {

					Contact contact = new Contact();
					contact.setName(admin.getFirstName());
					contact.setPhone(admin.getPhone());
					contact.setEmail(admin.getEmail());
					contact.setSubject("Your Password for R-Books Website");
					contact.setComment("Your Password is "+ admin.getPassword());
					emailService.sendSimpleEmail(contact);
				} catch (Exception e) {
			log.error(e.getMessage());
//			return new String("text-email");
		}
	}
}
