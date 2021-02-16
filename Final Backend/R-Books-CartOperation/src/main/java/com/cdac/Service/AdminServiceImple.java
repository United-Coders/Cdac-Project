package com.cdac.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Controller.EmailController;
import com.cdac.Repository.AdminRepository;
import com.cdac.dto.Admin;
import com.cdac.dto.Librarian;



@Service
public class AdminServiceImple implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private EmailController emailController;

	@Override
	public boolean AddAdmin(Admin admin) {
		if(null == adminRepository.save(admin)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Admin> getAllAdmins() {
		Iterable<Admin> UI = adminRepository.findAll();
		Iterator<Admin> UItr = UI.iterator();
		List<Admin> ULi = new ArrayList<Admin>();
		while(UItr.hasNext()) {
			ULi.add(UItr.next());
		}
		return ULi;
	}

	@Override
	public boolean AdminValidate(Admin admin) {
		if(adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAdmin(int id) {
		adminRepository.deleteById(id);
		return true;
	}

	@Override
	public Admin getAdminById(int id) {
		return adminService.getAdminById(id);
	}

	@Override
	public boolean getAdminPass(Admin admin) throws MessagingException {
		if(adminRepository.findByEmail(admin.getEmail())!= null) {
			
			Admin us1 = adminRepository.findByEmail(admin.getEmail());
			
			emailController.sendPasswordEmail3(us1);
		
			
			return true;
		}
		
		return false;
	}

	

}
