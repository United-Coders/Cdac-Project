package com.cdac.Service;

import com.cdac.dto.Admin;
import com.cdac.dto.User;

import java.util.List;

import javax.mail.MessagingException;

public interface AdminService {
    boolean AddAdmin(Admin amin);
	
	List<Admin> getAllAdmins();
	
	boolean AdminValidate(Admin admin);
	
	boolean deleteAdmin(int id);
	
	Admin getAdminById(int id);
	
	boolean getAdminPass (Admin admin)throws MessagingException;
    
}
