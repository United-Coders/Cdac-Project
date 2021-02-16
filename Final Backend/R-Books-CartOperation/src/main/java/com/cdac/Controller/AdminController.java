package com.cdac.Controller;



import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Repository.AdminRepository;
import com.cdac.Service.AdminService;
import com.cdac.dto.Message;
import com.cdac.dto.User;
import com.cdac.exception.ResourceNotFoundException;
import com.cdac.dto.Admin;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	
	
	@PostMapping(value = "registerAdmin")
	public Message index(@RequestBody Admin admin) {
			System.out.println(admin);
			if(adminService.AddAdmin(admin)) {
				return new Message("Admin Registered", true);
			}
			
			return new Message("Admin Already Registered", false);
	}
	
	@PostMapping(value = "AdminValidate")
	public Message adminValidate(@RequestBody Admin admin) {
			System.out.println(admin);
			if(adminService.AdminValidate(admin)) {
				return new Message("Admin Validated", true);
			}
			return new Message("Invalid Credentials", false);
	}
	
	
	@DeleteMapping(value = "deleteAdmin/{id}")
	public Message deleteAdmin(@PathVariable int id) {
			System.out.println(id);
			adminService.deleteAdmin(id);
			return new Message("Record Removed",true);
	}
	
	@GetMapping(value = "display1" )
	public List<Admin> getAdmins() {
			//System.out.println(id);
			
			return adminService.getAllAdmins();
	}
	
	@GetMapping("/getadmin/{id}")
	public ResponseEntity<Admin> getUserById(@PathVariable Integer id) {
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));
		return ResponseEntity.ok(admin);
	}
	
	
	
	@PutMapping("/update-admin/{id}")
	public ResponseEntity<Admin> updateUser(@PathVariable Integer id, @RequestBody Admin AdminDetails){
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));
		
		admin.setFirstName(AdminDetails.getFirstName());
		admin.setLastName(AdminDetails.getLastName());
		admin.setEmail(AdminDetails.getEmail());
		admin.setPassword(AdminDetails.getPassword());
		admin.setPhone(AdminDetails.getPhone());
	
		
		Admin updatedAdmin = adminRepository.save(admin);
		System.out.println(updatedAdmin);
		return ResponseEntity.ok(updatedAdmin);
	}
	
	

	@PostMapping(value = "getAdminPass")
	public Message getAdminPass(@RequestBody Admin admin) throws MessagingException {
			System.out.println(admin.getEmail());
			if(adminService.getAdminPass(admin)) {
				return new Message("Your Password is send to your Registerd Email Id", true);
				
			}
		
			return new Message("Invalid Email Id", false);
	}
	
	
	
	
//	@RequestMapping(value = "/getDateAndTime")
//	public String getDateAndTime() {
//	
//	    var now = LocalDateTime.now();
//	    var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//	    var date_time = dtf.format(now);
//	
//	    var params = new HashMap<String, Object>();
//	    params.put("date_time", date_time);
//	    return params.toString();
//	  //  return new ModelAndView("showMessage", params).toString();
//	}
	
}
