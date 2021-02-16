package com.cdac.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePicDetails {
	private int userId;
	private MultipartFile profilePic;
	
	
	

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public MultipartFile getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}
	
	
}
