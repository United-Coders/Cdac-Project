package com.cdac.Controller;



import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.cdac.Repository.UserRepository;
import com.cdac.Service.NotificationService;
import com.cdac.Service.ProfilePicService;
import com.cdac.Service.UserService;
import com.cdac.dto.Books;
import com.cdac.dto.Message;
import com.cdac.dto.ProfilePicDetails;
import com.cdac.dto.RegisterStatus;
import com.cdac.dto.Status;
import com.cdac.dto.Status.StatusType;
import com.cdac.dto.User;
import com.cdac.exception.ResourceNotFoundException;
import com.cdac.exception.ServiceException;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    
private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private ProfilePicService profilePicService;
	
	
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	

	
	@PostMapping(value = "registerUser")
	public RegisterStatus register(@RequestBody User user) {
		try {
			int id = userService.AddUser(user);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful!");
			status.setRegisteredUserId(id);
			return status;
		}
		catch(ServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping(value = "UserValidate")
	public User userValidate(@RequestBody User user) {
			System.out.println(user);
			return userService.UserValidate(user);
	}
//	
//	@PostMapping("/forgetpassword")
//	public String forgetPass(@RequestBody User user)
//	{
//		
//		 userService.ValidatePass(user);
//		 
//		return "successfully updated";
//		
//	}
	
//	@PostMapping("/forgetpassword")
//	public String forgetPass(@RequestBody User user)
//	{
//		
//		userRepository.updatePass(user.getEmail(),user.getPassword());
//		 
//		return "successfully updated";
//		
//
//	
//	}
	
	
	@DeleteMapping(value = "deleteUser/{id}")
	public Message deleteUser(@PathVariable int id) {
			System.out.println(id);
			userService.deleteUser(id);
			return new Message("Record Removed",true);
	}
	
	@GetMapping(value = "display" )
	public List<User> getUsers() {
			//System.out.println(id);
			
			return userService.getAllUsers();
	}
	
	
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	
	
	@PutMapping("/update-user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User UserDetails){
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		user.setFirstname(UserDetails.getFirstname());
		user.setLastname(UserDetails.getLastname());
		user.setEmail(UserDetails.getEmail());
		user.setPassword(UserDetails.getPassword());
		user.setContact(UserDetails.getContact());
	
		
		User updatedUser = userRepository.save(user);
		System.out.println(updatedUser);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	
	

	@PostMapping("/pic-upload")
	public Status upload(ProfilePicDetails profilePicDetails) {
		profilePicService.upload(profilePicDetails);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Upload successful!");
		return status;
	}
	
	@GetMapping("/profile")
	public User profile(@RequestParam("userId") int userId, HttpServletRequest request) {
		User user = userService.get(userId);
				
		String projPath = request.getServletContext().getRealPath("/");
		String downloadPath = projPath + "/downloads/";
		System.out.println(downloadPath);
		File f = new File(downloadPath);
		if(!f.exists())
			f.mkdir();
		
		
		String uploadedPath = "E://ProjectData/";
		String uploadedFileName = user.getProfilePic();
		
		String sourceFile = uploadedPath + uploadedFileName;
		String destinationFile = downloadPath + uploadedFileName;
		try {
			FileCopyUtils.copy(new File(sourceFile), new File(destinationFile));
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
		
		return user;
	}
	
	 
	
	
	
	
	
	@RequestMapping(value = "registerUser1", method = RequestMethod.POST)
	public String signupSuccess(){
		
		
		
		User user = new User();
		System.out.println("hey");
		
		// send a notification
		try {
			notificationService.sendNotificaitoin(user);
		}catch( MailException e ){
			// catch error
			logger.info("Error Sending Email: " + e.getMessage());
		}
		
		return "Thank you for registering with us.";
	}
	
	
	
	
	@PostMapping(value = "getUserPass")
	public Message getUserPass(@RequestBody User user) throws MessagingException {
			System.out.println(user.getEmail());
			if(userService.getUserPass(user)) {
				
				System.out.println(user.getPassword()+" is working");
				
				System.out.println(user.getEmail()+" is working");
				return new Message("Your Password is send to your Registerd Email Id", true);
				
			}
			System.out.println(user.getContact()+"not working");
			return new Message("Invalid Email Id", false);
	}
	
	
}	
	
	
	
	
	
	
	
	
