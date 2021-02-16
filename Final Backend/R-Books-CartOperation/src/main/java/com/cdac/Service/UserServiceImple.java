package com.cdac.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Controller.EmailController;
import com.cdac.Repository.UserRepository;
import com.cdac.dto.Books;
import com.cdac.dto.User;
import com.cdac.exception.ServiceException;



@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailController emailController;
	
	//@Autowired
	private BasicTextEncryptor passwordEncryptor;

	@Override
	public int AddUser(User user) {
		if(!userRepository.existsById(user.getUserId())) {
			
			passwordEncryptor = new BasicTextEncryptor();
			passwordEncryptor.setPassword("secret-key");
			user.setPassword(passwordEncryptor.encrypt(user.getPassword()));

			
			userRepository.save(user);
			return user.getUserId();
			//suppose we want to send an email confirmation
			//then that code will be here..
		}
		else
			throw new ServiceException("Customer already registered!");
	
	}
	
	
//	
//	@Override
//	public int AddUser(User user) {
//		if(!userRepository.existsById(user.getUserId())) {
//			userRepository.save(user);
//			return user.getUserId();
//			//suppose we want to send an email confirmation
//			//then that code will be here..
//		}
//		else
//			throw new ServiceException("Customer already registered!");
//	
//	}

	@Override
	public List<User> getAllUsers() {
		Iterable<User> UI = userRepository.findAll();
		Iterator<User> UItr = UI.iterator();
		List<User> ULi = new ArrayList<User>();
		while(UItr.hasNext()) {
			ULi.add(UItr.next());
		}
		return ULi;
	}

	@Override
	public User UserValidate(User user) {
		
		User user1 = userRepository.findByEmail(user.getEmail());
		
		passwordEncryptor = new BasicTextEncryptor();
		passwordEncryptor.setPassword("secret-key");
		String password1= passwordEncryptor.decrypt(user1.getPassword());
		
		if(!password1.equals(user.getPassword()) ) 
			user1 =null;

		return user1;
		
		//return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()) ;
	}

	
	
	@Override
	public boolean deleteUser(int id) {
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public User getUserById(int id) {
		return userService.getUserById(id);
	}

	@Override
	public User get(int userId) {
		return userRepository.findByUserId(userId);
	
	}

	@Override
	public boolean getUserPass(User user) throws MessagingException {
		System.out.println(user.getEmail()+" in getpass method working***************************************");
		if(userRepository.findByEmail(user.getEmail())!= null) {
			System.out.println(userRepository.findByEmail(user.getEmail())+"before email method working+++++++++++++++++++++++");
			//emailService.sendPasswordEmail(user);
			User us1 = userRepository.findByEmail(user.getEmail());
			System.out.println(us1.getLastname()+"after email method working))))))00000000000000000000000000000+++++++++++++++++++++");
			emailController.sendPasswordEmail1(us1);
			//emailService.sendPasswordEmail(us1);
			System.out.println(us1.getPassword()+"after email method workingxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			return true;
		}
		System.out.println(user.getContact()+"after find email method is false workingyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		return false;
	}
	

	

}
