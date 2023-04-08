package com.marketplace.Controllers;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketplace.Entity.Login;
import com.marketplace.Entity.Student;
import com.marketplace.Services.StudentService;

public class LoginController {
	

	@Autowired 
	       StudentService studentservice;
	
	
	public String decrypt(String encryptedString) {
		byte bytes[] = Base64.getDecoder().decode(encryptedString);
		String decryptedString = new String(bytes);
        System.out.println("Plain Text : "+new String(bytes));
        return decryptedString;
        
    }
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String email) {

		String response = userService.forgotPassword(email);

		if (!response.startsWith("Invalid")) {
			response = "http://localhost:8080/reset-password?token=" + response;
		}
		return response;
	}