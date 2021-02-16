package com.cdac.dto;

public class Message {
	String message;
	boolean flag;
	public Message(String message, boolean flag) {
		super();
		this.message = message;
		this.flag = flag;
	}
	
	public Message() {
		super();
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Message [message=" + message + ", flag=" + flag + "]";
	}
   
}
