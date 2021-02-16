package com.cdac.dto;

public class RegisterStatus extends Status {

	private int registeredUserId;
	
	private int registerLibId;
	
	private int registerAdminId;

	public int getRegisterLibId() {
		return registerLibId;
	}

	public void setRegisterLibId(int registerLibId) {
		this.registerLibId = registerLibId;
	}

	public int getRegisterAdminId() {
		return registerAdminId;
	}

	public void setRegisterAdminId(int registerAdminId) {
		this.registerAdminId = registerAdminId;
	}

	public int getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(int registeredUserId) {
		this.registeredUserId = registeredUserId;
	}

	
}
