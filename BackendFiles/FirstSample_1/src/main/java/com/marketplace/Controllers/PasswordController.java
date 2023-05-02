package com.marketplace.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.Entity.Student;
import com.marketplace.Repository.StudentRepository;
import com.marketplace.Services.StudentService;
import com.marketplace.dto.ResetPasswordRequest;

@RestController
@RequestMapping("/api/password")
@CrossOrigin("*")
public class PasswordController {

  @Autowired
  private StudentService userService;
  @Autowired
  private StudentRepository studentRepository;

  @PostMapping("/reset")
  public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) throws Exception {
	  String res="";
    // Call the user service to handle the password reset logic
	  System.out.println("The otp is "+ request);
	  Student user = studentRepository.findByEmail(request.getEmail());
	  String api_otp= request.getOtp();
	  System.out.println("api otp is "+api_otp);
	  String user_otp= user.getOtp();
	  System.out.println("user otp is "+ user_otp);
	  String newPassword= request.getNewPassword();
	  String confirmPassword= request.getConfirmPassword();
	  if(!api_otp.equalsIgnoreCase(user_otp))
	  {
		  System.out.println("inside the different");
		  res="Invalid OTP";
		  //return new ResponseEntity<>(res, HttpStatus.OK);
	  }
	  else if (!newPassword.equals(confirmPassword)) {
			res= "New password and confirm password do not match";
			//return new ResponseEntity<>(res, HttpStatus.OK);
		}
	  
	  else
	  {
		  userService.resetPassword(request.getEmail(), request.getOtp(), request.getNewPassword(), request.getConfirmPassword());
		  //return new ResponseEntity<>(res, HttpStatus.OK);
	  }
	  System.out.println(res + "resr");
	  return new ResponseEntity<>(res, HttpStatus.OK);
	  
     }
    
  @PostMapping("/sendResetOtp")
  public ResponseEntity<String> sendResetOtp(@RequestParam("email") String email) throws Exception {
	  String res= "";
    // Call the user service to handle the password reset logic
		Student user = studentRepository.findByEmail(email);
		
		// Check if the user exists and if the OTP matches
		if (user == null ) {
			res= "Invalid user";
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		 
    userService.sendResetOtp(email);
    res= "OTP is sent";

    return new ResponseEntity<>(res, HttpStatus.OK);
  }
  
  
}

