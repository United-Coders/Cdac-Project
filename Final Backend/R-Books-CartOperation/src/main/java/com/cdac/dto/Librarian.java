package com.cdac.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "librarian")
public class Librarian {

	
	   @Id
	   @GeneratedValue
	   private int lib_id;
	   private String name;
	   private String email;
	   private String password;
	   private String phone;
	   private String licence_no;
	   private String address;
	   public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	   }
	public int getLib_id() {
		return lib_id;
	}
	public void setLib_id(int lib_id) {
		this.lib_id = lib_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLicence_no() {
		return licence_no;
	}
	public void setLicence_no(String licence_no) {
		this.licence_no = licence_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	   
	   
	   
	   
	   
	  
}
