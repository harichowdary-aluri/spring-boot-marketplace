package com.marketplace.Entity;

import javax.persistence.Entity;

public class Login {
	
	
	private String username;
	private String password;
	
	public Login(String username, String password)
	{
		this.username= username;
		this.password= password;
	}
	public String getUserName() {
		return this.username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
