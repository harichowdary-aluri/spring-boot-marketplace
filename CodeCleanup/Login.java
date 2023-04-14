/**
 * @Author: Your name
 * @Date:   2023-02-17 19:36:33
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-04-14 12:10:07
 */
package com.marketplace.Entity;

import javax.persistence.Entity;

public class Login {
	
	// Adding User and password
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
