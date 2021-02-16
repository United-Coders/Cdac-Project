package com.cdac.Service;

import com.cdac.dto.Books;
import com.cdac.dto.User;

import java.util.List;

import javax.mail.MessagingException;

public interface UserService {
    int AddUser(User user);
	
	List<User> getAllUsers();
	
	User UserValidate(User user);
	
 //  boolean ValidatePass(User user);
	
	boolean deleteUser(int id);
	
	
	
    User getUserById(int id);
	
	User get(int userId);
    
	
	boolean getUserPass (User user)throws MessagingException;
}
