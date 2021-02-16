package com.cdac.Service;

import java.io.FileOutputStream;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.cdac.Repository.AdminRepository;
import com.cdac.Repository.LibrarianRepository;
import com.cdac.Repository.UserRepository;
import com.cdac.dto.Admin;
import com.cdac.dto.Librarian;
import com.cdac.dto.ProfilePicDetails;

import com.cdac.dto.User;
@Service
public class ProfilePicServiceImple implements ProfilePicService {
	@Autowired
	private UserRepository userRepository;
	
	
	
	public void upload(ProfilePicDetails profilePicDetails) {
		String imageUploadLocation = "E://ProjectData/";
		String uploadedFileName = profilePicDetails.getProfilePic().getOriginalFilename();
		String targetFileName = profilePicDetails.getUserId() + "-" + uploadedFileName;
		String finalTargetLocation = imageUploadLocation + targetFileName;
		try {
			FileCopyUtils.copy(profilePicDetails.getProfilePic().getInputStream(), new FileOutputStream(finalTargetLocation));
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
				
		User user = userRepository.findByUserId(profilePicDetails.getUserId());
		user.setProfilePic(targetFileName);
		userRepository.save(user);
	}



}
