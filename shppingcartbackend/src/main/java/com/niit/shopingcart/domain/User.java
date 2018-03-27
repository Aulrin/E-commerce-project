package com.niit.shopingcart.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component 
@Entity  
@Table(name="user") 
public class User {
	 
	@Id
	private String emailID;
	
	
	private String name;
	
	@Column(name="password")
	private String pwd;

	private String mobile;
	private Character role;
	private String registeredDate;
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Character getRole() {
		return role;
	}
	public void setRole(Character role) {
		
		this.role = 'C';
	}
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = new Date(System.currentTimeMillis())+"";
	}
	
}
