package com.marketplace.Controllers;
import com.marketplace.*;
import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Login;
import com.marketplace.Entity.Student;
import com.marketplace.Services.StudentService;

import java.security.spec.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
public class StudentController {
	@Autowired 
	       StudentService studentservice;
	
	@PostMapping("/register")
	//@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<String> registerUser(@RequestBody Student newStudent) throws Exception
	{
		String res="";
		Student s1= studentservice.getStudentById(newStudent.getId());
		if(s1!=null)
		{
			 res= "Student is already registered";
			 System.out.println(res);
			return new ResponseEntity<String>(res, HttpStatus.OK);
		}
		else
		{
		System.out.println("Inside the method");
		System.out.println("Student object is "+ newStudent);
		String password= newStudent.getPassword();
		 String encrypted_password = Base64.getEncoder().encodeToString(password.getBytes()); 
	        System.out.println("The encrypted password is "+ encrypted_password );
	        decrypt(encrypted_password);
	        newStudent.setPassword(encrypted_password);
	        newStudent.setConfirmPassword(encrypted_password);
	        res= newStudent.getFirstName()+" is registered successfully";
	        System.out.println(res);
	        studentservice.save(newStudent); 
		    return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}
	

	public String decrypt(String encryptedString) {
		byte bytes[] = Base64.getDecoder().decode(encryptedString);
		String decryptedString = new String(bytes);
        System.out.println("Plain Text : "+new String(bytes));
        return decryptedString;
        
    }
	
	@PostMapping("/login")
	//@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<String> checkLogin(@RequestBody Login login)
	{
		System.out.println("Inside the method Login");
		System.out.println("The user name is "+login.getUserName());
		Student s1= studentservice.getStudentById(login.getUserName());
		System.out.println(s1);
		
		if(s1!=null) {
			System.out.println("Inside the decrypt methods");
			String decrypted_password= decrypt(s1.getPassword());
			if(login.getPassword().equals(decrypted_password))
			{
				return new ResponseEntity<>("Login successful", HttpStatus.OK);
			}
	        else
	        {
	        	return new ResponseEntity<>("Incorrect Username or password", HttpStatus.OK);
	        }
		}
		else
		{
			return new ResponseEntity<>("User is not registered, Please sign in", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getUserProfile(@PathVariable("id") String sID)
	{
		System.out.println("inside the user profile");
		Student profile= studentservice.getStudentById(sID);
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}

	@PutMapping("/updateProfile/{id}")
    public Student updateProfile(@PathVariable("id") String id, @RequestBody Student updatedProfile){
		
		Student profile= studentservice.getStudentById(id);
		if(profile!=null)
		{
			profile.setAddress(updatedProfile.getAddress());
			profile.setPhoneNumber(updatedProfile.getPhoneNumber());
			profile.setEmail(updatedProfile.getEmail());
			profile.setCity(updatedProfile.getCity());
			profile.setZip(updatedProfile.getZip());
			profile.setState(updatedProfile.getState());
			profile.setFirstName(updatedProfile.getFirstName());
			profile.setLastName(updatedProfile.getLastName());
		
			studentservice.save(profile);
			return profile;
		}
		
		return profile;
       
    }
}
